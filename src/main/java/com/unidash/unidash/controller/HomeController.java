package com.unidash.unidash.controller;

import com.unidash.unidash.dao.UsersDao;
import com.unidash.unidash.repo.NoticeRepository;
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


@Controller
public class HomeController {

    @Autowired
    UsersDao usersDao;
    @Autowired
    UserRepository userRepository;
    @Autowired
    NoticeRepository noticeRepository;
    UserService userService;

    @GetMapping("/dashboard")
    public String showAll(Model model) {

        Logger logger = LoggerFactory.getLogger(HomeController.class);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user", userRepository.findByEmail(auth.getName()));
        model.addAttribute("notices", noticeRepository.findLastFive());

        return "index";
    }

}
