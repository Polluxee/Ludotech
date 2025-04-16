package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
//@Builder
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue
    private int id;

    @NonNull
    @Column(length = 50, nullable = false)
    private String nom;

    @NonNull
    @Column(length = 50, nullable = false)
    private String prenom;

    @NonNull
    @Column(length = 50, nullable = false)
    private String email;

    @NonNull
    @Column(length = 50, nullable = false)
    private String telephone;

    @ManyToOne(cascade = CascadeType.ALL)
    private Adresse adresse;
}
