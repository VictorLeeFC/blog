package com.blog.controller.admin;

import com.blog.config.MediaProperties;
import com.blog.util.RedisKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: some desc
 * @git: https://github.com/VictorLeeFC
 * @date: 2020/4/21 0:26
 * @author: li
 * @version: v0.1
 */
@Controller
@RequestMapping(value = "/admin")
@EnableConfigurationProperties(MediaProperties.class)
public class MediaController {

    @Autowired
    private MediaProperties mediaProperties;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /** /media/music */

    @GetMapping("/media/music")
    public ResponseEntity<Map<String,Object>> media(){
        //创建一个容器包装要传递的数据
        Map<String,Object> resp = new HashMap<>();
        //先从缓存中去看有没有数据
        Boolean hasKey = this.stringRedisTemplate.hasKey(RedisKeyUtils.MEDIA_MUSIC);
        if (hasKey){
            Map<Object, Object> cacheMap = this.stringRedisTemplate.opsForHash().entries(RedisKeyUtils.MEDIA_MUSIC);
            if (cacheMap != null && !cacheMap.isEmpty()) {
                cacheMap.forEach((k,v)-> resp.put(k.toString(),v));
                return ResponseEntity.ok(resp);
            }
        }
        try {
            //获得硬盘的文件
            String musics = getHardDiskDriveFileNames(mediaProperties.getMusicPath());
            String images = getHardDiskDriveFileNames(mediaProperties.getImagePath());
            //判断一下
            if(musics!=null && musics!=""){
                resp.put("musics",musics);
            }
            if(images!=null && images!=""){
                resp.put("images",images);
            }
            if (resp!=null && !resp.isEmpty()) {
                this.stringRedisTemplate.opsForHash().putAll(RedisKeyUtils.MEDIA_MUSIC, resp);
                return ResponseEntity.ok(resp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.noContent().build();
    }

    /** /media/image */


    /**
     * 通过路径获得该路径下的所有文件名
     * @param directory win格式：C:\\XXX\\xxx ,linux格式：/xxx/xxx
     * @return 以,号间隔的文件名包含后缀的字符串。
     * @throws IOException
     */
    private String getHardDiskDriveFileNames(String directory) throws IOException {
        if (directory == null || directory == "") {
            return null;
        }
        //实例化这个目录
        File f = new File(directory);
        if(!f.isDirectory()){
            return directory + "不是当前系统环境的目录!";
        }
        //获得这个目录下所有的文件名
        String[] names = f.list();
        if (names==null || names.length==0){
            return "该路径下没有文件";
        }
        //字符数组拼接为,号间隔的字符串。
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(name);
            sb.append(",");
        }
        return StringUtils.substring(sb.toString(), 0, sb.toString().length() - 1);
    }

}
