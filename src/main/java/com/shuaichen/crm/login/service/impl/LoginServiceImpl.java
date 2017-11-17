package com.shuaichen.crm.login.service.impl;

import com.shuaichen.crm.login.dao.LoginDao;
import com.shuaichen.crm.login.service.LoginService;
import com.shuaichen.crm.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/14.
 */
public class LoginServiceImpl implements LoginService {

    private LoginDao loginDao;

    /**
     * 登录查询
     * @param staff  员工对像 用来传递前台登录时传来的值
     * @return
     */
    @Override
    public List<Staff> find(Staff staff) {
        return loginDao.find(staff);
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
}
