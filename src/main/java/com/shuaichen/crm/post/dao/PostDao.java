package com.shuaichen.crm.post.dao;

import com.shuaichen.crm.department.domain.Department;
import com.shuaichen.crm.post.domain.Post;
import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
public interface PostDao {

    /**
     * 分页查询职务
     * @param startIndex 开始索引的值
     * @param pageSize  每页显示的信息数
     * @return
     */
    List<Post> findAll(int startIndex, int pageSize);

    /**
     * 根据职务Id查询对应职位返回到修改界面
     * @param post 职位对象(用来传递postId)
     * @return
     */
    List<Post> findByPostId(Post post);

    /**
     * 职位的添加或修改
     * @param post 职位对象(用来传递修改或添加的信息)
     */
    void add(Post post);

    /**
     * 查询信息总数
     * @return  返回将要查询信息的总数
     */
    int getTotalDept();

    /**
     * 查询所有部门(下拉列表内容)
     * @return
     */
    List<Department> findDept();

}
