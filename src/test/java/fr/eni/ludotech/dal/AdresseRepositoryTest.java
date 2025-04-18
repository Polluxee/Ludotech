package fr.eni.ludotech.dal;

import fr.eni.ludotech.bo.Adresse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AdresseRepositoryTest {

    @Autowired
    private AdresseRepository adresseRepository;

    private Adresse completeAddress;

    @BeforeEach
    void setUp() {
        // Adresse complète
        completeAddress = new Adresse();
        completeAddress.setRue("13 rue de test");
        completeAddress.setVille("Nantes");
        completeAddress.setCodePostal("44300");
    }


    @Test
    @DisplayName("Créer une adresse vide")
    void testCreationEmptyAddress() {
        Adresse savedAdresse = adresseRepository.save(completeAddress);

        assertThat(savedAdresse).isNotNull();
        assertThat(savedAdresse.getCodePostal()).isEqualTo("44300");
    }

    @Test
    @DisplayName("Créer une adresse complète")
    void testCreationCompleteAddress() {
        Adresse savedAddress = adresseRepository.save(completeAddress);

        assertThat(savedAddress).isNotNull();
        assertThat(savedAddress.getId()).isNotNull();
        assertThat(savedAddress.getVille()).isEqualTo("Nantes");
        assertThat(savedAddress.getCodePostal()).isEqualTo("44300");
    }
}
