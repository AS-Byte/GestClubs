package tn.esp.DAO.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esp.DAO.Entities.Activite;

@Repository
public interface RepoActivite extends CrudRepository<Activite, Long> {
}
