package com.unidash.unidash.dao;

import com.unidash.unidash.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Students> findAll() {
        return jdbcTemplate.query(
            "select * from student",
                new BeanPropertyRowMapper<Students>(Students.class)
        );
    }

    public List<Students> findById(int id) {
        String sql = "select * from student where id = " + id;

        return jdbcTemplate.query(
            sql,
                new BeanPropertyRowMapper<Students>(Students.class)
        );
    }

}
