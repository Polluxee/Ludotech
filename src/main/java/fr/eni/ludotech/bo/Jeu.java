package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class Jeu {
    @Id
    @GeneratedValue
    @Column(name = "jeu_id")
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

    @OneToMany(mappedBy = "jeu", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Exemplaire> exemplaires;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "jeu_genre",
            joinColumns = @JoinColumn(name = "jeu_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;
}

