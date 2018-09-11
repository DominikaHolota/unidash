package com.unidash.unidash.controller;

import com.unidash.unidash.dao.StudentDao;
import com.unidash.unidash.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    StudentDao studentDao;

    @RequestMapping("/")
    public String index() {
        return "Lista studentow: " + studentDao.findAll();
    }

}
