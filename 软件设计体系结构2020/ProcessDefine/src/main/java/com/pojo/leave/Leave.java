package com.pojo.leave;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Leave {
    private String id;
    private Date createTime;  //����ʱ��
    private String creator;   //������
    private String reason;    //��������
    private Date modifyDate;  //�޸�ʱ��
    private Integer state;
}
