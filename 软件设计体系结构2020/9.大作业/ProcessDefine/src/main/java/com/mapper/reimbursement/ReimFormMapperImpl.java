package com.mapper.reimbursement;

import com.pojo.reimbursement.ReimForm;
import com.tools.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class ReimFormMapperImpl implements ReimFormMapper{
    @Override
    public ReimForm getFormByID(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ReimFormMapper mapper = sqlSession.getMapper(ReimFormMapper.class);
        ReimForm formByID = mapper.getFormByID(id);
        sqlSession.commit();
        sqlSession.close();

        return formByID;
    }

    @Override
    public List<ReimForm> getReimFormsByName(String staName) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ReimFormMapper mapper = sqlSession.getMapper(ReimFormMapper.class);
        List<ReimForm> reimFormsByName = mapper.getReimFormsByName(staName);
        sqlSession.commit();
        sqlSession.close();

        return reimFormsByName;
    }

    @Override
    public int addReimForm(ReimForm reimForm) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ReimFormMapper mapper = sqlSession.getMapper(ReimFormMapper.class);
        int i = mapper.addReimForm(reimForm);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public int updateReimForm(ReimForm reimForm) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ReimFormMapper mapper = sqlSession.getMapper(ReimFormMapper.class);
        int i = mapper.updateReimForm(reimForm);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public int delSReimForm(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ReimFormMapper mapper = sqlSession.getMapper(ReimFormMapper.class);
        int i = mapper.delSReimForm(id);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public List<ReimForm> getReimFormsByState(int state) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ReimFormMapper mapper = sqlSession.getMapper(ReimFormMapper.class);
        List<ReimForm> reimForms = mapper.getReimFormsByState(state);
        sqlSession.commit();
        sqlSession.close();

        return reimForms;
    }

    @Override
    public int updateReimFormState(String id, Integer state, Date date) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ReimFormMapper mapper = sqlSession.getMapper(ReimFormMapper.class);
        int i = mapper.updateReimFormState(id, state, date);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Test
    public void test(){
        /*
        List<ReimForm> forms = getReimFormsByName("frans");
        for (ReimForm form : forms) {
            System.out.println(form);
        }
        */
        updateReimFormState("100003", 1, new Date());
        System.out.println(new Date());
    }

}
