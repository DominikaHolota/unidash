package com.unidash.unidash.controller;

import com.sun.xml.internal.bind.v2.TODO;
import com.unidash.unidash.dao.StudentDao;
import com.unidash.unidash.dao.UsersDao;
import com.unidash.unidash.entity.Users;
import com.unidash.unidash.repo.UserRepository;
import com.unidash.unidash.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    @Autowired
    StudentDao studentDao;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/student")
    public String getAll() {
        return "Studenci: " + studentDao.findAll();
    }

    @GetMapping("/student/{id}")
    public String getById(@PathVariable int id) {
        return "" + studentDao.findById(id);
    }

    @GetMapping("/admin/allUsers")
    public String showAll(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin/allUsers";
    }

//    TODO: dodać obsługę dezaktywacji użytkownika i podmienić zachowanie pola w tabelce

}


