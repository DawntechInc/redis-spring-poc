package com.example.redis.springredis.model;

import java.io.Serializable;
public class Student implements Serializable {

    private Long matriculationNumber;
    private String name;
    private Integer numberOfCourses;

    public Student(Long matriculationNumber, String name, Integer numberOfCourses) {
        this.matriculationNumber = matriculationNumber;
        this.name = name;
        this.numberOfCourses = numberOfCourses;
    }

    public Long getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(Long matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfCourses() {
        return numberOfCourses;
    }

    public void setNumberOfCourses(Integer numberOfCourses) {
        this.numberOfCourses = numberOfCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "matriculationNumber=" + matriculationNumber +
                ", name='" + name + '\'' +
                ", numberOfCourses=" + numberOfCourses +
                '}';
    }
}
