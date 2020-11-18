package com.service.offdoc;

import com.pojo.offdoc.offdocform;
import com.pojo.reimbursement.ReimForm;

import java.util.Date;
import java.util.List;

public interface offdocService {
    List<offdocform> getAlloffdocforms(String name);

    int addoffdoc(offdocform offdocform);

    int deloffdoc(String id);

    List<offdocform> getoffdocBySstate(int state);

    int updateoffdocSstate(String id, int state, Date date);
}
