package com.shuaichen.crm.login.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * Created by dllo on 17/11/14.
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        Object list = ActionContext.getContext().getSession().get("list");
        if (list == null){
            ActionContext.getContext().getSession().put("error","亲,请登录");
            return "login";
        }
        return actionInvocation.invoke();
    }
}
