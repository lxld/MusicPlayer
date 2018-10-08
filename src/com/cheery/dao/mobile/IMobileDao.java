package com.cheery.dao.mobile;

import com.cheery.model.BrandEntity;
import com.cheery.model.MobileEntity;

import java.util.List;

public interface IMobileDao {
    /*分页查询手机信息*/
    List<MobileEntity> queryAllPageMobile(String keyStr, Integer pageNo, Integer pageSize) throws Exception;

    /*查询出全部手机数量*/
    int queryMobiles() throws Exception;

    /*根据id删除*/
    boolean delMobile(MobileEntity mobile) throws Exception;

    /*根据id查询原来数据*/
    List<MobileEntity> queryOneById(MobileEntity mobile) throws Exception;

    /*查询全部品牌*/
    List<BrandEntity> queryBrands() throws Exception;

    /*根据id修改*/
    boolean modifyMobileById(MobileEntity mobile) throws Exception;
}
