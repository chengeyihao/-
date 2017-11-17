package com.shuaichen.crm.department.service;

import com.shuaichen.crm.department.domain.Department;
import com.shuaichen.crm.utils.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
public interface DeptService {

    /**
     * 分页查询部门
     * @param department 部门对象
     * @param pageNum 第几页
     * @param pageSize 每页的信息数
     * @return
     */
    PageBean<Department> find(Department department, int pageNum, int pageSize);

    /**
     * 根据部门Id查询对应部门显示到编辑页面
     * @param department  部门对象(里面存depId)
     * @return
     */
    List<Department> findByDeptId(Department department);

    /**
     * 添加或修改部门
     * @param department 部门对象(存储添加或修改的信息)
     */
    void add(Department department);


}
