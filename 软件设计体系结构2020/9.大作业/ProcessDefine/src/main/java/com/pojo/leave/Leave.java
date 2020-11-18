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
    private Date createTime;  //申请时间
    private String creator;   //申请人
    private String reason;    //申请理由
    private Date modifyDate;  //修改时间
    private Integer state;
}
