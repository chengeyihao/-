package com.shuaichen.crm.post.domain;


import com.shuaichen.crm.department.domain.Department;
import com.shuaichen.crm.staff.domain.Staff;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/11/9.
 */
public class Post {


    private String postId;
    private String postName;

    private Department department;
    private Set<Staff> staffSet = new HashSet<>();

    public Post() {
    }

    public Post(String postId) {
        this.postId = postId;
    }

    public Post(String postName, Department department) {
        this.postName = postName;
        this.department = department;
    }

    public Post(String postId, String postName, Department department) {
        this.postId = postId;
        this.postName = postName;
        this.department = department;
    }


    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Staff> getStaffSet() {
        return staffSet;
    }

    public void setStaffSet(Set<Staff> staffSet) {
        this.staffSet = staffSet;
    }
}
