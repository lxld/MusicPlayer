package com.cheery.dao.mobile;

import com.cheery.model.BrandEntity;
import com.cheery.model.MobileEntity;
import org.hibernate.*;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.sql.SQLException;
import java.util.List;

public class MobileDaoImpl extends HibernateDaoSupport implements IMobileDao {

    @Override
    public List<MobileEntity> queryAllPageMobile(String keyStr, Integer pageNo, Integer pageSize) throws Exception {
        String hql = "from MobileEntity as m inner join fetch m.brand where 1 = 1";
        if (null != keyStr && "" != keyStr) {
            hql += " and m.type like '%" + keyStr + "%'";
        }
        final String HQL = hql;
        final Integer PAGENO = pageNo;
        final Integer PAGESIZE = pageSize;
        List mobileList = this.getHibernateTemplate().executeFind(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query qy = session.createQuery(HQL);
                qy.setFirstResult((PAGENO - 1) * PAGESIZE);
                qy.setMaxResults(PAGESIZE);
                return qy.list();
            }
        });
        return mobileList;
    }

    @Override
    public int queryMobiles() throws Exception {
        int size = 0;
        String hql = "select count(*) from MobileEntity as m inner join m.brand";
        List result = this.getHibernateTemplate().find(hql);
        if (0 < result.size() && null != result) {
            size = Integer.parseInt(result.get(0) + "");
        }
        return size;
    }

    @Override
    public boolean delMobile(MobileEntity mobile) throws Exception {
        try {
            this.getHibernateTemplate().delete(mobile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<MobileEntity> queryOneById(MobileEntity mobile) throws Exception {
        String hql = "from MobileEntity as m inner join fetch m.brand where m.mobileId = ?";
        return this.getHibernateTemplate().find(hql, mobile.getMobileId());
    }

    @Override
    public List<BrandEntity> queryBrands() throws Exception {
        String hql = "from BrandEntity";
        return this.getHibernateTemplate().find(hql);
    }

    @Override
    public boolean modifyMobileById(MobileEntity mobile) throws Exception {
        try {
            this.getHibernateTemplate().update(mobile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
