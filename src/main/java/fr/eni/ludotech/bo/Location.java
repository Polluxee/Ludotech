package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
//@Builder
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    @NonNull
    @Column(length = 50, nullable = false)
    private String dateDebut;

    @NonNull
    @Column(length = 50, nullable = false)
    private String dateRetourPrevue;

    @NonNull
    @Column(length = 50, nullable = false)
    private String dateRetourReel;

    @ManyToMany(mappedBy = "locations", cascade = CascadeType.ALL)
    private List<Exemplaire> exemplaires;
}
