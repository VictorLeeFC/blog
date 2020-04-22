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
public class TagTops implements Comparable<TagTops> {

    private Integer tagId;
    private String name;
    private Integer BlogNumber;

    @Override
    public int compareTo(TagTops o) {
        return o.BlogNumber - this.BlogNumber;
    }
}
