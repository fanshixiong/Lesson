package com.mapper.leave.leave;

import com.mapper.reimbursement.ReimFormMapper;
import com.pojo.leave.Leave;
import com.pojo.reimbursement.ReimForm;
import com.tools.MybatisUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class LeaveFormMapperImpl implements LeaveMapper{


    @Override
    public Leave getFormByID(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        LeaveMapper mapper = sqlSession.getMapper(LeaveMapper.class);
        Leave formByID = mapper.getFormByID(id);
        sqlSession.commit();
        sqlSession.close();
        return formByID;
    }

    @Override
    public List<Leave> getFormsByName(String sname) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        LeaveMapper mapper = sqlSession.getMapper(LeaveMapper.class);
        List<Leave> LeaveByName = mapper.getFormsByName(sname);
        sqlSession.commit();
        sqlSession.close();

        return LeaveByName;
    }

    @Override
    public int addLeaveForm(Leave leave) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        LeaveMapper mapper = sqlSession.getMapper(LeaveMapper.class);
        int i = mapper.addLeaveForm(leave);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public int updateLeaveForm(ReimForm reimForm) {
        return 0;
    }

    @Override
    public int delLeaveForm(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        LeaveMapper mapper = sqlSession.getMapper(LeaveMapper.class);
        int i = mapper.delLeaveForm(id);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public List<Leave> getLeaveFormsByState(int state) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        LeaveMapper mapper = sqlSession.getMapper(LeaveMapper.class);
        List<Leave> leaveForms = mapper.getLeaveFormsByState(state);
        sqlSession.commit();
        sqlSession.close();

        return leaveForms;
    }

    @Override
    public List<Leave> getAllLeave() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        LeaveMapper mapper = sqlSession.getMapper(LeaveMapper.class);
        List<Leave> allleave = mapper.getAllLeave();
        sqlSession.commit();
        sqlSession.close();

        return allleave;
    }

    @Override
    public int updateLeaveFormState(String id, Integer state, Date date) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        LeaveMapper mapper = sqlSession.getMapper(LeaveMapper.class);
        int i = mapper.updateLeaveFormState(id, state, date);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }
    @Test
    public void test(){
        System.out.println(getLeaveFormsByState(0));
    }
}
