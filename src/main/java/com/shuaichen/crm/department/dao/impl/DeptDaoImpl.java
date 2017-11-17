package com.shuaichen.crm.department.dao.impl;

import com.shuaichen.crm.department.dao.DeptDao;
import com.shuaichen.crm.department.domain.Department;
import com.shuaichen.crm.utils.PageHibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
public class DeptDaoImpl extends HibernateDaoSupport implements DeptDao {


    /**
     * 部门分页查询
     * @param startIndex  开始索引的值
     * @param pageSize 每页显示的信息数
     * @return
     */
    @Override
    public List<Department> find(int startIndex, int pageSize) {
        String sql = "from Department where 1=1 ";
        return getHibernateTemplate().
                execute(new PageHibernateCallback<Department>
                        (sql, startIndex, pageSize));
    }

    /**
     * 根据部门Id查询对应部门显示到编辑页面
     * @param department  部门对象(里面存depId)
     * @return
     */
    @Override
    public List<Department> findByDeptId(Department department) {
        return (List<Department>) getHibernateTemplate()
                .find("from Department where depId=?",department.getDepId());
    }

    /**
     * 添加或修改部门
     * @param department 部门对象(存储添加或修改的信息)
     */
    @Override
    public void add(Department department) {
        getHibernateTemplate().saveOrUpdate(department);
    }


    /**
     * 查询信息总数
     * @return  返回将要查询信息的总数
     */
    @Override
    public int getTotalDept() {
        String  sql = "select count(d) from Department d where 1=1";

        List<Long> find = (List<Long>) getHibernateTemplate().find(sql);
        if (find != null) {
            return find.get(0).intValue();
        }
        return 0;
    }
}
