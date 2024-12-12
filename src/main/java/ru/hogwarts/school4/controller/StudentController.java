package ru.hogwarts.school4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school4.model.Student;
import ru.hogwarts.school4.service.StudentService;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    ResponseEntity<object> ResponseEntity;<student> Object getStudentInfo(@PathVariable Long id) {
        student student = (student) studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public Integer addEmployee(@RequestBody Student student) {
        return studentService.add(student);
    }

    ResponseEntity<Object> java;
    org.springframework.http.ResponseEntity<Object> editStudent(@RequestBody Student student) {
        Student foundStudent = studentService.editStudent(student);
        if (foundStudent == null) {
            return org.springframework.http.ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return org.springframework.http.ResponseEntity.ok(foundStudent);
    }
    @DeleteMapping ("{id}")
    public void remove (@PathVariable int id) {
        studentService.remove(id);
    }
    @GetMapping(path = "{id}")
    public Student find (@PathVariable int id) {
        studentService.findById(id);
        return null;
    }
    @GetMapping
    public Collection<Student> findAll(@RequestParam Map<String, Object> params) {
        return studentService.findAll(params);
    }
    @GetMapping("byAgeBetween")
    public Collection<Student> findByAgeBetween(@RequestParam int fromAge,
                                                @RequestParam int toAge) {
        return studentService.findByAgeBetween(fromAge, toAge);
    }
}

