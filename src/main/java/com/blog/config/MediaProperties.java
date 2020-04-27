package com.blog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 磁盘媒体文件目录格式;win:‘F:\\xxx\\xxx’,lin:‘/xxx/xxx’
 * @description: none
 * @git: https://github.com/VictorLeeFC
 * @date: 2020/4/21 0:30
 * @author: li
 * @version: v0.1
 */

@ConfigurationProperties(prefix = "media.paths")
public class MediaProperties {
    /** 磁盘音乐目录win:‘F:\\xxx\\xxx’,lin:‘/xxx/xxx’ 数组形式配置1为win，2为lin */
    private String[] musicPath;
    /** 磁盘图片目录win:‘F:\\xxx\\xxx’,lin:‘/xxx/xxx’ 数组形式配置1为win，2为lin */
    private String[] imagePath;


    public MediaProperties(String[] musicPath, String[] imagePath) {
        this.musicPath = musicPath;
        this.imagePath = imagePath;
    }

    public MediaProperties() {
    }

    public String[] getMusicPath() {
        return musicPath;
    }

    public void setMusicPath(String[] musicPath) {
        this.musicPath = musicPath;
    }

    public String[] getImagePath() {
        return imagePath;
    }

    public void setImagePath(String[] imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "MediaProperties{" +
                "musicPath='" + musicPath + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
