package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String rue;

    @Column(nullable = false)
    private String ville;

    @Column(nullable = false)
    private String codePostal;
}