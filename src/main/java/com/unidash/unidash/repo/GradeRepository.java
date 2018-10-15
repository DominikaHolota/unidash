package com.unidash.unidash.repo;

import com.unidash.unidash.entity.Grades;
import com.unidash.unidash.entity.Notices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grades, Long> {

}
