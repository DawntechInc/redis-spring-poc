package com.example.redis.springredis.impl;

import com.example.redis.springredis.model.Student;
import com.example.redis.springredis.repository.StudentRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private RedisTemplate<String, Student> redisTemplate;
    private HashOperations hashOperations; // for operations on the rest template

    public StudentRepositoryImpl(RedisTemplate<String, Student> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, Student> findAll() {
        return hashOperations.entries("STUDENT");
    }

    @Override
    public Student findByMatriculationNumber(Long matriculationNumber) {
        return (Student) hashOperations.get("STUDENT", matriculationNumber);
    }

    @Override
    public void update(Student student) {
        save(student);
    }

    @Override
    public void delete(Long matriculationNumber) {
        hashOperations.delete("STUDENT", matriculationNumber);
    }

    @Override
    public void save(Student student) {
        // key: matriculationNumber, value: object student
        hashOperations.put("STUDENT", student.getMatriculationNumber(), student);
    }
}
