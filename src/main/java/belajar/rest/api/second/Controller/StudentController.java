package belajar.rest.api.second.Controller;


import belajar.rest.api.second.Model.Student;
import belajar.rest.api.second.Repository.StudentRepository;
import belajar.rest.api.second.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.View;

import java.util.List;

@RestController
@RequestMapping
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private View error;

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@Valid @RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public List <Student> getAllStudent(){
        return studentService.getAllStudent();
    }

}
