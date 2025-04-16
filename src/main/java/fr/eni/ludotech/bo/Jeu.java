package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
//@Builder
@Entity
@Table(name = "jeu")
public class Jeu {

    @Id
    @GeneratedValue
    private int id;

    @NonNull
    @Column(length = 50, nullable = false)
    private String titre;

    @Column(unique = true, nullable = false)
    @NonNull
    private String reference;

    @NonNull
    @Column(length = 50, nullable = false)
    private int ageMin;

    @Basic(optional = true)
    @Column(length = 50, nullable = false)
    private String description;

    @NonNull
    @Column(length = 50, nullable = false)
    private LocalDateTime duree;

    @NonNull
    @Column(length = 50, nullable = false)
    private int tarifJournalier;

    @OneToMany(mappedBy = "jeu", cascade = CascadeType.ALL)
    @JoinColumn(name = "genre")
    private List<Genre> genres;

    @OneToMany(mappedBy = "jeu", cascade = CascadeType.ALL)
    @JoinColumn(name = "exemplaire")
    private List<Exemplaire> exemplaires;

}
