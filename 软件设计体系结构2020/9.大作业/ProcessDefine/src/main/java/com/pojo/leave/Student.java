package com.pojo.leave;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String id;
    private String stuName;
    private String stuGender;
    private Integer stuAge;
}
