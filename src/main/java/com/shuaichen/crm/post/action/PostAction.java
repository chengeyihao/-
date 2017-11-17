package com.shuaichen.crm.post.action;

import com.opensymphony.xwork2.ActionContext;
import com.shuaichen.crm.base.BaseAction;
import com.shuaichen.crm.department.domain.Department;
import com.shuaichen.crm.post.domain.Post;
import com.shuaichen.crm.post.service.PostService;
import com.shuaichen.crm.utils.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
public class PostAction extends BaseAction<Post,PostService>{

    // 定义每页有多少条数据
    private int pageSize = 5;

    // 接受前端传来的第几页
    private int pageNum;

    /**
     * 职位的分页查询
     * @return
     */
    public String findAll(){
        if (pageNum == 0){
            pageNum = 1;
        }
        PageBean<Post> all =
                service.findAll
                        (getModel(),pageNum,pageSize);
        ActionContext.getContext().put("pageBean",all);
        return SUCCESS;
    }

    /**
     * 职位的添加或修改
     * @return
     */
    public String add(){
        service.add(getModel());
        return SUCCESS;
    }

    /**
     * 根据职位Id查询对应信息
     * @return
     */
    public String findByPostId(){
        List<Post> byPostId = service.findByPostId(getModel());
        contextPut("byPostId",byPostId.get(0));
        return SUCCESS;
    }

    /**
     * 查询所有部门
     * @return
     */
    public String findDept(){
        List<Department> dept = service.findDept();
        contextPut("dept",dept);
        return SUCCESS;
    }



    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
