package com.sit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sit.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
