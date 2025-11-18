package com.example.resume.controller;

import com.example.resume.model.Resume;
import com.example.resume.model.User;
import com.example.resume.service.ResumeService;
import com.example.resume.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/resume")
public class ResumeController {
    private final ResumeService resumeService;
    private final UserService userService;

    public ResumeController(ResumeService resumeService, UserService userService) {
        this.resumeService = resumeService;
        this.userService = userService;
    }

    @GetMapping
    public String showResume(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow();
        Resume resume = resumeService.findByUser(user).orElse(new Resume());
        model.addAttribute("resume", resume);
        return "resume";
    }

    @PostMapping
    public String updateResume(@ModelAttribute Resume resume, Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow();
        resume.setUser(user); // ✅ 반드시 연결
        resumeService.save(resume);
        return "redirect:/resume";
    }
}
