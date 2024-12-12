package ru.hogwarts.school4.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import ru.hogwarts.school4.model.Faculty;
import ru.hogwarts.school4.repository.FacultyRepository;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class FacultyControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    Faculty faculty;

    @BeforeEach
    public void clearDB() {
        facultyRepository.deleteAll();
        faculty = new Faculty();

        @Test
        void shouldCreateFaculty() {
            ResponseEntity<Faculty> facultyResponseEntity = restTemplate.postForEntity(
                    "http:/localhost:" + port + "/faculties",
                    faculty,
                    Faculty.class
            );
assertNotNull(facultyResponseEntity);
assertEquals(facultyResponseEntity.getStatusCode(),
        HttpStatusCode.valueOf(200));

Faculty actual = facultyResponseEntity.getBody();
assertNotNull(actual.getId());
assertEquals(faculty.getName(), actual.getName());
assertThat(actual.getColor())
        .isNotEmpty()
        .isEqualTo(faculty.getColor());
        }
    }

    @Test
    void shouldGetFaculty() {
        faculty = facultyRepository.save(faculty);

        ResponseEntity<Faculty> facultyResponseEntity = restTemplate.postForEntity(
                "http:/localhost:" + port + "/faculties",
                faculty.getId(),
                Faculty.class
        );
        assertNotNull(facultyResponseEntity);
        assertEquals(facultyResponseEntity.getStatusCode(),
                HttpStatusCode.valueOf(200));

        Faculty actual = facultyResponseEntity.getBody();
        assertEquals(faculty.getName(), actual.getName());
        assertEquals(faculty.getId(), actual.getId());
        assertEquals(faculty.getColor(), actual.getColor());

    }
}




