package fr.eni.ludotech.dal;

import fr.eni.ludotech.bo.Client;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findClientByEmail(@NonNull String email);
}
