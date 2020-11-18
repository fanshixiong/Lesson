package com.service.reimbursement;

import com.mapper.reimbursement.ReimFormMapper;
import com.mapper.reimbursement.ReimFormMapperImpl;
import com.pojo.reimbursement.ReimForm;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class ReimFormServiceImpl implements ReimFormService{
    private ReimFormMapper reimFormMapper;

    public ReimFormServiceImpl() {
        this.reimFormMapper = new ReimFormMapperImpl();
    }

    @Override
    public List<ReimForm> getAllReimForms(String staName) {
        return  reimFormMapper.getReimFormsByName(staName);
    }

    @Override
    public int addReimForm(ReimForm reimForm) {
        return reimFormMapper.addReimForm(reimForm);
    }

    @Override
    public int delReimForm(String id) {
        return reimFormMapper.delSReimForm(id);
    }

    @Override
    public List<ReimForm> getReimFormsBystate(int state) {
        return reimFormMapper.getReimFormsByState(state);
    }

    @Override
    public int updateReimFormState(String id, int state, Date date) {
        return reimFormMapper.updateReimFormState(id, state, date);
    }

    @Test
    public void test(){
        /*
        List<ReimForm> forms = getAllReimForms("frans");
        for (ReimForm form : forms) {
            System.out.println(form);
        }

        ReimForm form = new ReimForm("100003", 50, new Date(), "frans", "god", new Date(), 0);
        System.out.println(addReimForm(form));

        System.out.println(delReimForm("100004"));



        List<ReimForm> forms = getReimFormsBystate(1);
        for (ReimForm form : forms) {
            System.out.println(form);
        }

         */

        System.out.println(updateReimFormState("100003", 1, new Date()));
    }
}
