package com.shuaichen.crm.staff.service;

import com.shuaichen.crm.department.domain.Department;
import com.shuaichen.crm.post.domain.Post;
import com.shuaichen.crm.staff.domain.Staff;
import com.shuaichen.crm.utils.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
public interface StaffService {

    /**
     * 分页查询所有员工
     * @param staff  员工对象
     * @param pageNum 第几页
     * @param pageSize 每页显示的信息数
     * @return
     */
    PageBean<Staff> findAll(Staff staff, int pageNum, int pageSize);

    /**
     * 查询所有部门
     * @return
     */
    List<Department> findDept();

    /**
     * 高级查询
     * @param staff  员工对象
     * @param pageNum 第几页
     * @param pageSize 每页显示的信息数
     * @return
     */
    PageBean<Staff> findSome(Staff staff, int pageNum, int pageSize);

    /**
     * 根据部门Id查询职位
     * @param staff 员工对象(用来传递depId)
     * @return
     */
    List<Post> findPostByDepId(Staff staff);

    /**
     * 员工的添加或修改
     * @param staff
     */
    void add(Staff staff);

    /**
     * 根据员工Id查询对应员工信息
     * @param staff
     * @return
     */
    List<Staff> findByStaffId(Staff staff);


}
