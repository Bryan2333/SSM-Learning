package com.hnnu.bryan1.service;

import com.hnnu.bryan1.dao.BryanDao;
import com.hnnu.bryan1.dao.BryanDaoImpl;

public class BryanServiceImpl implements BryanService{
    private BryanDao bryanDao;

    public void setBryanDao(BryanDao bryanDao) {
        this.bryanDao = bryanDao;
    }

    public void getBryan() {
        bryanDao.getBryan();
        System.out.println("Service进行了简单的处理");
    }
}
