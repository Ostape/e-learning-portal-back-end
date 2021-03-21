package com.robosh.ejournal.data.repository;

//import com.robosh.ejournal.data.entity.Teacher;
import com.robosh.ejournal.data.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<User, Long> {
//    User findAllBySchoolId(Long id, Pageable pageable);
}
