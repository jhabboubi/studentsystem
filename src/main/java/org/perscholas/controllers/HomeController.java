package org.perscholas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("app")
public class HomeController {


    @GetMapping("/test2")
    public String index(){
        return "index";
    }

    @GetMapping("/test")
    public String test(){
        return "hello";
    }
}
