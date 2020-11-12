package com.cc.develop.spring.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.cc.develop.spring.security.controller
 *
 * @author changchen
 * @email java@mail.com
 * @date 2020-11-10 08:50:21
 */
@RequestMapping("/test")
@RestController
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "success";
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello spring security";
    }

    @Secured({"ROLE_role","ROLE_admin"})
    @GetMapping("/update")
    public String update(){
        return "hello update";
    }

}
