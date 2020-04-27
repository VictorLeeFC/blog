package com.blog.controller.admin;

import com.blog.config.MediaProperties;
import com.blog.util.RedisKeyUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    @Autowired
    private static final ObjectMapper om = new ObjectMapper();
    /** /media/music */

    @GetMapping("/media")
    public ResponseEntity<Map<String,String>> media(){

        //创建一个容器包装要传递的数据
        Map<String,String> resp = new HashMap<>();
        //先从缓存中去看有没有数据
        boolean hasKey = this.stringRedisTemplate.hasKey(RedisKeyUtils.MEDIA_MUSIC);
        if (hasKey){
            Map<Object, Object> cache = this.stringRedisTemplate.opsForHash().entries(RedisKeyUtils.MEDIA_MUSIC);
            if (cache != null && !cache.isEmpty()) {

                cache.forEach((k,v)-> resp.put((String)k,(String)v));

                if(!resp.isEmpty() && resp.size() > 0){
                    return ResponseEntity.ok(resp);
                }
                this.stringRedisTemplate.delete(RedisKeyUtils.MEDIA_MUSIC);
            }
        }
        try {
            //System.out.println("-------1------controller调用读取磁盘文件方法------------");
            String[] musics;
            String[] images;
            //获得硬盘的文件
            //判断是哪个系统
            boolean isWin = System.getProperty("os.name").toLowerCase().contains("win");
            if (isWin){
                musics = getHardDiskDriveFileNames(mediaProperties.getMusicPath()[0]);
                images = getHardDiskDriveFileNames(mediaProperties.getImagePath()[0]);
            }else{
                musics = getHardDiskDriveFileNames(mediaProperties.getMusicPath()[1]);
                images = getHardDiskDriveFileNames(mediaProperties.getImagePath()[1]);
            }

            //判断一下是不是媒体文件
            if(musics[0].contains(".")){
                resp.put("musics",om.writeValueAsString(musics));
            }
            if(images[0].contains(".")){
                resp.put("images",om.writeValueAsString(images));
            }
            if (resp!=null && !resp.isEmpty()) {

                this.stringRedisTemplate.opsForHash().putAll(RedisKeyUtils.MEDIA_MUSIC,resp);

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
    private String[] getHardDiskDriveFileNames(String directory) throws IOException {
        if (directory == null || directory == "") {
            return new String[]{"路径不能为空"};
        }
        //实例化这个目录
        //System.out.println("---------2---------从这个路径读取：" + directory);
        File f = new File(directory);
        if(!f.isDirectory()){
            return new String[]{"传入的路径不是目录"};
        }
        //获得这个目录下所有的文件名
        String[] names = f.list();
        if (names==null || names.length==0){
            //System.out.println("------------------没有获取到文件");
            return new String[]{"目录下没有文件"};
        }
        //字符数组拼接为,号间隔的字符串。

        //System.out.println("---------3---------读取磁盘文件所有流程已经走通");
        return names;
    }

}
