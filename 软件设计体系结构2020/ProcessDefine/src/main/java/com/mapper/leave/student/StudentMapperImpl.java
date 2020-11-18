package com.mapper.leave.student;

import com.pojo.leave.Student;
import com.tools.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student getStudentByID(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.getStudentByID(id);
        sqlSession.commit();
        sqlSession.close();

        return student;
    }

    @Override
    public Student getStudentByName(String stuName) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.getStudentByName(stuName);
        sqlSession.commit();
        sqlSession.close();

        return student;
    }

    @Override
    public int addStudent(Student student) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int addStudent = mapper.addStudent(student);
        sqlSession.commit();
        sqlSession.close();

        return addStudent;
    }

    @Override
    public int delStudent(int id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int del = mapper.delStudent(id);
        sqlSession.commit();
        sqlSession.close();

        return del;
    }
}
