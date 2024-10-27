package com.institute.service;

import com.institute.model.User;
import com.institute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private UserRepository userRepository;

    public User getTeacherDetails(Long teacherId) {
        return userRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    public User updateTeacherDetails(Long teacherId, User updatedTeacher) {
        return userRepository.findById(teacherId).map(teacher -> {
            teacher.setName(updatedTeacher.getName());
            teacher.setEmail(updatedTeacher.getEmail());
            return userRepository.save(teacher);
        }).orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    public User updateStudentAcademicRecord(Long studentId, User updatedStudent) {
        return userRepository.findById(studentId).map(student -> {
            student.setRoles(updatedStudent.getRoles()); 
            return userRepository.save(student);
        }).orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
