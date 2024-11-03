package ru.hogwarts.school4.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    List<Faculty> findAllByColor(String color);

}
