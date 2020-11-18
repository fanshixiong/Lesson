package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
      private String id;
      private String userName;      // �û���
      private String userPassword;  // ����
      private Integer identity; //��ʶ���
}
