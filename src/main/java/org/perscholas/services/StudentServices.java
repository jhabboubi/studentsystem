package org.perscholas.services;

import org.perscholas.dao.IStudentRepo;
import org.perscholas.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServices {

    IStudentRepo sRepo;

    @Autowired
    public StudentServices(IStudentRepo sRepo) {
        this.sRepo = sRepo;
    }

    public List<Student> getAllStudents(){

        return sRepo.findAll();
    }

    public Student getStudentbyId(Long id){
            return sRepo.getById(id);
    }
    public Student saveStudent(Student s){

        return sRepo.save(s);

    }

}
