package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Jeu {
    @Id
    @GeneratedValue
    private Long jeuId;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String reference;

    @Column(nullable = false)
    private Integer ageMin;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer duree;

    @Column(nullable = false)
    private Double tarifJour;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Genre> genres;
}

