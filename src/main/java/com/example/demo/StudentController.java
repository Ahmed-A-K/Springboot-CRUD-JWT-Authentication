package com.example.demo;


import com.example.demo.config.JwtService;
import com.example.demo.service.HashService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.request.EmailRequest;
import com.example.demo.request.StudentRequest;
import com.example.demo.service.StudentService;


@RestController// This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping(path="/add") // Map ONLY POST Requests
    public ResponseEntity<Object> addNewStudent (@Valid @RequestBody StudentRequest stRequest) throws Exception {
            return new ResponseEntity<>(studentService.saveStudent(stRequest),HttpStatus.CREATED);
    }

    @GetMapping(path="/show")
    public @ResponseBody ResponseEntity<Object> getAllStudents(){
        return studentService.showStudent();
    }

    @DeleteMapping(path="/delete")
    public @ResponseBody ResponseEntity<Object> deleteStudent(@RequestBody Integer id) {
        return studentService.deleteStudent(id);
    }

    @PatchMapping(path="/updateEmail")
    public @ResponseBody ResponseEntity<Object> updateStudentEmail(@Valid @RequestBody EmailRequest emailRequest) throws Exception {
        return studentService.updateStudentEmail(emailRequest);
    }

}
