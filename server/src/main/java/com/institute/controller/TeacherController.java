package com.institute.controller;

import com.institute.model.User;
import com.institute.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getTeacherDetails(@PathVariable Long id) {
        return ResponseEntity.ok(teacherService.getTeacherDetails(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateTeacherDetails(@PathVariable Long id, @RequestBody User teacher) {
        return ResponseEntity.ok(teacherService.updateTeacherDetails(id, teacher));
    }

    @PutMapping("/students/{studentId}")
    public ResponseEntity<User> updateStudentAcademicRecord(@PathVariable Long studentId, @RequestBody User student) {
        return ResponseEntity.ok(teacherService.updateStudentAcademicRecord(studentId, student));
    }
}
