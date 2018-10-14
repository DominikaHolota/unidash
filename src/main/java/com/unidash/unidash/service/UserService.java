package com.unidash.unidash.service;

import com.unidash.unidash.entity.Users;
import com.unidash.unidash.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Users findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public void saveUser(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setActive(true);
        userRepository.save(user);
    }

    public String encryptPass(String pass) {
        return bCryptPasswordEncoder.encode(pass);
    }


    public void editUser(Users user, String email, String role, String name, String lastname, boolean isActive, String password) {
        user.setEmail(email);
        user.setRole(role);

        user.setName(name);
        user.setLastname(lastname);
        user.setActive(isActive);
        user.setPassword(user.getPassword());
        userRepository.save(user);
    }


}


