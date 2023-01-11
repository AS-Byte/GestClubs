package tn.esp.DAO.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Endroit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEndroit;

    String nomEndroit;

    String adresseEndroit;

    @Temporal(TemporalType.DATE)
    Date dateCreation;


    @OneToOne
    Activite activite;
}
