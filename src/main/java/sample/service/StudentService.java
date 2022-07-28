package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.model.Student;
import sample.model.Team;
import sample.repo.Repo;
import sample.repo.TeamRepo;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private Repo repo;
    @Autowired
    private TeamRepo teamRepo;
    public void save(Student student) {

        int s=0;
        if(student.getEr_diagram().equals("Completed"))
            s=s+100;
        if(student.getEr_diagram().equals("Pending"))
            s=s+50;
        if(student.getUserStrory1().equals("Completed"))
            s=s+100;
        if(student.getUserStrory1().equals("Pending"))
            s=s+50;
        if(student.getUserStrory2().equals("Completed"))
            s=s+100;
        if(student.getUserStrory2().equals("Pending"))
            s=s+50;
        if(student.getUserStrory3().equals("Completed"))
            s=s+100;
        if(student.getUserStrory3().equals("Pending"))
            s=s+50;

        student.setScore(s);
        String teamid= student.getTeam_id();
        Team team=teamRepo.findById(Integer.valueOf(teamid)).get();
        team.setScore(team.getScore()+s);
        repo.save(student);


    }

    public List<Team> view() {
        return (List<Team>) teamRepo.findAll();

    }
}
