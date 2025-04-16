package com.yls.service;

import com.yls.pojo.Article;
import com.yls.pojo.PageBean;
import org.apache.ibatis.annotations.Mapper;


public interface ArticleService {
    //新增文章
    void add(Article article);

    //条件分页列表查询
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    //删除文章
    void delete(Integer id);

    //根据文章分类id删除
//    void deleteByCategoryId(Integer id);
}
