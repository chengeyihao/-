package com.shuaichen.crm.department.domain;

import com.shuaichen.crm.post.domain.Post;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/11/14.
 */
public class Department {

    private String depId;
    private String depName;

    private Set<Post> postSet = new HashSet<>();

    public Department() {
    }

    public Department(String depId) {
        this.depId = depId;
    }

    public Department(String depId, String depName) {
        this.depId = depId;
        this.depName = depName;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Set<Post> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<Post> postSet) {
        this.postSet = postSet;
    }

}
