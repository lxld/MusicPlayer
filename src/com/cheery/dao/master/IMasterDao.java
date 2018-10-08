package com.cheery.dao.master;

import com.cheery.model.MasterEntity;

import java.util.List;

public interface IMasterDao {
    /*登陆*/
    boolean masterLogin(MasterEntity master) throws Exception;
}
