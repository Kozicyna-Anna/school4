package ru.hogwarts.school4.model;

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
