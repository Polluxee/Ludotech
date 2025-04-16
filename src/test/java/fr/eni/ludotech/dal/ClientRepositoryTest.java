package fr.eni.ludotech.dal;

import fr.eni.ludotech.bo.Adresse;
import fr.eni.ludotech.bo.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void creationAndDeletionOfEmptyClient() {
        // client creation
        Client emptyClient = new Client();
        Client savedClient = clientRepository.save(emptyClient);

        assertThat(savedClient).isEqualTo(emptyClient);
        assertThat(savedClient).isNotNull();

        // client deletion
        clientRepository.delete(savedClient);
        Optional<Client> clientOptional = clientRepository.findById(savedClient.getNoClient());
        assertThat(clientOptional).isEmpty();
    }

    @Test
    void creationAndDeletionOfClientWithoutAddress() {
        // client creation
        Client clientWithoutAddress = new Client();
        clientWithoutAddress.setNom("Omar");
        clientWithoutAddress.setPrenom("Babar");
        clientWithoutAddress.setEmail("omar@mail.com");
        clientWithoutAddress.setNoTelephone("+33683075149");
        Client savedClient = clientRepository.save(clientWithoutAddress);

        assertThat(savedClient).isEqualTo(clientWithoutAddress);
        assertThat(savedClient).isNotNull();
        assertThat(savedClient.getNom()).isEqualTo("Omar");
        assertThat(savedClient.getPrenom()).isEqualTo("Babar");

        // client deletion
        clientRepository.delete(savedClient);
        Optional<Client> clientOptional = clientRepository.findById(savedClient.getNoClient());
        assertThat(clientOptional).isEmpty();
    }

    @Test
    void creationAndDeletionOfClientWithAddress() {
        // address creation
        Adresse adresse = new Adresse();
        adresse.setVille("Nantes");
        adresse.setRue("Rue du test");
        adresse.setCodePostal("44000");
        // client creation
        Client clientWithAddress = new Client();
        clientWithAddress.setNom("Philipe");
        clientWithAddress.setPrenom("Belhadj");
        clientWithAddress.setEmail("phil@mail.com");
        clientWithAddress.setNoTelephone("+33683085140");
        clientWithAddress.setAdresse(adresse);
        Client savedClient = clientRepository.save(clientWithAddress);

        assertThat(savedClient).isEqualTo(clientWithAddress);
        assertThat(savedClient).isNotNull();
        assertThat(savedClient.getEmail()).isEqualTo("phil@mail.com");
        assertThat(savedClient.getNom()).isEqualTo("Philipe");
        assertThat(savedClient.getAdresse().getVille()).isEqualTo("Nantes");

        // client deletion
        clientRepository.delete(savedClient);
        Optional<Client> clientOptional = clientRepository.findById(savedClient.getNoClient());
        assertThat(clientOptional).isEmpty();
    }
}