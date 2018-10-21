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

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    UsersDao usersDao;

    @GetMapping("/admin/users")
    public String showAll(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin/users";
    }

    @GetMapping("admin/user/edit/{id}")
    public String getUser(@PathVariable int id, Model model) {
        model.addAttribute("user", usersDao.findById(id));
        return "admin/userEdit";
    }

    //
//    @RequestMapping(value="admin/user/edit/{id}", method = RequestMethod.GET)
//    public String edit(@PathVariable Long id, Model model) {
//        Users user = new Users();
//        model.addAttribute("user", userRepository.findById(id));
//        return "admin/userEdit";
//    }

    @RequestMapping(value = "admin/user/edit/{id}", method = RequestMethod.POST)
    public String saveUser(Users user, @RequestParam(defaultValue = "false") boolean pass_change) {
        String password = user.getPassword();
        if (pass_change == true) {
            password = userService.encryptPass(password);
            user.setPassword(password);
        }

        userService.editUser(user, user.getEmail(), user.getRole(), user.getName(), user.getLastname(), user.isActive(), user.getPassword());
        return "admin/users";
    }


}


