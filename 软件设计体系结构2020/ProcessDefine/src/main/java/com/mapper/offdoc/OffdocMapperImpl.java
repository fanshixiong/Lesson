package com.mapper.offdoc;

import com.pojo.offdoc.Offdocform;
import com.tools.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class OffdocMapperImpl implements OffdocMapper {


    @Override
    public Offdocform getoffdocByID(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OffdocMapper mapper = sqlSession.getMapper(OffdocMapper.class);
        Offdocform formByID = mapper.getoffdocByID(id);
        sqlSession.commit();
        sqlSession.close();

        return formByID;
    }

    @Override
    public List<Offdocform> getoffdocByName(String name) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OffdocMapper mapper = sqlSession.getMapper(OffdocMapper.class);
        List<Offdocform> offdocforms = mapper.getoffdocByName(name);
        sqlSession.commit();
        sqlSession.close();

        return offdocforms;
    }

    @Override
    public int addoffdoc(Offdocform offdocform) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OffdocMapper mapper = sqlSession.getMapper(OffdocMapper.class);
        int i = mapper.addoffdoc(offdocform);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public int updateoffdocAstate(Offdocform offdocform) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OffdocMapper mapper = sqlSession.getMapper(OffdocMapper.class);
        int i = mapper.updateoffdocAstate(offdocform);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public int deloffdoc(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OffdocMapper mapper = sqlSession.getMapper(OffdocMapper.class);
        int i = mapper.deloffdoc(id);
        sqlSession.commit();
        sqlSession.close();

        return i;
    }

    @Override
    public List<Offdocform> getoffdocBySstate(int state) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OffdocMapper mapper = sqlSession.getMapper(OffdocMapper.class);
        List<Offdocform> offdocforms = mapper.getoffdocBySstate(state);
        sqlSession.commit();
        sqlSession.close();

        return offdocforms;
    }

    @Override
    public List<Offdocform> getoffdoc() {
        return null;
    }

    @Override
    public int updateoffdocSstate(String id, Integer state, Date date) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        OffdocMapper mapper = sqlSession.getMapper(OffdocMapper.class);
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
