package com.circle.controller;


import com.circle.entity.User;
import com.circle.service.IUserService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by keweiyang on 2017/12/10.
 */
@Controller
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private IUserService userService = null;

    @RequestMapping(value = "/toLogin.do", method = RequestMethod.GET)
    public String toLogin() {

        return "login";
    }

    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public String login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(true);

        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);

        logger.info(currentUser.getPrincipal() + "has ");

        return "index";
    }

    @RequestMapping(value = "/h")
    @RequiresAuthentication
    @RequiresPermissions("user:*")
    public String h() {

        logger.info(SecurityUtils.getSubject().isAuthenticated());
        return "ok";
    }
}
