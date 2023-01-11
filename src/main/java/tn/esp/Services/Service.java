package tn.esp.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esp.DAO.Entities.Activite;
import tn.esp.DAO.Entities.Club;
import tn.esp.DAO.Entities.Etudiant;
import tn.esp.DAO.Repositories.RepoActivite;
import tn.esp.DAO.Repositories.RepoClub;
import tn.esp.DAO.Repositories.RepoEndroit;
import tn.esp.DAO.Repositories.RepoEtudiant;

import java.util.List;

@Slf4j
@org.springframework.stereotype.Service


public class Service implements IService {
    @Autowired
    RepoActivite repactivite;
    @Autowired
    RepoClub repclub;
    @Autowired
    RepoEndroit rependroit;
    @Autowired
    RepoEtudiant repetudiant;


    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> listE) {
        return (List<Etudiant>) repetudiant.saveAll(listE);
    }

    @Override
    public Club addClub(Club club) {
        return repclub.save(club);

    }

    @Override
    public void affecterActiviteAuClub(Activite a, long idClub) {
        //recuperation
        Club caaffect= repclub.findById(idClub).get(); //parent
        a=repactivite.save(a); //activite child
        caaffect.getActivites().add(a);//affectaton du child au parent
        repclub.save(caaffect); //persistance
    }

    @Override
    public String affecterEtudiantAuClub(long idEtudiant, long idClub, String role) {

        //preparer la var de retour
        String msg=" ";
        //recuperation des obj
        Etudiant etudaaffecter = repetudiant.findById(idEtudiant).get(); //parent
        Club clubaaffecter = repclub.findById(idClub).get(); //child
        return msg;

    }

    @Override
    public List<Etudiant> RecupererEtudiantsParClub(long clubId) {
        //méthode avec code
        Club c=repclub.findById(clubId).get();
        return c.getAdherants() ;

        //méthode avec keyword
        //return repclub.findByListClubsClubId(clubId);

        //méthode avec JPQL, on commence par créer la methode dans le repo
        //return er.recupererByClubId

    }
}
