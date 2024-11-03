package ru.hogwarts.school4.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@RequestMapping(path = "/avatar")


public class AvatarController {

    private AvatarService avatarService;

    @PostMapping(consumes = MULTIPART_FORM_DATA_VALUE)
    public long saveAvatar(@RequestParam MultipartFile file, @RequestParam int studentId) {
        return avatarService.saveAvatar(file, studentId);
    }
}
