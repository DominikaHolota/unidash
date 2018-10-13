package com.unidash.unidash.controller;

        import com.unidash.unidash.dao.StudentDao;
        import com.unidash.unidash.dao.UsersDao;
        import com.unidash.unidash.entity.Users;
        import com.unidash.unidash.repo.UserRepository;
        import com.unidash.unidash.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;
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


}
