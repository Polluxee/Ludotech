package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "adresse")
public class Adresse {

    @Id
    @GeneratedValue
    @Column(name = "adresse_id")
    private int adresse_id;

    @NonNull
    @Column(length = 50, nullable = false)
    private String rue;

    @NonNull
    @Column(length = 5, nullable = false)
    private String codePostal;

    @NonNull
    @Column(length = 50, nullable = false)
    private String ville;
}
