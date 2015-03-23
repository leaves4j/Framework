package com.leaves.framework.controller;

import com.leaves.framework.model.Role;
import com.leaves.framework.service.IRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: jiangq
 * Date: 2015/3/18
 * Time: 10:02
 * Description:
 */
@Controller
public class RoleController {
    @Resource(name = "roleService")
    IRoleService roleService;

    @RequestMapping(value = "framework/roles", method = RequestMethod.GET)
    public ModelAndView getRolePage(Model model) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("FrameWork/JSP/role");
        return mv;
    }

    @RequestMapping(value = "framework/role", method = RequestMethod.GET)
    @ResponseBody
    public List<Role> getRoleList() {
        return roleService.findAll();
    }

    @RequestMapping(value = "framework/role", method = RequestMethod.POST)
    @ResponseBody
    public String addRole(@RequestBody Role role) {
        return roleService.addOrUpdate(role);
    }

    @RequestMapping(value = "framework/role/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteRole(@PathVariable String id) {
        roleService.deleteById(id);
        return "ok";
    }
}
