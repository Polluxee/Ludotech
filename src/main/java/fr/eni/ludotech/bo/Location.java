package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class Location {
    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private Long locationId;

    @Column(nullable = false)
    private LocalDate dateDebut;

    private LocalDate dateRetour;

    private Double tarifJour;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exemplaire_id", referencedColumnName = "exemplaire_id")
    private Exemplaire exemplaire;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "facture_id", referencedColumnName = "facture_id")
    private Facture facture;
}