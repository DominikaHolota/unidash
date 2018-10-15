package com.unidash.unidash.dao;

import com.unidash.unidash.entity.Students;
import com.unidash.unidash.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    StudentRepository studentRepository;

    public List<Students> findAll() {
        return jdbcTemplate.query(
                "SELECT email, name, lastname FROM students JOIN users ON users.id = students.user_id",
                new BeanPropertyRowMapper<Students>(Students.class)
        );
    }

    public List<Students> findById(int id) {
        String sql = "SELECT email, name, lastname FROM students JOIN users ON users.id = students.user_id where students.id=" + id;

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<Students>(Students.class)
        );
    }

    public List<Students> findStudentById(int id) {
        String sql = "SELECT students.id, users.id, fos_id, grouid FROM students JOIN users ON users.id = students.user_id where students.id=" + id;

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<Students>(Students.class)
        );
    }

//
//    public List<Students> findById(Long id) {
//        List<student>
//    }

}
