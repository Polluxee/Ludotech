package fr.eni.ludotech.dal;

import fr.eni.ludotech.bo.Adresse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AdresseRepositoryTest {

    @Autowired
    private AdresseRepository adresseRepository;

    @Test
    void creationAndDeletionOfEmptyAddress() {
        // client creation
        Adresse emptyAddress = new Adresse();
        Adresse savedAdresse = adresseRepository.save(emptyAddress);

        assertThat(savedAdresse).isEqualTo(emptyAddress);
        assertThat(savedAdresse).isNotNull();

        // client deletion
        adresseRepository.delete(savedAdresse);
        Optional<Adresse> addressOptional = adresseRepository.findById(savedAdresse.getNoAdresse());
        assertThat(addressOptional).isEmpty();
    }

    @Test
    void creationAndDeletionOfAddress() {
        // client creation
        Adresse address = new Adresse();
        address.setRue("13 rue de test");
        address.setVille("Nantes");
        address.setCodePostal("44300");
        Adresse savedAddress = adresseRepository.save(address);

        assertThat(savedAddress).isEqualTo(address);
        assertThat(savedAddress).isNotNull();
        assertThat(savedAddress.getVille()).isEqualTo("Nantes");
        assertThat(savedAddress.getCodePostal()).isEqualTo("44300");

        // client deletion
        adresseRepository.delete(savedAddress);
        Optional<Adresse> addressOptional = adresseRepository.findById(savedAddress.getNoAdresse());
        assertThat(addressOptional).isEmpty();
    }
}