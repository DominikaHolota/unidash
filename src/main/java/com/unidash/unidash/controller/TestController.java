package com.unidash.unidash.controller;

import com.unidash.unidash.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/studenty/studentyglupie")
    public String studenty() {
        return "stuent/main";
    }

}
