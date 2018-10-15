package com.unidash.unidash.repo;

import com.unidash.unidash.entity.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subjects, Integer> {
    Subjects findByName(String name);

}
