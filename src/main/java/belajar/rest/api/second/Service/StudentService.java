package belajar.rest.api.second.Service;


import belajar.rest.api.second.Model.Student;
import belajar.rest.api.second.Repository.StudentRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student){
        student.setStudentId(UUID.randomUUID().toString().split("-")[0]);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getStudentById (String studentId){
        return studentRepository.findById(studentId).get();
    }

    public Student updateStudentById (String studentId, Student studentRequest){
        Student existingStudent = studentRepository.findById(studentId).get();
        if (studentRequest.getAddress()!=null){
            existingStudent.setAddress(studentRequest.getAddress());
        }
        return studentRepository.save(existingStudent);
    }

    public String deleteStudentById (String studentId){
        studentRepository.deleteById(studentId);
        return studentId + "Student delete sucessfuly";
    }
}
