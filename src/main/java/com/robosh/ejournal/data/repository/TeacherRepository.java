package com.robosh.ejournal.data.repository;

import com.robosh.ejournal.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<User, Long> {
}
