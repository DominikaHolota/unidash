package com.unidash.unidash.dao;

import com.unidash.unidash.entity.Subjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Subjects> findAll() {
        return jdbcTemplate.query(
                "SELECT name,id FROM subjects",
                new BeanPropertyRowMapper<Subjects>(Subjects.class)
        );
    }

    public List<Subjects> findByStudentId(Integer id) {
        String sql = "select subjects.name from grades join subjects on grades.subject_id= subjects.id" +
                " join users on grades.student_id = users.id where users.id = " + id +
                " group by subjects.name";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<Subjects>(Subjects.class)
        );
    }

    public List<Subjects> findByID(Integer id) {
        String sql = "select subjects.name, subjects.id from subjects where subjects.id =" + id;
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<Subjects>(Subjects.class)
        );
    }


}
