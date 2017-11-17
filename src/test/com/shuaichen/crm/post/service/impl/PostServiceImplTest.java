package com.shuaichen.crm.post.service.impl;

import com.shuaichen.crm.department.domain.Department;
import com.shuaichen.crm.post.dao.PostDao;
import com.shuaichen.crm.post.domain.Post;
import com.shuaichen.crm.post.service.PostService;
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
public class PostServiceImplTest {

    @Resource
    private PostDao postDao;

    @Test
    public void findAll(){
        List<Post> all = postDao.findAll(0, 5);
        for (Post post : all) {
            System.out.println(post.getPostName());
        }
    }

    @Test
    public void findByPostId(){
        Post post = new Post("2c9090215fa050a0015fa050a7c40004",null);
        List<Post> byPostId = postDao.findByPostId(post);
        for (Post post1 : byPostId) {
            System.out.println(post1.getPostName());
        }
    }

    @Test
    public void add(){
        Post post = new Post("大儿子",new Department("2c9090215fa5f768015fa6293b210000"));
        postDao.add(post);
    }

    @Test
    public void findDept(){
        List<Department> dept = postDao.findDept();
        for (Department department : dept) {
            System.out.println(department.getDepName());
        }
    }

}