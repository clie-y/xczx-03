package com.clie.service.impl;

import com.clie.dao.ResidentDao;
import com.clie.domain.Resident;
import com.clie.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： CleanLoamy
 * @date 2022/5/18
 */
@Service
public class ResidentServiceImpl implements ResidentService {
    @Autowired
    private ResidentDao residentDao;

    public List<Resident> selectAllResident() {
        return residentDao.selectAll();
    }
}
