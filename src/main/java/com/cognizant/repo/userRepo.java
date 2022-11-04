package com.cognizant.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.User;

@Repository
public interface userRepo extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
