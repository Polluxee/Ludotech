package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "genre")
public class Genre {

    @Id
    private int genre_id;

    @NonNull
    @Column(length = 50, nullable = false)
    private String libelle;

    @ManyToOne(cascade = CascadeType.ALL)
    private Jeu jeu;


}
