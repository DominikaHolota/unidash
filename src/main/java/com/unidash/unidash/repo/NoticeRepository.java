package com.unidash.unidash.repo;

import com.unidash.unidash.entity.Notices;
import com.unidash.unidash.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notices, Integer> {
    Notices findById(int id);
}
