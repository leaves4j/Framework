package com.leaves.framework.controller;

import com.leaves.framework.common.CommonFunction;
import com.leaves.framework.model.User;
import com.leaves.framework.service.IUserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

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

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView getUserPage(Model model) {

        ModelAndView mv = new ModelAndView();
        List<User> userList = userService.getUserInfo();
        String jsonUserList = CommonFunction.ObjectToJSON(userList);
        mv.addObject("userList", jsonUserList);
        mv.setViewName("FrameWork/user");
        return mv;
    }
}
