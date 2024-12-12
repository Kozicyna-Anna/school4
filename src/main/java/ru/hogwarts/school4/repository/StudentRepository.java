package ru.hogwarts.school4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school4.model.Student;

import java.util.Collection;

public interface StudentRepository  extends JpaRepository<Student, Integer> {

    Collection<Student> findByAgeBetween (int fromAge, int toAge);
}
