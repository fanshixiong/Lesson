package com.pojo.leave;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //getter/setter方法
@AllArgsConstructor
@NoArgsConstructor  //无参构造函数
public class Teacher {
    private String id;
    private String teaName;
    private String teaGender;
    private Integer teaAge;
    private Integer post; //职位
}
