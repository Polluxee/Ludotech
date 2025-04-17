package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue
    @Column(name = "client_id")
    private int clientId;

    @NonNull
    @Column(length = 50, nullable = false)
    private String nom;

    @NonNull
    @Column(length = 50, nullable = false)
    private String prenom;

    @NonNull
    @Column(length = 50, unique = true, nullable = false)
    private String email;

    @NonNull
    @Column(length = 50, nullable = false)
    private String noTelephone;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Adresse adresse;
}
