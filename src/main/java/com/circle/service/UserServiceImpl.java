package com.circle.service;

import com.circle.dao.UserDAO;
import com.circle.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by keweiyang on 2017/12/10.
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserDAO userDAO;

    public User findUserByUserName(String name) {
        return userDAO.findUserByUserName(name);
    }

    public Set<String> getRoles(String userName) {
        return userDAO.getRoles(userName);
    }

    public Set<String> getPermissions(String userName) {
        return userDAO.getPermissions(userName);
    }

}
