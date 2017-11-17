package com.shuaichen.crm.department.service.impl;

import com.shuaichen.crm.department.dao.DeptDao;
import com.shuaichen.crm.department.domain.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class DeptServiceImplTest {

    @Resource
    private DeptDao deptDao;

    @Test
    public void find(){
        List<Department> departments = deptDao.find(0, 5);
        for (Department department : departments) {
            System.out.println(department.getDepId());
            System.out.println(department.getDepName());
        }
    }

    @Test
    public void add(){
        Department department = new Department();
        department.setDepName("1234部");
        department.setDepId("2c9090215fbdaf18015fbdaf1ba40000");
        deptDao.add(department);
    }

    @Test
    public void findByDeptId(){
        Department department = new Department("2c9090215fbdaf18015fbdaf1ba40000");
        List<Department> byDeptId = deptDao.findByDeptId(department);
        for (Department department1 : byDeptId) {
            System.out.println(department1.getDepName());
        }
    }
}