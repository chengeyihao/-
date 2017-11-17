package com.shuaichen.crm.staff.action;

import com.shuaichen.crm.department.domain.Department;
import com.shuaichen.crm.post.domain.Post;
import com.shuaichen.crm.staff.domain.Staff;
import com.shuaichen.crm.staff.service.StaffService;
import com.shuaichen.crm.utils.PageBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class StaffActionTest {

    @Resource
    private StaffService staffService;

    @Test
    public void findSome() throws Exception {
        // 2c9090215fa050a0015fa050a7b30001    2c9090215fa050a0015fa050a7b30002
        Staff staff = new Staff();
        staff.setPost(new Post("-1",new Department("-1")));
        staff.setStaffName("1");
        PageBean<Staff> some = staffService.findSome(staff, 1, 5);
        for (Staff staff1 : some.getData()) {
            System.out.println(staff1.getStaffName());
        }
    }

    @Test
    public void findByStaffId(){
        Staff staff = new Staff("2c9090215fb4d137015fb4d21c460000");
        List<Staff> byStaffId = staffService.findByStaffId(staff);
        for (Staff staff1 : byStaffId) {
            System.out.println(staff1.getStaffName());
        }
    }

    @Test
    public void findAll(){
        Staff staff  = new Staff();
        PageBean<Staff> all = staffService.findAll(staff, 2, 5);
        for (Staff staff1 : all.getData()) {
            System.out.println(staff1.getStaffName());
        }

    }


}