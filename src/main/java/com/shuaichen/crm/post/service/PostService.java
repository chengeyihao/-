package com.shuaichen.crm.post.service;

import com.shuaichen.crm.department.domain.Department;
import com.shuaichen.crm.post.domain.Post;
import com.shuaichen.crm.utils.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
public interface PostService {

    /**
     * 分页查询所有职务
     * @param post  职务对象
     * @param pageNum 第几页
     * @param pageSize 每页信息数
     * @return
     */
    PageBean<Post> findAll(Post post, int pageNum, int pageSize);

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
     * 查询所有部门(下拉列表内容)
     * @return
     */
    List<Department> findDept();
}
