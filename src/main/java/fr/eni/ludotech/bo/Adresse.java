package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "adresse")
public class Adresse {

    @Id
    @GeneratedValue
    private int noAdresse;

    @NonNull
    @Column(length = 50, nullable = false)
    private String rue;

    @NonNull
    @Column(length = 5, nullable = false)
    private String codePostal;

    @NonNull
    @Column(length = 50, nullable = false)
    private String ville;

    @OneToOne(mappedBy = "adresse")
    private Client client;

}
