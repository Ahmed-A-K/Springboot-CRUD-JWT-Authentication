package com.example.demo.service;

import com.example.demo.Response;
import com.example.demo.Student;
import com.example.demo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.request.EmailRequest;
import com.example.demo.request.StudentRequest;


import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService implements IStudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ResponseEntity<Object> saveStudent(StudentRequest studentRequest) {
            Student student = Student.builder()
                    .name(studentRequest.getName())
                    .email(studentRequest.getEmail()).build();
            studentRepository.save(student);
            return Response.generateResponse("Student added to the database", HttpStatus.OK,student);
    }

    @Override
    public ResponseEntity<Object> showStudent() {
        ArrayList<Student> listSt= (ArrayList<Student>) studentRepository.findAll();
        if(!listSt.isEmpty()) {
            return Response.generateResponse("List of students",HttpStatus.OK,listSt);
        } else {
            return Response.generateResponse("No students in database",HttpStatus.NOT_FOUND,listSt);
        }
    }

    @Override
    public ResponseEntity<Object> deleteStudent(Integer id) {
        Optional<Student> st = studentRepository.findById(id);
        if(st.isEmpty()) {
            return Response.generateResponse("Student does not exit",HttpStatus.NOT_FOUND,st);
        } else {
            studentRepository.deleteById(id);
            return Response.generateResponse("Student has been successfully deleted",HttpStatus.OK,st);
        }
    }

    @Override
    public ResponseEntity<Object> updateStudentEmail(EmailRequest emailRequest) {
        Student st = Student.builder().email(emailRequest.getEmail()).id(emailRequest.getId()).build();
        Optional<Student> student = studentRepository.findById(st.getId());

        if(student.isEmpty()) {
            return Response.generateResponse("No student exists",HttpStatus.NOT_FOUND,st.getId());
        } else {
            Student stu = studentRepository.findById(st.getId()).get();
            stu.setEmail(st.getEmail());
            studentRepository.save(stu);
            return Response.generateResponse("Student email has been updated",HttpStatus.OK,student);

        }
    }
}
