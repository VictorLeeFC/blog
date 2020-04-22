package com.blog.po;

import lombok.*;

import javax.persistence.Id;

/**
 * @description: some desc
 * @git: https://github.com/VictorLeeFC
 * @date: 2020-02-28
 * @author: li
 * @version: v0.1
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlogTag {
    @Id
    private Integer blogTagId;
    private Integer blogId;
    private Integer TagId;
}
