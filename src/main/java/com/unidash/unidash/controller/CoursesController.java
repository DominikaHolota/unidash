package com.unidash.unidash.controller;

import com.unidash.unidash.entity.Notices;
import com.unidash.unidash.entity.Users;
import com.unidash.unidash.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoursesController {

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String showCourses() {
        return "courses";
    }

}
