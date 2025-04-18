package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clientId;

    @Column(length = 50, nullable = false)
    private String nom;

    @Column(length = 50, nullable = false)
    private String prenom;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String noTelephone;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Adresse> adresses;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Jeu> jeux;
}
