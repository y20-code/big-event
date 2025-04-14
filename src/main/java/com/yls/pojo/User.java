package com.yls.pojo;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;//主键ID
    private String username;//用户名
    @JsonIgnore //让springmvc把当前对象换成json字符串的时候，忽略password，最终的json字符串中就密钥password这个属性了
    private String password;//密码
    private String nickname;//昵称
    private String email;//邮箱
    private String userPic;//用户头像地址
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
