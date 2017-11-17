package com.shuaichen.crm.staff.dao.impl;

import com.shuaichen.crm.department.domain.Department;
import com.shuaichen.crm.post.domain.Post;
import com.shuaichen.crm.staff.dao.StaffDao;
import com.shuaichen.crm.staff.domain.Staff;
import com.shuaichen.crm.utils.PageHibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {

    /**
     * 根据员工Id查询对应员工信息
     * @param staff
     * @return
     */
    @Override
    public List<Staff> findByStaffId(Staff staff) {
        return (List<Staff>) getHibernateTemplate()
                .find("from Staff where staffId=?",staff.getStaffId());
    }

    /**
     * 查询所有部门
     * @return
     */
    @Override
    public List<Department> findDept() {
        return (List<Department>) getHibernateTemplate().find("from Department");
    }

    /**
     * 根据部门Id查询职位
     * @param staff 员工对象(用来传递depId)
     * @return
     */
    @Override
    public List<Post> findPostByDepId(Staff staff) {
        return (List<Post>) getHibernateTemplate()
                .find("from Post where department.depId=?"
                        ,staff.getPost().getDepartment().getDepId());
    }


    /**
     * 分页查询员工
     * @param startIndex  开始索引的值
     * @param pageSize  每页显示的信息数
     * @return
     */
    @Override
    public List<Staff> findAll(int startIndex, int pageSize) {
        String sql = "from Staff where 1=1 ";
        return getHibernateTemplate().
                execute(new PageHibernateCallback<Staff>
                        (sql, startIndex, pageSize));
    }

    /**
     * 高级查询
     * @param ss 判断之后的拼接sql语句
     * @param startIndex  开始索引的值
     * @param pageSize 每页显示的信息数
     * @return
     */
    @Override
    public List<Staff> findSome(String ss, int startIndex, int pageSize) {
        String sql = "from Staff where 1=1 " + ss;

        return getHibernateTemplate().
                execute(new PageHibernateCallback<Staff>
                        (sql, startIndex, pageSize));
    }

    /**
     * 员工的添加或修改
     * @param staff
     */
    @Override
    public void add(Staff staff) {
        getHibernateTemplate().saveOrUpdate(staff);
    }

    /**
     * 查询信息总数
     * @param ss 判断之后的拼接sql语句
     * @return 返回将要查询信息的总数
     */
    @Override
    public int getTotal(String ss) {
        String  sql = "select count(s) from Staff s where 1=1 ";
        if (ss == null){
            List<Long> find = (List<Long>) getHibernateTemplate().find(sql);
            if (find != null) {
                return find.get(0).intValue();
            }
        }else {
            List<Long> find = (List<Long>) getHibernateTemplate().find(sql + ss);
            if (find != null) {
                return find.get(0).intValue();
            }
        }

        return 0;
    }
}
