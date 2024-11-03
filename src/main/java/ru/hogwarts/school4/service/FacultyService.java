package ru.hogwarts.school4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
@RequiredArgsConstructor
public class FacultyService  {

    private final FacultyRepository facultyRepository;
    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    public Faculty getById(Long id) {

        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty save(String name, String color) {
        Faculty faculty = new Faculty();
        faculty.setName(name);
        faculty.setColor(color);
        return facultyRepository.save(Faculty);
    }
    public void  deleteById(long id) {
        facultyRepository.deleteById(id);
    }
    public List<Faculty> filterFacultyByColor(String color) {
        return facultyRepository.findFacultyByColor(color);
    }
}

