package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createFaculty(@RequestBody Faculty faculty) {
        facultyService.createFaculty(faculty);
        return faculty.getId();
    }

    @GetMapping("{id}")
    public Faculty getFacultyById(@PathVariable long id) {
        return facultyService.getFaculty(id);
    }

    @GetMapping
    public Collection<Faculty> getFacultiesByColor(@RequestParam String color) {
        return facultyService.getFacultiesByColor(color);
    }

    @GetMapping("search")
    public Collection<Faculty> getFacultiesByNameIgnoreCaseOrColorIgnoreCase(@RequestParam String text) {
        return facultyService.getFacultiesByNameIgnoreCaseOrColorIgnoreCase(text);
    }

    @GetMapping("{id}/students")
    public Collection<Student> getFacultyStudents(@PathVariable long id) {
        return facultyService.getFacultyStudents(id);
    }

    @PutMapping
    public Faculty updateFaculty(@RequestBody Faculty faculty) {
        return facultyService.updateFaculty(faculty);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFacultyById(@PathVariable long id) {
        facultyService.deleteFaculty(id);
    }
}
