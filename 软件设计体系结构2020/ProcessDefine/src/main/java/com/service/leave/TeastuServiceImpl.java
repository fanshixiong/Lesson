package com.service.leave;

import com.mapper.leave.TeastuMapper;
import com.mapper.leave.TeastuMapperImpl;
import com.pojo.leave.Teastu;

public class TeastuServiceImpl implements TeastuService {
    private TeastuMapper teastuMapper;

    public TeastuServiceImpl() {
        this.teastuMapper = new TeastuMapperImpl();
    }

    @Override
    public Teastu getteastuByName(String Name) {
        return teastuMapper.getteastuByName(Name);
    }

}
