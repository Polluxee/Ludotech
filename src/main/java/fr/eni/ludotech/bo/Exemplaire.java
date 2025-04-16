package fr.eni.ludotech.bo;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
//@Builder
@Entity
@Table(name = "exemplaire")
public class Exemplaire {

    @Id
    @GeneratedValue
    private int id;

    @NonNull
    @Column(length = 50, nullable = false)
    private String codeBarre;

    @NonNull
    @Column(length = 50, nullable = false)
    private String etat;

    @ManyToOne(cascade = CascadeType.ALL)
    private Jeu jeu;

    @ManyToMany(mappedBy = "exemplaires", cascade = CascadeType.ALL)
    private List<Location> locations;

}
