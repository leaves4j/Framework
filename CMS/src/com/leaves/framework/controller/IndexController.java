package com.leaves.framework.controller;


import com.leaves.framework.model.User;
import com.leaves.framework.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by leaves on 2014/10/14.
 */
@Controller
public class IndexController {
    @Resource(name = "userService")
    private IUserService userService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView getUserlist(Model model) {

        ModelAndView mv = new ModelAndView();
        List<User> userList = userService.findAll();
        System.out.println("log======table 'user' all records:" + userList.size());
        mv.addObject("userList", userList);
        mv.setViewName("FrameWork/index");
        return mv;
    }


}
