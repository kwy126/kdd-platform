package com.circle.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by keweiyang on 2017/12/7.
 *
 */
@Controller
public class HelloController {
    private static final Logger logger = Logger.getLogger(HelloController.class);

    @RequestMapping(value = "/hello.do",method = RequestMethod.GET)
    public String hello(Model model) {
        logger.info("到此一游");

        model.addAttribute("hello", "您好");
        return "unauthorized";
    }

}
