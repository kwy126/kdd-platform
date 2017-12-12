package com.circle.service;

import com.circle.entity.User;

import java.util.Set;

/**
 * Created by keweiyang on 2017/12/10.
 */
public interface IUserService {
    /**
     * 通过用户名查询用户
     * @param name
     * @return
     */
    public User findUserByUserName(String name);


    /**
     * 通过用户名查询角色信息
     * @param userName
     * @return
     */
    public Set<String> getRoles(String userName);


    /**
     * 通过用户名查询权限信息
     * @param userName
     * @return
     */
    public Set<String> getPermissions(String userName);
}
