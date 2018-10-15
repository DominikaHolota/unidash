package com.unidash.unidash.repo;

import com.unidash.unidash.entity.Grades;
import com.unidash.unidash.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Grades, Long> {

}
