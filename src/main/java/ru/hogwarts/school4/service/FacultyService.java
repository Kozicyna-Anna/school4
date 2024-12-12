package ru.hogwarts.school4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hogwarts.school4.model.Faculty;
import ru.hogwarts.school4.model.Student;
import ru.hogwarts.school4.repository.FacultyRepository;

import java.awt.*;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyService  {

    private final FacultyRepository facultyRepository;

    public FacultyService() {
        this.facultyRepository = facultyRepository;
    }
    public <faculty> Component getAll() {
        Object List;
        return (Component) facultyRepository.findAll();
    }

    public Faculty getById(Long id) {

        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty save(String name, String color) {
        Faculty faculty = new Faculty();
        faculty.setName(name);
        faculty.setColor(color);
        Faculty Faculty = new Faculty();
        return facultyRepository.save(Faculty);
    }
    public void  deleteById(long id) {
        facultyRepository.deleteById(id);
    }
    public List<Faculty> filterFacultyByColor(String color) {
        List<Faculty> facultyByColor = Collections.unmodifiableList((List<Faculty>) facultyRepository.findFacultyByColor(color));
        return facultyByColor;
    }

    public Student save(Student student) {
    }
}

