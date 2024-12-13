package ru.hogwarts.school4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school4.model.Avatar;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

}

