package com.leaves.framework.controller;

import com.leaves.framework.common.CommonFunction;
import com.leaves.framework.common.CurrentContext;
import com.leaves.framework.common.RSAUtil;
import com.leaves.framework.model.Role;
import com.leaves.framework.model.User;
import com.leaves.framework.service.ILoginService;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by jiangq on 2015/1/5.
 */
@Controller
public class LoginController {
    @Resource(name = "loginService")
    private ILoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(Model model, HttpSession session) throws NoSuchAlgorithmException {
        //TODO RSA脚本算法有时会生成129位的，暂时先不用
//        //获取RSAKey
//        HashMap<String, Object> RSAMap = RSAUtil.getKeys();
//        //生成公钥和私钥
//        RSAPublicKey publicKey = (RSAPublicKey) RSAMap.get("public");
//        RSAPrivateKey privateKey = (RSAPrivateKey) RSAMap.get("private");
//        //公钥模
//        String public_modulus = publicKey.getModulus().toString();
//        //公钥指数
//        String public_exponent = publicKey.getPublicExponent().toString();
//        //私钥存入session
//        session.setAttribute("Sys_RSA_PrivateKey", privateKey);
        ModelAndView mv = new ModelAndView();
//        mv.addObject("public_modulus", public_modulus);
//        mv.addObject("public_exponent", public_exponent);
        mv.setViewName("FrameWork/view/login");
        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestParam String code, @RequestParam String password, HttpSession session) throws Exception {
//        //获取rsa加密的密码
//        RSAPrivateKey privateKey = (RSAPrivateKey) session.getAttribute("Sys_RSA_PrivateKey");
//        String descrypedPwd = RSAUtil.decryptByPrivateKey(password, privateKey);
//        //获取密码的SHA-256摘要值
//        MessageDigest md = MessageDigest.getInstance("SHA-256");
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        String pdwMD5 = CommonFunction.ByteArrayToHexString(md.digest());

        List<User> users = loginService.getUser(code);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if (users.size() == 0) {
            modelMap.put("state", "false");
            modelMap.put("msg", "账号不存在");
        } else if (users.get(0).getPassword().equals(pdwMD5)) {
            modelMap.put("state", "true");
            CurrentContext context = new CurrentContext();
            User user = users.get(0);
            Set<Role> roles = user.getRoles();
            for (Role role : roles) {
                role.setFunctions(null);
            }
            context.setUseCode(user.getCode());
            context.setUserId(user.getId());
            context.setUserName(user.getName());
            context.setRoles(roles);
            session.setAttribute("Sys_CurrentContext", context);
        } else {
            modelMap.put("state", "false");
            modelMap.put("msg", "密码错误");
        }
        return modelMap;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("Sys_CurrentContext");
        return "redirect:/login";
    }
}
