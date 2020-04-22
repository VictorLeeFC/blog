package com.blog.mapper;

import com.blog.modelEntity.TypeTops;
import com.blog.po.Type;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @description: some desc
 * @git: https://github.com/VictorLeeFC
 * @date: 2020-03-23
 * @author: li
 * @version: v0.1
 */
public interface TypeMapper extends Mapper<Type> {

    @Select(value = "select * from type where type_id = #{id}")
    @ResultType(Type.class)
    Type selectTypeById(@Param(value = "id") String id);

    @Select("select distinct t.type_id,t.name,count(*) as number from type t,blog b " +
            "where t.type_id = b.type_id group by t.type_id order by number desc limit #{number}")
    @Results(id = "typeResult", value = {
            @Result(column = "type_id", property = "typeId"),
            @Result(column = "name", property = "name"),
            @Result(column = "number", property = "blogNumber")
    })
    List<TypeTops> selectSeveralTopTypes(@Param(value = "number") Integer number);
}
