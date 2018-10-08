package com.cheery.dao.master;

import com.cheery.model.MasterEntity;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class MasterDaoImpl extends HibernateDaoSupport implements IMasterDao {

    @Override
    public boolean masterLogin(MasterEntity master) throws Exception {
        String hql = "from MasterEntity where userName = ? and passWord = ?";
        List masterList = this.getHibernateTemplate().find(hql, new Object[]{master.getUserName(), master.getPassWord()});
        if (0 < masterList.size() && null != masterList) {
            return true;
        } else {
            return false;
        }
    }
}
