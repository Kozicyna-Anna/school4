package ru.hogwarts.school4.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school4.model.Faculty;
import ru.hogwarts.school4.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")

public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public List<Faculty> getAllFaculty() {
        return (List<Faculty>) facultyService.getAll();
    }
    @PostMapping("/add")
    public Faculty createFaculty(@RequestParam String name, @RequestParam String color) {
        return facultyService.save(name, color);
    }

    @GetMapping("/{id}")
    public Faculty getFacultyById(@PathVariable Long id) {
        return facultyService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void  deleteFacultyById(@PathVariable Long id) {
        facultyService.deleteById(id);

    }
}
