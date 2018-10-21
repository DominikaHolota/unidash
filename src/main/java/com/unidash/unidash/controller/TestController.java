package com.unidash.unidash.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "courses";
    }

    @RequestMapping("/studenty/studentyglupie")
    public String studenty() {
        return "stuent/main";
    }

}
