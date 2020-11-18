package com.mapper.reimbursement;

import com.pojo.reimbursement.Staff;
import com.tools.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class StaffMapperImpl implements StaffMapper{
    @Override
    public Staff getStaffByID(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StaffMapper mapper = sqlSession.getMapper(StaffMapper.class);
        Staff staff = mapper.getStaffByID(id);
        sqlSession.commit();
        sqlSession.close();

        return staff;
    }

    @Override
    public Staff getStaffByName(String staName) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StaffMapper mapper = sqlSession.getMapper(StaffMapper.class);
        Staff staff = mapper.getStaffByName(staName);
        sqlSession.commit();
        sqlSession.close();

        return staff;
    }

    @Override
    public int addStaff(Staff staff) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StaffMapper mapper = sqlSession.getMapper(StaffMapper.class);
        int addStaff = mapper.addStaff(staff);
        sqlSession.commit();
        sqlSession.close();

        return addStaff;
    }

    @Override
    public int delStaff(int id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StaffMapper mapper = sqlSession.getMapper(StaffMapper.class);
        int delStaff = delStaff(id);
        sqlSession.commit();
        sqlSession.close();

        return delStaff;
    }
}
