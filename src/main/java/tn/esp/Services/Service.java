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
        Club caaffect = repclub.findById(idClub).get(); //parent
        a = repactivite.save(a); //activite child
        caaffect.getActivites().add(a);//affectaton du child au parent
        repclub.save(caaffect); //persistance
    }

    @Override
    public String affecterEtudiantAuClub(long idEtudiant, long idClub, String role) {
        //preparer la var de retour
        String msg = " ";
        //recuperation des obj
        Etudiant etud = repetudiant.findById(idEtudiant).get(); //parent
        Club club = repclub.findById(idClub).get(); //child
        if (role.equals("RESPONSABLE")) {
            if (club.getResponsables().size() < 2) {
                etud.setClubR(club); //on affecte le child au parent
                repetudiant.save(etud);
                msg = "L'affectation du responsable est effectuée avec succès";
            } else {
                msg = "Il y a déjà deux responsables !";
            }
        } else if (role.equals("MEMBRE")) {
            if (club.getAdherants().size() < club.getNbMaxAdherant()) {
                etud.getClubsA().add(club);
                repetudiant.save(etud);
                msg = "L’adhésion de l’étudiant est effectuée avec succès";
            } else {
                msg = "Le club est complet !";
            }
            System.out.println(msg);
        }
        return msg;

    }

    @Override
    public List<Etudiant> RecupererEtudiantsParClub(long clubId) {
        //méthode avec code
        Club c = repclub.findById(clubId).get();
        return c.getAdherants();

        //méthode avec keyword
        //return repclub.findByListClubsClubId(clubId);

        //méthode avec JPQL, on commence par créer la methode dans le repo
        //return er.recupererByClubId

    }
}
