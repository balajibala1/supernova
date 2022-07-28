package sample.repo;

import org.springframework.data.repository.CrudRepository;
import sample.model.Team;

public interface TeamRepo extends CrudRepository<Team,Integer> {
}
