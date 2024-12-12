package ru.hogwarts.school4.model;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import org.springframework.data.annotation.Id;

@Entity
public class Avatar {
    @Id
    @GeneratedValue

    private String filePath;
    private long fileSize;
    private String nediaType;
    private byte[] data;
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")

    private Student student;
}
