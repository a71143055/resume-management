package com.example.resume.repository;

import com.example.resume.model.Resume;
import com.example.resume.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
    Optional<Resume> findByUser(User user);
}
