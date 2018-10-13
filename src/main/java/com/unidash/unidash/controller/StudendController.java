package com.unidash.unidash.controller;

import com.unidash.unidash.dao.StudentDao;
import com.unidash.unidash.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class StudendController {
    @Autowired
    StudentDao studentDao;


    @GetMapping("/student")
    public String getAll() {
        return "Studenci: " + studentDao.findAll();
    }

    @GetMapping("/student/{id}")
    public String getById(@PathVariable int id) {
        return "" + studentDao.findById(id);
    }
}
