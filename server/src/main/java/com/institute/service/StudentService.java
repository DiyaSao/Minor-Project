package com.institute.service;

import com.institute.model.User;
import com.institute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private UserRepository userRepository;

    public User getStudentDetails(Long studentId) {
        return userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public User updateStudentDetails(Long studentId, User updatedStudent) {
        return userRepository.findById(studentId).map(student -> {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            return userRepository.save(student);
        }).orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
