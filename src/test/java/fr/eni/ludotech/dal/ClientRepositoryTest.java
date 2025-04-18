package fr.eni.ludotech.dal;

import fr.eni.ludotech.bo.Adresse;
import fr.eni.ludotech.bo.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testInsertClient() {

        Adresse adresse = new Adresse();
        adresse.setRue("88 Rue Blanc");
        adresse.setVille("Paris");
        adresse.setCodePostal("75000");

        List<Adresse> adresses = new ArrayList<>();

        adresses.add(adresse);

        Client client = new Client();
        client.setNom("Z");
        client.setPrenom("Le");
        client.setNoTelephone("1234567890");
        client.setEmail("ma.france@gmail.com");
        client.setAdresses(adresses);

        Client savedClient = clientRepository.save(client);

        assertThat(savedClient).isNotNull();
        assertThat(savedClient.getNom()).isEqualTo("Z");
        assertThat(savedClient.getPrenom()).isEqualTo("Le");
        assertThat(savedClient.getEmail()).isEqualTo("ma.france@gmail.com");
        assertThat(savedClient.getAdresses().get(0).getRue()).isEqualTo("88 Rue Blanc");
        assertThat(savedClient.getAdresses().get(0).getVille()).isEqualTo("Paris");
        assertThat(savedClient.getAdresses().get(0).getCodePostal()).isEqualTo("75000");

    }
}