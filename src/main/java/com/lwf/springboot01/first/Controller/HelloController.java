package com.lwf.springboot01.first.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 创建人:CP
 * 创建时间:2020/6/15 11:08 上午
 * 项目名称:first
 * 类名:HelloController
 * 类描述:TODO
 **/
@Controller
public class HelloController {
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "login";
//    }

//    @RequestMapping("/main.html")
//    public String dashboard(){
//        return "dashboard";
//    }


    @ResponseBody
    @RequestMapping("/hello")
    public String Hello(){
        return "hello world";
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }

}
