package com.jorgeguinto.reservation_demo.repos;

import com.jorgeguinto.reservation_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
