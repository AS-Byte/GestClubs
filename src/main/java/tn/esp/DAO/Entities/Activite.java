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
public class Activite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idActivite;

    String description;

    @Temporal(TemporalType.DATE)
    Date dateActivite;


    @OneToOne (mappedBy = "activite")
    Endroit endroit;
}
