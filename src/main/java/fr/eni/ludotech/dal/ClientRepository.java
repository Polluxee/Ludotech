package fr.eni.ludotech.dal;

import fr.eni.ludotech.bo.Client;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findClientByEmail(@NonNull String email);
}
