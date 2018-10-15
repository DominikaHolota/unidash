package com.unidash.unidash;

import com.unidash.unidash.entity.Users;
import com.unidash.unidash.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

@SpringBootApplication
public class UnidashApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnidashApplication.class, args);
    }
}
