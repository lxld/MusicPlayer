package com.cheery.service;

import com.cheery.dao.master.IMasterDao;
import com.cheery.model.MasterEntity;

public class MasterService {
    private IMasterDao masterDao;

    public void setMasterDao(IMasterDao masterDao) {
        this.masterDao = masterDao;
    }

    public boolean masterLogin(MasterEntity master) throws Exception {
        return masterDao.masterLogin(master);
    }
}
