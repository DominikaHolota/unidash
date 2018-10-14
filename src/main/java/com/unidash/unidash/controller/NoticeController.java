package com.unidash.unidash.controller;

import com.unidash.unidash.entity.Notices;
import com.unidash.unidash.entity.Users;
import com.unidash.unidash.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/admin/notice/add", method = RequestMethod.GET)
    public ModelAndView noticeAdd() {
        ModelAndView modelAndView = new ModelAndView();
        Notices notice = new Notices();
        modelAndView.addObject("notice", notice);
        modelAndView.setViewName("admin/noticeAdd");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/notice/add", method = RequestMethod.POST)
    public ModelAndView createNewNotice(@RequestParam("noticeContent") String content, Notices notice) {
        ModelAndView modelAndView = new ModelAndView();
        notice.setNoticeContent(content);
        notice.setDate();
        noticeService.saveNotice(notice);
        modelAndView.addObject("successMessage", "Ogłoszenie zostało dodane!");
        modelAndView.addObject("notice", new Notices());
        modelAndView.setViewName("admin/noticeAdd");
        return modelAndView;
    }
}
