package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.ResourceNotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.*;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty getFaculty(long id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Факультет с id " + id + " не найден"));
    }

    public Collection<Faculty> getFacultiesByColor(String color) {
        return facultyRepository.findByColor(color);
    }

    public Faculty updateFaculty(Faculty faculty) {
        if (!facultyRepository.existsById(faculty.getId())) {
            throw new ResourceNotFoundException("Факультет с id " + faculty.getId() + " не найден");
        }
        facultyRepository.save(faculty);
        return faculty;
    }

    public void deleteFaculty(long id) {
        if (!facultyRepository.existsById(id)) {
            throw new ResourceNotFoundException("Факультет с id " + id + " не найден");
        }
        facultyRepository.deleteById(id);
    }
}