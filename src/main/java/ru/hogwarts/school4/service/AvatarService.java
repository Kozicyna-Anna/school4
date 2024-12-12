package ru.hogwarts.school4.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AvatarService {
    private final AvatarService avatarRepository;

    public AvatarService(AvatarService avatarRepository) {
        this.avatarRepository = avatarRepository;
    }

    public long saveAvatar(MultipartFile file, int studentId) {
        long il = 0;
        return il;
    }
}

