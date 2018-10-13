package com.unidash.unidash.controller;

        import com.unidash.unidash.dao.StudentDao;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RestController;

@Controller
public class StudentController {

    @Autowired
    StudentDao studentDao;

    @GetMapping("/student")
    public String getAll() {
        return "Studenci: " + studentDao.findAll();
    }

    @GetMapping("/student/{id}")
    public String getById(@PathVariable int id) {
        return "" + studentDao.findById(id);
    }


}
