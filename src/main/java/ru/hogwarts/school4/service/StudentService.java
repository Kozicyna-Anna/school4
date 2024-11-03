package ru.hogwarts.school4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class StudentService implements StudentService {

    public Collection<Student> findAll(){
        return StudentRepository.findAll();
    }


    public void remove(int id) {
        studentRepository.deleteById(id);
    }
    public Integer add(Student student) {
        return studentRepository.save(student).getId();
    }
    public Collection<Student> findByAgeBetween(int fromAge, int toAge){
        return studentRepository.findByAgeBetween(fromAge, toAge);
    }
}
