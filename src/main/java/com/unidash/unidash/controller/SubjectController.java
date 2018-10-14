package com.unidash.unidash.controller;

import com.unidash.unidash.entity.Subjects;
import com.unidash.unidash.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/admin/subject/add", method = RequestMethod.GET)
    public ModelAndView subjectAddControler() {
        ModelAndView modelAndView = new ModelAndView();
        Subjects subject = new Subjects();
        modelAndView.addObject("subject", subject);
        modelAndView.setViewName("/admin/subjectAdd");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/subject/add", method = RequestMethod.POST)
    public ModelAndView subiectAdd(@RequestParam("name") String name, Subjects subject) {
        ModelAndView modelAndView = new ModelAndView();
        subject.setName(name);
        subjectService.saveSubject(subject);
        modelAndView.addObject("successMessage", "Przedmiot został dodany");
        modelAndView.addObject("subject", new Subjects());
        modelAndView.setViewName("admin/subjectAdd");
        return modelAndView;
    }
}
