package com.pojo.leave;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  //getter/setter����
@AllArgsConstructor
@NoArgsConstructor  //�޲ι��캯��
public class Teacher {
    private String id;
    private String teaName;
    private String teaGender;
    private Integer teaAge;
    private Integer post; //ְλ
}
