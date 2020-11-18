package com.pojo.reimbursement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReimForm {
    private String id;
    private Integer money;
    private Date createTime;
    private String creator;
    private String reason;
    private Date modifyDate;
    private Integer state;
}
