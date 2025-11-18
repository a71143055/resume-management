package com.example.resume.service;

import com.example.resume.model.Resume;
import com.example.resume.repository.ResumeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeService {
    private final ResumeRepository resumeRepository;

    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public void save(Resume resume) {
        resumeRepository.save(resume);
    }

    public Optional<Resume> findByUsernameWithUser(String username) {
        return resumeRepository.findByUsernameWithUser(username);
    }
}
