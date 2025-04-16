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
    @Delete("delete from article where category_id=#{id}")
    void deleteByCateoryId(Integer id);

    //查询文章详细信息
    @Select("select * from article where id=#{id}")
    List<Article> detail(Integer id);

    //更新文章信息
    @Update("update article set title=#{title},content=#{content},cover_img=#{coverImg},state=#{state},category_id=#{categoryId},update_time=#{updateTime}")
    void update(Article article);
}
