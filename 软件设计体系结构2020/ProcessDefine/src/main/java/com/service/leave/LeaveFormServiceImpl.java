package com.service.leave;

import com.mapper.leave.leave.LeaveFormMapperImpl;
import com.mapper.leave.leave.LeaveMapper;
import com.mapper.reimbursement.ReimFormMapper;
import com.mapper.reimbursement.ReimFormMapperImpl;
import com.pojo.leave.Leave;
import com.pojo.reimbursement.ReimForm;
import com.service.reimbursement.ReimFormService;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class LeaveFormServiceImpl implements LeaveFormService{
    private LeaveMapper LeaveFormMapper;

    public LeaveFormServiceImpl() {
        this.LeaveFormMapper = new LeaveFormMapperImpl();
    }

    @Override
    public List<Leave> getAllLeaveForms(String name) {
        return  LeaveFormMapper.getFormsByName(name);
    }

    @Override
    public int addLeaveForm(Leave leave) {
        return LeaveFormMapper.addLeaveForm(leave);
    }

    @Override
    public int delLeaveForm(String id) {
        return LeaveFormMapper.delLeaveForm(id);
    }

    @Override
    public List<Leave> getLeaveFormsBystate(int state) {
        return LeaveFormMapper.getLeaveFormsByState(state);
    }

    @Override
    public List<Leave> getAllLeave() {
        return LeaveFormMapper.getAllLeave();
    }

    @Override
    public int updateLeaveFormState(String id, int state, Date date) {
        if(state==0){
            state=state+1;
        }
        if(state>0){
            state=2;
        }
        return LeaveFormMapper.updateLeaveFormState(id, state, date);
    }

    @Test
    public void test(){

    }
}
