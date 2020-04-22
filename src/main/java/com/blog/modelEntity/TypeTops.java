package com.blog.modelEntity;

import lombok.*;

/**
 * @description: some desc
 * @git: https://github.com/VictorLeeFC
 * @date: 2020-03-23
 * @author: li
 * @version: v0.1
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TypeTops implements Comparable<TypeTops> {
    private Integer typeId;
    private String name;
    private Integer blogNumber;

    @Override
    public int compareTo(TypeTops o) {
        return o.blogNumber - this.blogNumber;
    }
}
