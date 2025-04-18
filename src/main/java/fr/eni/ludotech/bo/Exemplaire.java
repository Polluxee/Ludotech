package fr.eni.ludotech.bo;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Exemplaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long exemplaireId;

    @Column(nullable = false, length = 13)
    private String codebarre;

    @Column(nullable = false)
    private Boolean louable;

    @ManyToOne(fetch = FetchType.LAZY)
    private Jeu jeu;
}