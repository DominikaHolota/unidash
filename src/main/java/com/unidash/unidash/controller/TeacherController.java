package com.unidash.unidash.controller;

import com.unidash.unidash.dao.StudentDao;
import com.unidash.unidash.dao.SubjectDao;
import com.unidash.unidash.dao.UsersDao;
import com.unidash.unidash.entity.Grades;
import com.unidash.unidash.entity.Students;
import com.unidash.unidash.entity.Subjects;
import com.unidash.unidash.entity.Users;
import com.unidash.unidash.repo.StudentRepository;
import com.unidash.unidash.repo.SubjectRepository;
import com.unidash.unidash.repo.UserRepository;
import com.unidash.unidash.service.GradeService;
import com.unidash.unidash.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.Subject;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UsersDao userDao;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/teacher/students")
    public String showAll(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "/teacher/users";
    }

    @RequestMapping(value = "/teacher/studentGrade/add/{id}", method = RequestMethod.GET)
    public ModelAndView addGrade(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        Users user = userRepository.findById(id);
        List<Students> students = studentDao.findStudentById(user.getId());
        Students student = students.get(0);
        List<Subjects> subjects = subjectDao.findAll();
        Grades grade = new Grades();
        modelAndView.addObject("student", student);
        modelAndView.addObject("subjects", subjects);
        modelAndView.addObject("grade", grade);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("teacher/addGrade");
        return modelAndView;
    }

    @RequestMapping(value = "/teacher/studentGrade/add/{id}", method = RequestMethod.POST)
    public ModelAndView saveGrade(@RequestParam("value") int v, @RequestParam("subId") int ss, @PathVariable int id,
                                  Grades grade, Users user) {
        ModelAndView modelAndView = new ModelAndView();
        user = userRepository.findById(id);
        List<Students> students = studentDao.findStudentById(user.getId());
        List<Subjects> subjectsList = subjectDao.findByID(ss);
        Subjects subs = subjectsList.get(0);
        Students student = students.get(0);
        grade.setSubject(subs);
        grade.setValue(Integer.valueOf(v));
        grade.setStudent(student);
        gradeService.saveGrade(grade);
        modelAndView.addObject("successMessage", "Ocena została dodana");
        modelAndView.addObject("grade", new Grades());
        modelAndView.setViewName("teacher/addGrade-ok");
        return modelAndView;
    }


}
