package com.example.resume.service;

import com.example.resume.model.Resume;
import com.example.resume.model.User;
import com.example.resume.repository.ResumeRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ResumeService {
    private final ResumeRepository resumeRepository;

    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public Resume save(Resume resume) {
        return resumeRepository.save(resume);
    }

    public Optional<Resume> findByUser(User user) {
        return resumeRepository.findByUser(user);
    }
}
