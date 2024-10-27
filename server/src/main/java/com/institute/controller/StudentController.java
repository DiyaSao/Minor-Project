package com.institute.controller;

import com.institute.model.User;
import com.institute.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getStudentDetails(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentDetails(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateStudentDetails(@PathVariable Long id, @RequestBody User student) {
        return ResponseEntity.ok(studentService.updateStudentDetails(id, student));
    }
}
