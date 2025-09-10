package com.aababou.demo.controller;

import com.aababou.demo.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
author otman
    */
@RestController
@RequestMapping("/students")
public class StudentController {

    //GET REQUEST
    //localhost://8080/student
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1,"otmane","aababou");
        //return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok()
                .header("costum-header","otmane")
                .body(student);
    }


    //GET REQUEST -> LIST OF STUDENT
    //localhost://8080/students

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1,"otmane","aababou"));
        students.add(new Student(2,"Mohammed","aababou"));
        students.add(new Student(3,"malika","aababou"));
        students.add(new Student(4,"Amina","aababou"));

       // return new ResponseEntity<>(students, HttpStatus.OK);
        return ResponseEntity.ok(students);
    }

    //GET REQUEST PATH VARIABLE
    //http://localhost:8080/{id}

    @GetMapping("student/{id}")
    public Student getStudent(@PathVariable  int id){
        Student student = new Student(id,"otmane","aababou");
        return student;
    }


    // Spring BOOT REST API with Path Variable
    // {id} - URI template variable
    // http://localhost:8080/students/1/otmane/aababou

    @GetMapping("students/{id}/{firstName}/{lastName}")
    public Student getStudent(@PathVariable  int id,
                              @PathVariable String firstName,
                              @PathVariable String lastName)
    {
     Student student = new Student(id,firstName,lastName);
     return student;
    }

    // Spring boot REST API with Request Param
    //  http://localhost:8080/students/query?id=1&firstName=otmane&lastName=aababou

    @GetMapping("/query")
    public Student getStudentsQuery(@RequestParam int id ,
                                    @RequestParam  String firstName,
                                   @RequestParam String lastName) {
        return new Student(id,firstName,lastName);
    }
    //Spring boot REST API that handles HTTP POST REQUEST -> creating new resource
    // @POST REQUEST AND @REQUESTBODY
    //http://localhost:8080/students/create
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }


    //Spring boot REST API that handles HTTP PUT REQUEST -> updating existing resource
    // @PUT REQUEST AND @REQUESTBODY and @Path varaibles
    //http://localhost:8080/students/{id}/update
    @PutMapping("/{id}/update")
    public Student updateStudent(@RequestBody Student student , @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
       return student;
    }


    //Spring boot REST API that handles HTTP Delete REQUEST -> deleting existing resource
    // @Delete REQUEST AND   @Path variables
    //http://localhost:8080/students/{id}/delete
    @DeleteMapping("/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return "Student deleted successfully";
    }

}
