package com.unidash.unidash.dao;

import com.unidash.unidash.entity.Grades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GradeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
//
//    public List<Students> findAll() {
//        return jdbcTemplate.query(
//            "SELECT email, name, lastname FROM students JOIN users ON users.id = students.user_id",
//                new BeanPropertyRowMapper<Students>(Students.class)
//        );
//    }

    public List<Grades> findByUserIdAndSubjectName(Integer userId, String name) {
        String sql = "select grades.id as id, grades.value as value, subjects.id as subject_id from grades" +
                " join subjects on grades.subject_id= subjects.id" +
                " join users on grades.student_id = users.id" +
                " where users.id= " + userId + " and subjects.name = \'" + name + "\'" +
                " order by subjects.name ";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<Grades>(Grades.class)
        );
    }

}
