package com.unidash.unidash.controller;

import com.unidash.unidash.dao.StudentDao;
import com.unidash.unidash.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/admin/users")
    public String showAll(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin/users";
    }

    @RequestMapping("admin/user/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("product", userRepository.findById(id));
        return "admin/user/edit";
    }


    //    TODO: dodać obsługę dezaktywacji użytkownika i podmienić zachowanie pola w tabelce

}

