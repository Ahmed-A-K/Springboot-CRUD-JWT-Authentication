package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import com.example.demo.request.EmailRequest;
import com.example.demo.request.StudentRequest;

public interface IStudentService {

    public abstract ResponseEntity<Object> saveStudent(StudentRequest studentRequest);
    public abstract ResponseEntity<Object> showStudent();
    public abstract ResponseEntity<Object> deleteStudent(Integer id);

    public abstract ResponseEntity<Object> updateStudentEmail(EmailRequest emailRequest);

}
