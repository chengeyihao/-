package com.shuaichen.crm.staff.dao;

import com.shuaichen.crm.department.domain.Department;
import com.shuaichen.crm.post.domain.Post;
import com.shuaichen.crm.staff.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
public interface StaffDao {
    /**
     * 分页查询员工
     * @param startIndex  开始索引的值
     * @param pageSize  每页显示的信息数
     * @return
     */
    List<Staff> findAll(int startIndex, int pageSize);

    /**
     * 查询所有部门
     * @return
     */
    List<Department> findDept();

    /**
     * 根据部门Id查询职位
     * @param staff 员工对象(用来传递depId)
     * @return
     */
    List<Post> findPostByDepId(Staff staff);

    /**
     * 高级查询
     * @param ss 判断之后的拼接sql语句
     * @param startIndex  开始索引的值
     * @param pageSize 每页显示的信息数
     * @return
     */
    List<Staff> findSome(String ss, int startIndex, int pageSize);

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


    /**
     * 查询信息总数
     * @param s 判断之后的拼接sql语句
     * @return 返回将要查询信息的总数
     */
    int getTotal(String s);


}
