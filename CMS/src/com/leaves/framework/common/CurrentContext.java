package com.leaves.framework.common;

import com.leaves.framework.model.Role;

import java.util.Set;

/**
 * Created by jiangq on 2015/1/6.
 */
public class CurrentContext {

    private String userId;
    private String useCode;
    private String userName;
    private Set<Role> roles;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUseCode() {
        return useCode;
    }

    public void setUseCode(String useCode) {
        this.useCode = useCode;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
