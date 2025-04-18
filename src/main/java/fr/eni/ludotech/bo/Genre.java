package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Genre {

    @Id
    private int genre_id;

    @Column(length = 50, nullable = false)
    private String libelle;

    @ManyToOne(cascade = CascadeType.ALL)
    private Jeu jeu;

}
