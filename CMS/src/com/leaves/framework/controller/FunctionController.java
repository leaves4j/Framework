package com.leaves.framework.controller;

import com.leaves.framework.model.Function;
import com.leaves.framework.service.IFunctionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: jiangq
 * Date: 2014/12/28
 * Time: 15:37
 * Description:
 */
@Controller
public class FunctionController {
    @Resource(name = "functionService")
    IFunctionService functionService;

    @RequestMapping(value = "framework/functions", method = RequestMethod.GET)
    public ModelAndView getFunctionPage(Model model) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("FrameWork/view/function");
        return mv;
    }

    @RequestMapping(value = "framework/function", method = RequestMethod.GET)
    @ResponseBody
    public List<Function> getFunctionList() {
        return functionService.findAll();
    }

    @RequestMapping(value = "framework/function", method = RequestMethod.POST)
    @ResponseBody
    public String addOrUpdateFunction(@RequestBody Function function) {
        return functionService.addOrUpdate(function);
    }

    @RequestMapping(value = "framework/function/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteFunction(@PathVariable String id) {
        functionService.deleteById(id);
        return "ok";
    }
}
