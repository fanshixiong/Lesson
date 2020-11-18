package com.mapper.offdoc;

import com.mapper.reimbursement.ReimFormMapper;
import com.pojo.leave.Leave;
import com.pojo.offdoc.offdocform;
import com.pojo.reimbursement.ReimForm;
import com.tools.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class offdocMapperImpl implements offdocMapper{


    @Override
    public offdocform getoffdocByID(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        offdocMapper mapper = sqlSession.getMapper(offdocMapper.class);
        offdocform formByID = mapper.getoffdocByID(id);
        sqlSession.commit();
        sqlSession.close();

        return formByID;
    }

    @Override
    public List<offdocform> getoffdocByName(String name) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        offdocMapper mapper = sqlSession.getMapper(offdocMapper.class);
        List<offdocform> offdocforms = mapper.getoffdocByName(name);
        sqlSession.commit();
        sqlSession.close();

        return offdocforms;
    }

    @Override
    public int addoffdoc(offdocform offdocform) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        offdocMapper mapper = sqlSession.getMapper(offdocMapper.class);
        int i = mapper.addoffdoc(offdocform);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public int updateoffdocAstate(offdocform offdocform) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        offdocMapper mapper = sqlSession.getMapper(offdocMapper.class);
        int i = mapper.updateoffdocAstate(offdocform);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public int deloffdoc(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        offdocMapper mapper = sqlSession.getMapper(offdocMapper.class);
        int i = mapper.deloffdoc(id);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public List<offdocform> getoffdocBySstate(int state) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        offdocMapper mapper = sqlSession.getMapper(offdocMapper.class);
        List<offdocform> offdocforms = mapper.getoffdocBySstate(state);
        sqlSession.commit();
        sqlSession.close();

        return offdocforms;
    }

    @Override
    public List<offdocform> getoffdoc() {
        return null;
    }

    @Override
    public int updateoffdocSstate(String id, Integer state, Date date) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        offdocMapper mapper = sqlSession.getMapper(offdocMapper.class);
        int i = mapper.updateoffdocSstate(id, state, date);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }
   @Test
    public void test(){
        //System.out.println(getoffdocByName("lys"));
   }
}
