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

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity‹Student› ResponseEntity<Object> getStudentInfo(@PathVariable Long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public Integer addEmployee(@RequestBody Student student) {
        return studentService.add(student);
    }

    @PutMapping("{id}")
    public ResponseEntity‹Student› ResponseEntity<Object> editStudent(@RequestBody Student student) {
        Student foundStudent = studentService.editStudent(student);
        if (foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }
    @DeleteMapping ("{id}")
    public void remove (@PathVariable int id) {
        studentService.remove(id);
    }
    @GetMapping(path = "{id}")
    public Student find (@PathVariable int id) {
        studentService.findById(id);
    }
    @GetMapping
    public Collection<Student> findAll(@RequestParam Map<String, Object> params) {
        return studentService.findAll(params);
    }
    @GetMapping("byAgeBetween")
    public Collection<Student> findByAgeBetween(@RequestParam int fromAge, @RequestParam int toAge) {
        return studentService.findByAgeBetween(fromAge, toAge);
    }
}

