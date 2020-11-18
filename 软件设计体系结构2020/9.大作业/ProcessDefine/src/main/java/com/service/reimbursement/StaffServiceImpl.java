package com.service.reimbursement;

import com.mapper.reimbursement.StaffMapper;
import com.mapper.reimbursement.StaffMapperImpl;
import com.pojo.reimbursement.Staff;

public class StaffServiceImpl implements StaffService{
    private StaffMapper staffMapper;

    public StaffServiceImpl() {
        this.staffMapper = new StaffMapperImpl();
    }

    @Override
    public Staff getStaffByName(String staName) {
        return staffMapper.getStaffByName(staName);
    }
}
