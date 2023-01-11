package tn.esp.DAO.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esp.DAO.Entities.Activite;
import tn.esp.DAO.Entities.Etudiant;
import java.util.List;

@Repository
public interface RepoEtudiant extends CrudRepository<Etudiant, Long> {

}
