package tn.esp.DAO.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esp.DAO.Entities.Activite;
import tn.esp.DAO.Entities.Club;

@Repository
public interface RepoClub extends CrudRepository<Club, Long> {
}
