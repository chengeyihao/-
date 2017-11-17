package com.shuaichen.crm.login.action;

import com.opensymphony.xwork2.ActionContext;
import com.shuaichen.crm.base.BaseAction;
import com.shuaichen.crm.login.service.impl.LoginServiceImpl;
import com.shuaichen.crm.staff.domain.Staff;
import com.shuaichen.crm.utils.MD5Util;

import java.util.List;

/**
 * Created by dllo on 17/11/14.
 */
public class LoginAction extends BaseAction<Staff,LoginServiceImpl> {

    /**
     * 登录查询
     * @return
     */
    public String find(){
        Staff staff = getModel();
        staff.setLoginPwd(MD5Util.MD5(getModel().getLoginPwd()));
        List<Staff> list = service.find(staff);
        if (list.size()==0){
            addFieldError("depId","用户名或密码错误!");
            return INPUT;
        }
        sessionPut("list",list.get(0));
        sessionPut("listLoginName",list.get(0).getLoginName());
        return SUCCESS;
    }

    /**
     * 退出登录
     * @return
     */
    public String loginExit(){
        ActionContext.getContext().getSession().clear();
        return SUCCESS;
    }

    // 登录验证
    public void validateFind(){
        if (getModel().getLoginName() == null){
            addFieldError("loginName","用户名不能为空!");
        }
        if (getModel().getLoginPwd() == null){
            addFieldError("loginPwd","密码不能为空!");
        }
    }



}
