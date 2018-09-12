package com.unidash.unidash.controller;

import com.unidash.unidash.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    StudentDao studentDao;

    @RequestMapping("/")
    public String index() {
        return "witaj chamie";
    }

}
