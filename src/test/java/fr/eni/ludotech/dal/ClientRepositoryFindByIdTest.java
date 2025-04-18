package fr.eni.ludotech.dal;

import fr.eni.ludotech.bo.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class ClientRepositoryFindByIdTest {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    @DisplayName("Trouver un client par id")
    void findByIdClient() {
        // Arrange
        Client client = Client.builder()
                .nom("Dalton")
                .prenom("Averell")
                .email("dalton" + System.currentTimeMillis() + "@mail.com")
                .noTelephone("+33683075000")
                .build();

        testEntityManager.persist(client);
        testEntityManager.flush();

        // Act
        Optional<Client> clientOpt = clientRepository.findById(client.getClientId());

        // Assert
        assertTrue(clientOpt.isPresent());
        Client clientDB = clientOpt.get();
        assertEquals("Dalton", clientDB.getNom());
        assertEquals("Averell", clientDB.getPrenom());
        assertEquals(client.getEmail(), clientDB.getEmail());
    }
}
