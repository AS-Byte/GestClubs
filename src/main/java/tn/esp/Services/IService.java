package tn.esp.Services;
import tn.esp.DAO.Entities.Activite;
import tn.esp.DAO.Entities.Club;
import tn.esp.DAO.Entities.Etudiant;

import java.util.List;
public interface IService {
    List<Etudiant> addEtudiants(List<Etudiant> listE);
    Club addClub(Club club);
    void affecterActiviteAuClub(Activite a, long idClub);
    String affecterEtudiantAuClub(long idEtudiant, long idClub, String role);
    List<Etudiant> RecupererEtudiantsParClub(long clubId);



}
