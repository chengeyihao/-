package com.shuaichen.crm.staff.service.impl;

import com.shuaichen.crm.department.domain.Department;
import com.shuaichen.crm.post.domain.Post;
import com.shuaichen.crm.staff.dao.StaffDao;
import com.shuaichen.crm.staff.domain.Staff;
import com.shuaichen.crm.staff.service.StaffService;
import com.shuaichen.crm.utils.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
public class StaffServiceImpl implements StaffService {

    private StaffDao staffDao;

    /**
     * 分页查询所有员工
     * @param staff  员工对象
     * @param pageNum 第几页
     * @param pageSize 每页显示的信息数
     * @return
     */
    @Override
    public PageBean<Staff> findAll(Staff staff, int pageNum, int pageSize) {
        int totalRecord = staffDao.getTotal(null);
        int totalPage;
        int startIndex = (pageNum - 1) * 5;
        if(totalRecord % pageSize == 0){
            totalPage = totalRecord / pageSize;
        } else {
            totalPage = totalRecord / pageSize + 1;
        }
        PageBean<Staff> pageBean = new PageBean<>
                (pageNum,pageSize,totalRecord,startIndex,totalPage);
        List<Staff> data =
                staffDao.findAll(pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }

    /**
     * 根据员工Id查询对应员工信息
     * @param staff 员工对象(用来传递员工Id)
     * @return
     */
    @Override
    public List<Staff> findByStaffId(Staff staff) {
        return staffDao.findByStaffId(staff);
    }

    /**
     * 查询所有部门
     * @return
     */
    @Override
    public List<Department> findDept() {
        return staffDao.findDept();
    }

    /**
     * 高级查询
     * @param staff  员工对象
     * @param pageNum 第几页
     * @param pageSize 每页显示的信息数
     * @return
     */
    @Override
    public PageBean<Staff> findSome(Staff staff, int pageNum, int pageSize) {
        String depId = staff.getPost().getDepartment().getDepId();
        String postId = staff.getPost().getPostId();
        String staffName = staff.getStaffName();

        String ss = returnSql(depId,postId,staffName);

        int totalRecord = staffDao.getTotal(ss);
        int totalPage;
        int startIndex = (pageNum - 1) * 5;
        if(totalRecord % pageSize == 0){
            totalPage = totalRecord / pageSize;
        } else {
            totalPage = totalRecord / pageSize + 1;
        }
        PageBean<Staff> pageBean = new PageBean<>
                (pageNum,pageSize,totalRecord,startIndex,totalPage);
        List<Staff> data =
                staffDao.findSome(ss, pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }

    /**
     * 高级查询的判断条件
     * @param depId  判断传来的部门Id是否为空
     * @param postId  判断传来的职位Id是否为空
     * @param staffName  判断传来的员工名字是否为空
     * @return
     */
    public String returnSql(String depId, String postId, String staffName){
        String sql;
        // 三个都空
        if (depId.equals("-1")&&postId.equals("-1")&&staffName.equals("")){
            sql = "";
            return sql;
        }
        // 前两个空
        if (depId.equals("-1")&&postId.equals("-1")){
            sql = "and staffName like '%" + staffName + "%'";
            return sql;
        }
        // 后两个空
        if (postId.equals("-1")&&staffName.equals("")){
            sql = "and post.department.depId='" + depId + "'";
            return sql;
        }
        // 后一个空
        if (staffName.equals("")){
            sql="and post.department.depId ='" + depId + "' and post.postId='" + postId + "'";
            return sql;
        }

        // 中间空
        if (postId.equals("-1")){
            sql = "and post.department.depId='" + depId + "' and staffName like '%" + staffName + "%'";
            return sql;
        }

        // 三个都不空
        sql = "and post.department.depId='" + depId + "' and post.postId='"
                + postId + "' and staffName like '%" + staffName + "%'";

        return sql;
    }

    /**
     * 根据部门Id查询职位
     * @param staff 员工对象(用来传递depId)
     * @return
     */
    @Override
    public List<Post> findPostByDepId(Staff staff) {
        return staffDao.findPostByDepId(staff);
    }


    /**
     * 员工的添加或修改
     * @param staff
     */
    @Override
    public void add(Staff staff) {
        if(staff.getPost() == null){
            staff.setPost(null);
        }
        staffDao.add(staff);
    }



    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
