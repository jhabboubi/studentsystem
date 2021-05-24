package org.perscholas.controllers;

import lombok.extern.java.Log;
import org.perscholas.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("create")
@Log
public class HomeController {

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

    @PostMapping("/newstudent")
    public String newStudent(@ModelAttribute("student") Student student, Model model){
       log.info("Student: " + student);
       model.addAttribute("student", student);
        return "student_confirmation";
    }


}
