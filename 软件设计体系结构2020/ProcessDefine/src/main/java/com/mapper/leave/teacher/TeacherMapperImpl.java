package com.mapper.leave.teacher;

import com.pojo.leave.Teacher;
import com.tools.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class TeacherMapperImpl implements TeacherMapper {

    @Override
    public Teacher getTeacherByID(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherByID(id);
        sqlSession.commit();
        sqlSession.close();

        return teacher;
    }

    @Override
    public Teacher getTeacherByName(String teaName) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherByName(teaName);
        sqlSession.commit();
        sqlSession.close();

        return teacher;
    }

    @Override
    public int addTeacher(Teacher teacher) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        int addTeacher = mapper.addTeacher(teacher);
        sqlSession.commit();
        sqlSession.close();

        return addTeacher;
    }

    @Override
    public int delTeacher(int id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        int del = mapper.delTeacher(id);
        sqlSession.commit();
        sqlSession.close();

        return del;
    }
}
