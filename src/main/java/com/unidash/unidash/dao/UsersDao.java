package com.unidash.unidash.dao;

import com.unidash.unidash.entity.Student;
import com.unidash.unidash.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UsersDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


}
