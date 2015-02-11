package com.leaves.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jiangq on 2014/12/28.
 */
@Controller
public class FunctionController {
    @RequestMapping(value="/function",method= RequestMethod.GET)
    public ModelAndView getMenuList(Model model){

        ModelAndView mv = new ModelAndView();
       // List<UserEntity> userList = userService.findAll();
       // System.out.println("log======table 'user' all records:"+userList.size());
       // mv.addObject("userList", "测试下");
        mv.setViewName("FrameWork/function");
        return mv;
    }
}
