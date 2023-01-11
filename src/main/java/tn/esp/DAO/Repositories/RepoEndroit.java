package tn.esp.DAO.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esp.DAO.Entities.Activite;
import tn.esp.DAO.Entities.Endroit;

@Repository
public interface RepoEndroit extends CrudRepository<Endroit, Long> {
}
