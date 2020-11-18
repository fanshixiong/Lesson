package com.service.offdoc;

import com.mapper.offdoc.OffdocMapper;
import com.mapper.offdoc.OffdocMapperImpl;
import com.pojo.offdoc.Offdocform;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class OffdocServiceImpl implements OffdocService {
    private OffdocMapper offdocMapper;
    public OffdocServiceImpl(){
        this.offdocMapper=new OffdocMapperImpl();
    }

    @Override
    public List<Offdocform> getAlloffdocforms(String name) {
        return offdocMapper.getoffdocByName(name);
    }

    @Override
    public int addoffdoc(Offdocform offdocform) {
        return offdocMapper.addoffdoc(offdocform);
    }

    @Override
    public int deloffdoc(String id) {
        return offdocMapper.deloffdoc(id);
    }

    @Override
    public List<Offdocform> getoffdocBySstate(int state) {
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
