package ru.hogwarts.school4.repository;

import java.util.Collection;

public interface StudentRepository  extends JpaRepository<Student, Integer> {

    Collection<Student> findByAgeBetween (int fromAge, int toAge);
}
