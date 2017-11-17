package com.shuaichen.crm.post.dao.impl;

import com.shuaichen.crm.department.domain.Department;
import com.shuaichen.crm.post.dao.PostDao;
import com.shuaichen.crm.post.domain.Post;
import com.shuaichen.crm.utils.PageHibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {

    /**
     * 分页查询职务
     * @param startIndex 开始索引的值
     * @param pageSize  每页显示的信息数
     * @return
     */
    @Override
    public List<Post> findAll(int startIndex, int pageSize) {
        String sql = "from Post where 1=1 ";
        return getHibernateTemplate().
                execute(new PageHibernateCallback<Post>
                        (sql, startIndex, pageSize));
    }


    /**
     * 根据职务Id查询对应职位返回到修改界面
     * @param post 职位对象(用来传递postId)
     * @return
     */
    @Override
    public List<Post> findByPostId(Post post) {
        return (List<Post>) getHibernateTemplate()
                .find("from Post where postId=?",post.getPostId());
    }

    /**
     * 职位的添加或修改
     * @param post 职位对象(用来传递修改或添加的信息)
     */
    @Override
    public void add(Post post) {
        getHibernateTemplate().saveOrUpdate(post);
    }

    /**
     * 查询信息总数
     * @return  返回将要查询信息的总数
     */
    @Override
    public int getTotalDept() {
        String  sql = "select count(p) from Post p where 1=1";

        List<Long> find = (List<Long>) getHibernateTemplate().find(sql);
        if (find != null) {
            return find.get(0).intValue();
        }
        return 0;
    }

    /**
     * 查询所有部门(下拉列表内容)
     * @return
     */
    @Override
    public List<Department> findDept() {
        return (List<Department>) getHibernateTemplate().find("from Department");
    }
}
