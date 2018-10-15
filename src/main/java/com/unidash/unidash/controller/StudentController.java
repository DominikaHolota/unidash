package com.unidash.unidash.controller;

import com.unidash.unidash.dao.GradeDao;
import com.unidash.unidash.dao.StudentDao;
import com.unidash.unidash.dao.SubjectDao;
import com.unidash.unidash.entity.Users;
import com.unidash.unidash.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    StudentDao studentDao;

    @Autowired
    UserRepository userRepository;

    @Autowired
    GradeDao gradeDao;

    @Autowired
    SubjectDao subjectDao;

    @GetMapping("/student")
    public String getAll() {
        return "Studenci: " + studentDao.findAll();
    }

    @GetMapping("/student/{id}")
    public String getById(@PathVariable int id) {
        return "" + studentDao.findById(id);
    }

//    @GetMapping("/admin/allUsers")
//    public String showAll(Model model) {
//        model.addAttribute("users", userRepository.findAll());
//        return "admin/allUsers";
//    }

    @GetMapping("/student/grades")
    public String getSubjects(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = userRepository.findByEmail(auth.getName());

        model.addAttribute("subjects", subjectDao.findByStudentId(user.getId()));
        return "/student/studentGrades";

    }

    @GetMapping("/student/grades/{name}")
    public String getGrades(@PathVariable(name = "name") String name, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = userRepository.findByEmail(auth.getName());

        model.addAttribute("grades", gradeDao.findByUserIdAndSubjectName(user.getId(), name));
        return "/student/gradesList";
    }


}


