package com.pojo.reimbursement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    private String id;
    private String staName;
    private String stGender;
    private Integer staAge;
    private Integer post;
}
