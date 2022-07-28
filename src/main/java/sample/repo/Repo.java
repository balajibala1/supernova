package sample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.model.Student;

public interface Repo extends JpaRepository<Student,Integer> {
}
