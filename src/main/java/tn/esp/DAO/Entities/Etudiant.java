package tn.esp.DAO.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idEtudiant;

    String nomEtudiant;
    String prenomEtudiant;

    @Temporal(TemporalType.DATE)
    Date dateNaissance;

    @Enumerated(EnumType.STRING) //comment l'écrire dans la base
    Sexe sexe;


    @ManyToOne
    Club clubR;


    @ManyToMany(cascade = CascadeType.ALL)
    private List<Club> clubsA=new ArrayList<Club>();

}
