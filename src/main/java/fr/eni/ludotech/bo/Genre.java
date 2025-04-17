package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
//@Builder
@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no_genre;

    @NonNull
    @Column(length = 50, nullable = false)
    private String libelle;

    @ManyToMany(cascade = CascadeType.ALL)
    private Jeu jeu;


}
