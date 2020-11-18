package com.service.reimbursement;

import com.pojo.reimbursement.ReimForm;

import java.util.Date;
import java.util.List;

public interface ReimFormService {
    List<ReimForm> getAllReimForms(String staName);

    int addReimForm(ReimForm reimForm);

    int delReimForm(String id);

    List<ReimForm> getReimFormsBystate(int state);

    int updateReimFormState(String id, int state, Date date);
}
