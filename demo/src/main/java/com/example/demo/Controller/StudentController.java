package com.example.demo.Controller;

import com.example.demo.Models.Student;
import com.example.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getSpecificStudent(@PathVariable Long id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student student = optionalStudent.get();
        return student;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        Student newStudent = studentRepository.save(student);
        return newStudent;
    }
}
