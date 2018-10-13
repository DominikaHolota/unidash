package com.unidash.unidash.repo;

import com.unidash.unidash.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);

    Users findByRole(String role);

    List<Users> findAll();

    @Transactional
    @Modifying
    @Query("delete from Users u where u.id=:x")
    Users deleteUser(@Param("x") int id);
}

