package com.goninja.restdemo.rest;

import com.goninja.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> theStudents;

    // define @PostConstruct to load the student data only once
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Poornima", "Patel"));
        theStudents.add(new Student("Mario", "Rossi"));
        theStudents.add(new Student("Mary", "Smith"));
        theStudents.add(new Student("James", "Johnson"));
        theStudents.add(new Student("Patricia", "Brown"));
        theStudents.add(new Student("Michael", "Williams"));
        theStudents.add(new Student("Linda", "Jones"));
        theStudents.add(new Student("Robert", "Garcia"));
    }

    // define endpoint for "/students" - return list of students

    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }

    @GetMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID) {
//        if (studentID >= theStudents.size() || studentID < 0) {
//            throw new StudentNotFoundException("Student id not found - " + studentID);
//        }
        return theStudents.get(studentID);
    }
}
