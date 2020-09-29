package com.lwf.springboot01.first.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 创建人:CP
 * 创建时间:2020/6/15 4:30 下午
 * 项目名称:first
 * 类名:LoginController
 * 类描述:TODO
 **/
@Controller
public class LoginController {
    @PostMapping(value = "/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Map<String ,Object> map,
            HttpSession session
    ){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)  ){
            session.setAttribute("loginuser",username);
            return "redirect:/main.html";
        }else {
            map.put("msg","用户名或密码错误");
            return "login";
        }

    }
}
