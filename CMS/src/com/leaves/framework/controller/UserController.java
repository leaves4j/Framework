package com.leaves.framework.controller;

import com.leaves.framework.common.CommonFunction;
import com.leaves.framework.model.Role;
import com.leaves.framework.model.User;
import com.leaves.framework.service.IRoleService;
import com.leaves.framework.service.IUserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.StringReader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: jiangq
 * Date: 2015/2/12
 * Time: 16:06
 * Description:
 */
@Controller
public class UserController {
    @Resource(name = "userService")
    private IUserService userService;
    @Resource(name = "roleService")
    private IRoleService roleService;

    @RequestMapping(value = "framework/users", method = RequestMethod.GET)
    public ModelAndView getUserPage(Model model) {
        List<Role> roles = roleService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("roles", roles);
        mv.setViewName("FrameWork/JSP/user");
        return mv;
    }

    @RequestMapping(value = "framework/user", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserList(@RequestParam int page, @RequestParam int rows) {
        List<User> users = userService.getUserList(page, rows);
        for (User user : users) {
            user.setPassword(null);
            user.setRoles(null);
        }
        return users;
    }

    @RequestMapping(value = "framework/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable String id) {
        User user = userService.getUser(id);
        user.setPassword(null);
        return user;
    }

    @RequestMapping(value = "framework/user", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody User user) {
        return userService.addOrUpdate(user);
    }

    @RequestMapping(value = "framework/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@PathVariable String id) {
        userService.deleteById(id);
        return "ok";
    }
}
