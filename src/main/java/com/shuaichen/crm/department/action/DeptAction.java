package com.shuaichen.crm.department.action;

import com.opensymphony.xwork2.ActionContext;
import com.shuaichen.crm.base.BaseAction;
import com.shuaichen.crm.department.domain.Department;
import com.shuaichen.crm.department.service.DeptService;
import com.shuaichen.crm.utils.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
public class DeptAction extends BaseAction<Department,DeptService> {

    // 定义每页有多少条数据
    private int pageSize = 5;

    // 接受前端传来的第几页
    private int pageNum;

    /**
     * 部门的分页查询
     * @return
     */
    public String find(){
        if (pageNum == 0){
            pageNum = 1;
        }
        PageBean<Department> all =
                service.find
                        (getModel(),pageNum,pageSize);
        ActionContext.getContext().put("pageBean",all);
        return SUCCESS;
    }


    /**
     * 部门的添加或修改
     * @return
     */
    public String add(){
        service.add(getModel());
        return SUCCESS;
    }


    /**
     * 根据部门Id查询对应信息
     * @return
     */
    public String findByDeptId(){
        List<Department> byDeptId = service.findByDeptId(getModel());
        contextPut("byDeptId",byDeptId.get(0));
        return SUCCESS;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
