package com.myalley.thymeleaf3.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafHelloCtrl {

    @GetMapping("/")
    public String pageHello() {
        return "hello";
    }
}
