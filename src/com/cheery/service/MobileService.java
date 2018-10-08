package com.cheery.service;

import com.cheery.dao.mobile.IMobileDao;
import com.cheery.model.BrandEntity;
import com.cheery.model.MobileEntity;

import java.util.List;

public class MobileService {
    private IMobileDao mobileDao;

    public void setMobileDao(IMobileDao mobileDao) {
        this.mobileDao = mobileDao;
    }

    public List<MobileEntity> queryAllPageMobile(String keyStr, Integer pageNo, Integer pageSize) throws Exception {
        return mobileDao.queryAllPageMobile(keyStr, pageNo, pageSize);
    }

    public int queryMobiles() throws Exception {
        return mobileDao.queryMobiles();
    }

    public boolean delMobile(MobileEntity mobile) throws Exception {
        return mobileDao.delMobile(mobile);
    }

    public List<MobileEntity> queryOneById(MobileEntity mobile) throws Exception {
        return mobileDao.queryOneById(mobile);
    }

    public List<BrandEntity> queryBrands() throws Exception {
        return mobileDao.queryBrands();
    }

    public boolean modifyMobileById(MobileEntity mobile) throws Exception {
        return mobileDao.modifyMobileById(mobile);
    }

}
