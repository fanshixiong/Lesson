package com.service.leave;

import com.mapper.leave.teastuMapper;
import com.mapper.leave.teastuMapperImpl;
import com.mapper.reimbursement.StaffMapper;
import com.mapper.reimbursement.StaffMapperImpl;
import com.pojo.leave.teastu;
import com.pojo.reimbursement.Staff;
import com.service.reimbursement.StaffService;
import org.junit.Test;

public class teastuServiceImpl implements teastuService{
    private teastuMapper teastuMapper;

    public teastuServiceImpl() {
        this.teastuMapper = new teastuMapperImpl();
    }

    @Override
    public teastu getteastuByName(String Name) {
        return teastuMapper.getteastuByName(Name);
    }

}
