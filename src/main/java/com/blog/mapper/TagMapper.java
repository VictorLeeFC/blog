package com.blog.mapper;

import com.blog.modelEntity.TagTops;
import com.blog.po.Tag;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @description: some desc
 * @git: https://github.com/VictorLeeFC
 * @date: 2020-03-23
 * @author: li
 * @version: v0.1
 */
public interface TagMapper extends Mapper<Tag> {

    @Select("select distinct t.tag_id,t.name ,count(*) as number from tag t ,blog_tag bt where" +
            " t.tag_id = bt.tag_id group by t.tag_id, t.name order by number desc limit #{tagNumber}")
    @Results(id = "tagResultMap", value = {
            @Result(column = "tag_id", property = "tagId"),
            @Result(column = "name", property = "name"),
            @Result(column = "number", property = "BlogNumber")
    })
    List<TagTops> findSeveralTopTags(@Param(value = "tagNumber") Integer number);
}
