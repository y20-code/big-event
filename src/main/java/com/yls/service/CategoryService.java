package com.yls.service;

import com.yls.pojo.Category;

import java.util.List;

public interface CategoryService {
    //新增分类
    void add(Category category);

    //列表查询
    List<Category> list();

    //根据id查询信息
    Category findById(Integer id);

    //跟新分类
    void update(Category category);
}
