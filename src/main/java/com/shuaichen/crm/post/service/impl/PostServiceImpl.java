package com.shuaichen.crm.post.service.impl;

import com.shuaichen.crm.department.domain.Department;
import com.shuaichen.crm.post.dao.PostDao;
import com.shuaichen.crm.post.domain.Post;
import com.shuaichen.crm.post.service.PostService;
import com.shuaichen.crm.utils.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
public class PostServiceImpl implements PostService{

    private PostDao postDao;

    /**
     * 分页查询所有职务
     * @param post  职务对象
     * @param pageNum 第几页
     * @param pageSize 每页信息数
     * @return
     */
    @Override
    public PageBean<Post> findAll(Post post, int pageNum, int pageSize) {
        int totalRecord = postDao.getTotalDept();
        int totalPage;
        int startIndex = (pageNum - 1) * 5;
        if(totalRecord % pageSize == 0){
            totalPage = totalRecord / pageSize;
        } else {
            totalPage = totalRecord / pageSize + 1;
        }
        PageBean<Post> pageBean = new PageBean<>
                (pageNum,pageSize,totalRecord,startIndex,totalPage);
        List<Post> data =
                postDao.findAll(pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }

    /**
     * 根据职务Id查询对应职位返回到修改界面
     * @param post 职位对象(用来传递postId)
     * @return
     */
    @Override
    public List<Post> findByPostId(Post post) {
        return postDao.findByPostId(post);
    }

    /**
     * 职位的添加或修改
     * @param post 职位对象(用来传递修改或添加的信息)
     */
    @Override
    public void add(Post post) {
        if (post != null && post.getPostId().equals("")){
            post.setPostId(null);
        }
        postDao.add(post);
    }

    /**
     * 查询所有部门(下拉列表内容)
     * @return
     */
    @Override
    public List<Department> findDept() {
        return postDao.findDept();
    }


    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
