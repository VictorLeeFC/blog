package com.blog.service;

import com.blog.modelEntity.TypeTops;
import com.blog.po.Type;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @description: some desc
 * @git: https://github.com/VictorLeeFC
 * @date: 2020-03-26
 * @author: li
 * @version: v0.1
 */
public interface TypeService {

    Type saveType(Type type);

    Type getType(Integer typeId);

    Page<Type> listType();

    Type updateType(Type type);

    int deleteType(Integer id);

    Type getTypeByName(String typeName);

    List<Type> allType();

    List<TypeTops> findSeveralTypes(Integer number);

    Integer findCount();
}

