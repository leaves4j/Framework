package com.leaves.framework.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * User: jiangq
 * Date: 2015/4/2
 * Time: 14:20
 * Description:
 */
@Controller
public class PageNotFindController {
    @RequestMapping(value = "*", method = RequestMethod.GET)
    public ModelAndView get404Page(HttpServletRequest request) {
        Logger logger = LoggerFactory.getLogger("");
        logger.debug("No controller to handle the current request:"+request.getRequestURL().toString());
        ModelAndView mv = new ModelAndView();
        mv.setView("Framework/view/404");
        return mv;
    }
}
