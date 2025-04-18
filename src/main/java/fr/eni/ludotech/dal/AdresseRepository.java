package fr.eni.ludotech.dal;

import fr.eni.ludotech.bo.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Integer> {
}
