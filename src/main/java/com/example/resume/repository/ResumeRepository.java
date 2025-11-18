package com.example.resume.repository;

import com.example.resume.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    @Query("""
        select r from Resume r
        join fetch r.user u
        where u.username = :username
    """)

    Optional<Resume> findByUsernameWithUser(@Param("username") String username);
}
