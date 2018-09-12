package com.unidash.unidash.dao;

import com.unidash.unidash.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Student> findAll() {
        return jdbcTemplate.query(
            "select * from student",
            new BeanPropertyRowMapper<Student>(Student.class)
        );
    }

    public List<Student> findById(int id) {
        String sql = "select * from student where id = " + id;

        return jdbcTemplate.query(
            sql,
            new BeanPropertyRowMapper<Student>(Student.class)
        );
    }

}
