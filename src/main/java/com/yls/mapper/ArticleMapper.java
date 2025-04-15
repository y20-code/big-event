package com.yls.mapper;

import com.yls.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Insert("insert into article(title,content,cover_img,state,category_id,create_user,create_time,update_time)" +
            "values(#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},#{createTime},#{updateTime})")
    void add(Article article);


    List<Article> list(Integer id, Integer categoryId, String state);

    @Delete("delete from article where id=#{id}")
    void delete(Integer id);

    //删除文章分类id
    @Delete("delete from article where id=#{id}")
    void deleteBycateoryId(Integer id);
}
