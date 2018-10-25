package com.example.redis.springredis.resource;

import com.example.redis.springredis.model.Student;
import com.example.redis.springredis.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/student")
public class StudentResource {

    private StudentRepository studentRepository;

    public StudentResource(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Edit the name of a user by their matriculation number
    @GetMapping("/editName/{matriculationNumber}/{name}/")
    public Student editName(@PathVariable("matriculationNumber") final Long matriculationNumber,
                            @PathVariable("name") final String name) {
        Integer numberOfCoursesRepo =  studentRepository.getNumberOfCoursesByMatriculationNumber(matriculationNumber);
        studentRepository.save(new Student(matriculationNumber, name, numberOfCoursesRepo));
        return studentRepository.findByMatriculationNumber(matriculationNumber);
    }

    // Edit the number of courses of a user by their matriculation number
    @GetMapping("/editName/{matriculationNumber}/{numberOfCourses}/")
    public Student editName(@PathVariable("matriculationNumber") final Long matriculationNumber,
                            @PathVariable("numberOfCourses") final Integer numberOfCourses) {
        String nameRepo = studentRepository.getNameByMatriculationNumber(matriculationNumber);
        studentRepository.save(new Student(matriculationNumber, nameRepo, numberOfCourses));
        return studentRepository.findByMatriculationNumber(matriculationNumber);
    }

    // Save a new user into the repository
    @GetMapping("/save/{matriculationNumber}/{name}/{numberOfCourses}")
    public Student save(@PathVariable("matriculationNumber") final Long matriculationNumber,
                        @PathVariable("name") final String name,
                        @PathVariable("numberOfCourses") final Integer numberOfCourses) {
        studentRepository.save(new Student(matriculationNumber, name, numberOfCourses));
        return studentRepository.findByMatriculationNumber(matriculationNumber);
    }
}
