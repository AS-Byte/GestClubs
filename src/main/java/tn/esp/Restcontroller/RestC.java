package tn.esp.Restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esp.DAO.Entities.Activite;
import tn.esp.DAO.Entities.Club;
import tn.esp.DAO.Entities.Etudiant;
import tn.esp.Services.IService;
import java.util.List;

@RestController
public class RestC {

    @Autowired
    IService iservice;

    @PostMapping("addEtudiants")
    public List<Etudiant> addEtudiants( @RequestBody List<Etudiant> listE)
    {
        return iservice.addEtudiants(listE);
    }

    @PostMapping("addClub")
    public Club addClub(@RequestBody Club club) {return iservice.addClub(club); }

    @PostMapping("affecterActiviteAuClub")
    public void affecterActiviteAuClub( @RequestBody Activite a,
                                        @RequestParam long idClub){
        iservice.affecterActiviteAuClub(a, idClub);
    }

    @GetMapping("RecupererEtudiantsParClub")
    public List<Etudiant> RecupererEtudiantsParClub(@RequestParam long clubId){
        return iservice.RecupererEtudiantsParClub(clubId);
    }

    @PostMapping("affecterEtudiantAuClub")
    public String affecterEtudiantAuClub(@RequestParam long idEtudiant,
                                         @RequestParam long idClub,
                                         @RequestParam String role){
        return iservice.affecterEtudiantAuClub(idEtudiant, idClub, role);
    }

}
