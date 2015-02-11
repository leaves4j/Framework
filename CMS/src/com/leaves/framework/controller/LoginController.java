package com.leaves.framework.controller;

import com.leaves.framework.common.controller.CurrentContext;
import com.leaves.framework.model.User;
import com.leaves.framework.service.ILoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by jiangq on 2015/1/5.
 */
@Controller
public class LoginController {
    @Resource(name = "loginService")
    private ILoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(Model model) {

        ModelAndView mv = new ModelAndView();
        mv.addObject("userList", "测试下");
        mv.setViewName("FrameWork/login");
        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestParam String code, @RequestParam String password, HttpSession session) {
        List<User> users = loginService.getUser(code);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if (users.size() == 0) {
            modelMap.put("state", "false");
            modelMap.put("msg", "账号不存在");
        } else if (users.get(0).getPassword().equals(password)) {
            modelMap.put("state", "true");
            CurrentContext context = new CurrentContext();
            User user = users.get(0);
            context.setUseCode(user.getCode());
            context.setUserId(user.getId());
            context.setUserName(user.getName());
            session.setAttribute("Sys_CurrentContext", context);
        } else {
            modelMap.put("state", "false");
            modelMap.put("msg", "密码错误");
        }
        return modelMap;
    }
}
