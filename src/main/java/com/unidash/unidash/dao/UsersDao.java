package com.unidash.unidash.dao;

import com.unidash.unidash.entity.Student;
import com.unidash.unidash.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Users> findById(int id) {
        String sql = "select * from users where id = " + id;
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<Users>(Users.class)
        );
    }

}
