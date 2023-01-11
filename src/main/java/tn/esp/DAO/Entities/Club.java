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

public class Club implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idClub;

    String nomClub;

    @Temporal(TemporalType.DATE)
    Date dateCreation;

    long nbMaxAdherant;


    @OneToMany (cascade = CascadeType.ALL, mappedBy = "clubR")
    private List<Etudiant> responsables=new ArrayList<Etudiant>();


    @ManyToMany(mappedBy = "clubsA",cascade = CascadeType.ALL)
    List<Etudiant> adherants=new ArrayList<Etudiant>();


    @OneToMany (cascade = CascadeType.ALL)
    List<Activite> activites = new ArrayList<Activite>();


}
