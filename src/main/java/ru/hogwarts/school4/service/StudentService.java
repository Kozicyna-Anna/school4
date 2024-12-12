package ru.hogwarts.school4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hogwarts.school4.model.Student;

import java.util.Collection;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@Service
@RequiredArgsConstructor
public class StudentService extends StudentService {

    public void remove(int id) {
        FacultyService studentRepository = new FacultyService();
        studentRepository.deleteById(id);
    }

    public Integer add(Student student) {
        FacultyService studentRepository = new FacultyService();
        return (int) Math.toIntExact(studentRepository.save(student).getId());
    }

    public Collection<Student> findByAgeBetween(int fromAge, int toAge) {
        StudentService studentRepository = null;
        return studentRepository.findByAgeBetween(fromAge, toAge);
    }

    public Object add(Long studentId, Student student) {
        return null;
    }

    public Student findStudent(Long id) {
        return null;
    }

    public void findById(int id) {
    }

    public Student editStudent(Student student) {
        return student;
    }

    public Object get(Long studentId) {
        return null;
    }
}









