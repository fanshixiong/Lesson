package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
      private String id;
      private String userName;      // 用户名
      private String userPassword;  // 密码
      private Integer identity; //标识身份
}
