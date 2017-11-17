package com.shuaichen.crm.login.dao.impl;

import com.shuaichen.crm.login.dao.LoginDao;
import com.shuaichen.crm.staff.domain.Staff;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/14.
 */
public class LoginDaoImpl extends HibernateDaoSupport implements LoginDao{


    /**
     * 登录查询
     * @param staff  员工对像 用来传递前台登录时传来的值
     * @return
     */
    @Override
    public List<Staff> find(Staff staff) {
        return getHibernateTemplate().findByExample(staff);
    }
}
