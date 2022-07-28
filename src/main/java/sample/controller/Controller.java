package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sample.model.Student;
import sample.model.Team;
import sample.repo.Repo;
import sample.service.StudentService;

import java.util.List;

@RestController
public class Controller {
   @Autowired
   private StudentService studentService;

    @PostMapping("/save")
    public String save(@RequestBody Student student) {
       studentService.save(student);
    return "Saved";

    }
    @GetMapping("/view")
    public List<Team> view(){
       return studentService.view();
    }





}


