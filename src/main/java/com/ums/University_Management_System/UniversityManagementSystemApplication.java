package com.ums.University_Management_System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.ums.University_Management_System.repository")
@EntityScan("com.ums.University_Management_System.entity")
public class UniversityManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityManagementSystemApplication.class, args);
	}

}
