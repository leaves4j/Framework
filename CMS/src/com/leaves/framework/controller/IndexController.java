package com.leaves.framework.controller;


import com.leaves.framework.common.CurrentContext;
import com.leaves.framework.common.annotation.Auth;
import com.leaves.framework.common.annotation.CurrentUser;
import com.leaves.framework.model.Function;
import com.leaves.framework.model.Role;
import com.leaves.framework.model.User;
import com.leaves.framework.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;


/**
 * Created by leaves on 2014/10/14.
 */
@Auth
@Controller
public class IndexController {
    @Resource(name = "userService")
    private IUserService userService;
    @CurrentUser
    private CurrentContext context;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView getIndexPage(Model model) {
        User user = userService.getUser(context.getUserId());
        List<Function> functions = new ArrayList<Function>();
        for (Role role : user.getRoles()) {
            for (Function function : role.getFunctions()) {
                if (!functions.contains(function))
                    functions.add(function);
            }
        }
        Collections.sort(functions, new Comparator<Function>() {
            @Override
            public int compare(Function o1, Function o2) {
                return Integer.parseInt(o1.getNumber()) - Integer.parseInt(o2.getNumber());
            }
        });
        ModelAndView mv = new ModelAndView();
        mv.addObject("functions", functions);
        mv.setViewName("FrameWork/view/index");
        return mv;
    }
}
