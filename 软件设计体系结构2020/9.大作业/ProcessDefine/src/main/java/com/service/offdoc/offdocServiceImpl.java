package com.service.offdoc;

import com.mapper.offdoc.offdocMapper;
import com.mapper.offdoc.offdocMapperImpl;
import com.mapper.reimbursement.ReimFormMapper;
import com.mapper.reimbursement.ReimFormMapperImpl;
import com.pojo.offdoc.offdocform;
import com.pojo.reimbursement.ReimForm;
import com.service.reimbursement.ReimFormService;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class offdocServiceImpl implements offdocService{
    private offdocMapper offdocMapper;
    public offdocServiceImpl(){
        this.offdocMapper=new offdocMapperImpl();
    }

    @Override
    public List<offdocform> getAlloffdocforms(String name) {
        return offdocMapper.getoffdocByName(name);
    }

    @Override
    public int addoffdoc(offdocform offdocform) {
        return offdocMapper.addoffdoc(offdocform);
    }

    @Override
    public int deloffdoc(String id) {
        return offdocMapper.deloffdoc(id);
    }

    @Override
    public List<offdocform> getoffdocBySstate(int state) {
        return offdocMapper.getoffdocBySstate(state);
    }

    @Override
    public int updateoffdocSstate(String id, int state, Date date) {
        return offdocMapper.updateoffdocSstate(id,state,date);
    }
   @Test
    public void test(){
       System.out.println(getAlloffdocforms("lys"));
   }
}
