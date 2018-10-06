package com.unidash.unidash.repo;

import com.unidash.unidash.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepo extends JpaRepository<Users, Long> {
    Users findByEmail(String email);

    Users findByRole(String role);
}

