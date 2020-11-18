package com.service.leave;

import com.pojo.leave.Leave;
import com.pojo.reimbursement.ReimForm;

import java.util.Date;
import java.util.List;

public interface LeaveFormService {
    List<Leave> getAllLeaveForms(String name);

    int addLeaveForm(Leave leave);

    int delLeaveForm(String id);

    List<Leave> getLeaveFormsBystate(int state);

    List<Leave> getAllLeave();

    int updateLeaveFormState(String id, int state, Date date);

}
