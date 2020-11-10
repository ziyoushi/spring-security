package com.cc.develop.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.cc.develop.spring.security.controller
 *
 * @author changchen
 * @email java@mail.com
 * @date 2020-11-10 08:50:21
 */
@RestController
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "success";
    }

}
