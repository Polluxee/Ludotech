package fr.eni.ludotech.bo;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
//@Builder
@Entity
@Table(name = "adresse")
public class Adresse {

    @Id
    @GeneratedValue
    private int id;

    @NonNull
    @Column(length = 50, nullable = false)
    private String rue;

    @NonNull
    @Column(length = 50, nullable = false)
    private String code_postal;

    @NonNull
    @Column(length = 50, nullable = false)
    private String ville;

    @OneToMany(mappedBy = "adresse")
    @JoinColumn(name = "adresse")
    private List<Client> clients;

}
