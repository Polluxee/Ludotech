package fr.eni.ludotech.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
//@Builder
@Entity
@Table(name = "exemplaire")
public class Facture {

    @Id
    @GeneratedValue
    private int id;
    private String date;
    private String montant;
}
