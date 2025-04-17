package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "facture")
public class Facture {

    @Id
    @GeneratedValue
    @Column(name = "facture_id")
    private int facureId;

    private String date_paiement;
}
