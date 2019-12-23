package com.trctc.app.repository;

import com.trctc.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public Optional<User> findByUserName(String userName);
}
