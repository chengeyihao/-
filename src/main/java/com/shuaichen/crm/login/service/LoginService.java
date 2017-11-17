package com.shuaichen.crm.login.service;

import com.shuaichen.crm.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/14.
 */
public interface LoginService {

    /**
     * 登录查询
     * @param staff  员工对像 用来传递前台登录时传来的值
     * @return
     */
    List<Staff> find(Staff staff);

}
