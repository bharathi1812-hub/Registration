package com.gprec.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gprec.demo.model.User;
@Repository
public interface  UserRepository extends JpaRepository<User, Long>{
    boolean existsByUsername(String username);

}
