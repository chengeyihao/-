package com.shuaichen.crm.staff.action;

import com.opensymphony.xwork2.ActionContext;
import com.shuaichen.crm.base.BaseAction;
import com.shuaichen.crm.department.domain.Department;
import com.shuaichen.crm.post.domain.Post;
import com.shuaichen.crm.staff.domain.Staff;
import com.shuaichen.crm.staff.service.StaffService;
import com.shuaichen.crm.utils.MD5Util;
import com.shuaichen.crm.utils.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
public class StaffAction extends BaseAction<Staff,StaffService>{

    // 定义每页有多少条数据
    private int pageSize = 5;
    // 第几页
    private int pageNum;
    private List<Post> postByDepId;
    private List<Staff> something;

    // 原始密码
    private String oldPassword;
    // 新密码
    private String newPassword;
    // 确认新密码
    private String reNewPassword;


    /**
     * 分页查询所有员工
     * @return
     */
    public String findAll(){
        if (pageNum == 0){
            pageNum = 1;
        }
            PageBean<Staff> all =
                    service.findAll
                            (getModel(),pageNum,pageSize);
            ActionContext.getContext().put("pageBean",all);
        return SUCCESS;
    }

    /**
     * 查询所有部门
     * @return
     */
    public String findDept(){
        List<Department> dept = service.findDept();
        contextPut("StaffDept", dept);
        return SUCCESS;
    }

    /**
     * 高级查询
     * @return
     */
    public String findSome(){
        pageSize = 20;
        PageBean<Staff> some = service.findSome(getModel(), pageNum, pageSize);
        contextPut("pageBean",some.getData());
        something = some.getData();
        return SUCCESS;
    }


    /**
     * 根据部门Id查询职位
     * @return
     */
    public String findPostByDepId(){
        postByDepId = service.findPostByDepId(getModel());
        return SUCCESS;
    }

    /**
     * 员工的添加或修改
     */
    public String add(){
        getModel().setLoginPwd(MD5Util.MD5(getModel().getLoginPwd()));
        service.add(getModel());
        return SUCCESS;
    }

    /**
     * 根据员工Id查询对应员工信息
     * @return
     */
    public String findByStaffId(){
        List<Staff> byStaffId = service.findByStaffId(getModel());
        contextPut("byStaffId",byStaffId.get(0));
        sessionPut("setPostId",byStaffId.get(0).getPost().getPostId());
        sessionPut("setPostName",byStaffId.get(0).getPost().getPostName());
        return SUCCESS;
    }

    /**
     * 修改密码
     */
    public String updateLoginPwd(){
        Staff list = (Staff) ActionContext.getContext().getSession().get("list");
        if (!list.getLoginPwd().equals(MD5Util.MD5(oldPassword))||
                        !newPassword.equals(reNewPassword) || newPassword.equals("")){
            System.out.println("密码输入有问题!");
            addFieldError("","密码输入有问题!");
            return ERROR;
        }else {
            System.out.println("修改密码");
            list.setLoginPwd(MD5Util.MD5(newPassword));
            service.add(list);
            ActionContext.getContext().getSession().clear();
            return SUCCESS;
        }
    }




    /**
     * 添加或修改的验证
     */
    public void validateAdd(){
        if (getModel().getPost().getDepartment().getDepId().length() == 0){
            addFieldError("depId","部门名字不能为空");
        }
        if (getModel().getPost().getPostId().length() == 0){
            addFieldError("depId","职务名字不能为空");
        }
        if (getModel().getLoginName().length() == 0){
            addFieldError("depId","登录名字不能为空");
        }
        if (getModel().getLoginPwd().length() == 0){
            addFieldError("depId","登录密码不能为空");
        }
        if (getModel().getStaffName().length() == 0){
            addFieldError("depId","职工名字不能为空");
        }

    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<Post> getPostByDepId() {
        return postByDepId;
    }

    public void setPostByDepId(List<Post> postByDepId) {
        this.postByDepId = postByDepId;
    }

    public List<Staff> getSomething() {
        return something;
    }

    public void setSomething(List<Staff> something) {
        this.something = something;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }
}
