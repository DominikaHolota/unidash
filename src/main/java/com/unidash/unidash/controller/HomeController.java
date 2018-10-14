package com.unidash.unidash.controller;

import com.unidash.unidash.dao.StudentDao;
import com.unidash.unidash.dao.UsersDao;
import com.unidash.unidash.entity.Users;
import com.unidash.unidash.repo.UserRepository;
import com.unidash.unidash.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    UsersDao usersDao;
    @Autowired
    UserRepository userRepository;
    UserService userService;

    @GetMapping("/dashboard")
    public String showAll(Model model) {

        Logger logger = LoggerFactory.getLogger(HomeController.class);
//
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName(); //get logged in username
//        logger.error(name);
//        Users user = userRepository.findByEmail(name);
//        logger.error(user.toString());
        model.addAttribute("user", userRepository.findByEmail(auth.getName()));

        return "index";
    }

}
