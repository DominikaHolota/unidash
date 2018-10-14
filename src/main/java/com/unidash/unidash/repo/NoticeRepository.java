package com.unidash.unidash.repo;

import com.unidash.unidash.entity.Notices;
import com.unidash.unidash.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notices, Integer> {
    Notices findById(int id);

    @Query(value = "SELECT * FROM notices ORDER BY date DESC LIMIT 5;", nativeQuery = true)
    List<Notices> findLastFive();
}
