package com.example.redis.springredis.resource;

import com.example.redis.springredis.model.Student;

import java.util.List;

public interface StudentRepository {

    List<Student> findAll();
    Student findByMatriculationNumber(Long matriculationNumber);
    void update(Student student);
    void delete(Long matriculationNumber);
    void save(Student student);
}
