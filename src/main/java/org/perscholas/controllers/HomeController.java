package org.perscholas.controllers;

import lombok.extern.java.Log;
import org.perscholas.dao.IStudentRepo;
import org.perscholas.models.Student;
import org.perscholas.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("create")
@Log
@SessionAttributes({"student"})
public class HomeController {

    StudentServices studentServices;

    @Autowired
    public HomeController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @Autowired


    @GetMapping("/form")
    public String form(){

        return "registerstudent";

    }

/*
    @PostMapping("/newstudent")
    public String newStudent(@RequestParam("username") String username,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password,
                             Model model
                             ){
        Student student = new Student();
        student.setSUsername(username);
        student.setSEmail(email);
        student.setSPassword(password);
        log.info("Student: " + student);
        return "student_confirmation";
    }

 */

    @ModelAttribute("student")
    public Student initStudent(){
        return new Student();
    }


    @PostMapping("/newstudent")
    public String newStudent(@ModelAttribute("student") @Valid Student student, BindingResult result,Model model ){
        System.out.println(result.hasErrors());
        if(result.hasErrors()) {
            log.warning("Error Count: "+String.valueOf(result.getErrorCount()));
            return "registerstudent";

        }else{
            log.info("Student: " + student);
            Student databaseStudent = studentServices.saveStudent(student);
            model.addAttribute("student", student);
            return "student_confirmation";
        }
    }

    @GetMapping("getsession")
    public String getSession(){

        return "getsession";
    }

    @GetMapping("showstudent/{id}")
    public String showStudent(@PathVariable("id") Long studentId, Model model){
        Student s = studentServices.getStudentbyId(studentId);
        model.addAttribute("student", s);
        return "showstudent";
    }


}
