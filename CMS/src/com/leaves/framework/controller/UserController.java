package com.leaves.framework.controller;

import com.leaves.framework.common.CommonFunction;
import com.leaves.framework.model.User;
import com.leaves.framework.service.IUserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.StringReader;
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

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUserPage(Model model) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("FrameWork/user");
        return mv;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserList(@RequestParam int page, @RequestParam int rows) {
        return userService.getUserList(page, rows);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody User user) {
        user.setState("0");
        return userService.addUser(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String editUser(@RequestBody User user, @PathVariable String id) {
        user.setId(id);
        userService.update(user);
        return "ok";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@PathVariable String id) {
        userService.deleteById(id);
        return "ok";
    }
}
