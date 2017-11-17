package com.shuaichen.crm.department.service.impl;

import com.shuaichen.crm.department.dao.DeptDao;
import com.shuaichen.crm.department.domain.Department;
import com.shuaichen.crm.department.service.DeptService;
import com.shuaichen.crm.utils.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
public class DeptServiceImpl implements DeptService {

    private DeptDao deptDao;

    /**
     * 分页查询部门
     * @param department 部门对象
     * @param pageNum 第几页
     * @param pageSize 每页的信息数
     * @return
     */
    @Override
    public PageBean<Department> find(Department department, int pageNum, int pageSize) {
        int totalRecord = deptDao.getTotalDept();
        int totalPage;
        int startIndex = (pageNum - 1) * 5;
        if(totalRecord % pageSize == 0){
            totalPage = totalRecord / pageSize;
        } else {
            totalPage = totalRecord / pageSize + 1;
        }
        PageBean<Department> pageBean = new PageBean<>
                (pageNum,pageSize,totalRecord,startIndex,totalPage);
        List<Department> data =
                deptDao.find(pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }


    /**
     * 根据部门Id查询对应部门显示到编辑页面
     * @param department  部门对象(里面存depId)
     * @return
     */
    @Override
    public List<Department> findByDeptId(Department department) {
        return deptDao.findByDeptId(department);
    }


    /**
     * 添加或修改部门
     * @param department 部门对象(存储添加或修改的信息)
     */
    @Override
    public void add(Department department) {
        if (department != null && department.getDepId().equals("")){
            department.setDepId(null);
        }
        deptDao.add(department);
    }

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }
}
