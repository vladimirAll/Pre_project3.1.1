package org.example.Pre_project311.repository;

import org.example.Pre_project311.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
