package com.shuaichen.crm.department.dao;

import com.shuaichen.crm.department.domain.Department;

import java.util.List;

/**
 * Created by dllo on 17/11/14.
 */
public interface DeptDao {

    /**
     * 部门分页查询
     * @param startIndex  开始索引的值
     * @param pageSize 每页显示的信息数
     * @return
     */
    List<Department> find(int startIndex, int pageSize);

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

    /**
     * 查询信息总数
     * @return  返回将要查询信息的总数
     */
    int getTotalDept();

}
