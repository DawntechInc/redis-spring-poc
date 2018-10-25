package com.example.redis.springredis.repository;

import com.example.redis.springredis.model.Student;

import java.util.Map;

public interface StudentRepository {

    Map<String, Student> findAll();

    Student findByMatriculationNumber(Long matriculationNumber);

    void update(Student student);

    void delete(Long matriculationNumber);

    void save(Student student);

    Integer getNumberOfCoursesByMatriculationNumber(Long matriculationNumber);
}
