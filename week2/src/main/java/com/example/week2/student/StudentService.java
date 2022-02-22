package com.example.week2.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Csaba",
                        "janocsikcsaba@gmail.com",
                        LocalDate.of(1998, Month.JUNE, 30),
                        23
                )
        );
    }
}