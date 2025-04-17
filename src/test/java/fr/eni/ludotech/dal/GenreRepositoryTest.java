package fr.eni.ludotech.dal;

import fr.eni.ludotech.bo.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    void testAjoutGenre() {
        // Given
        Genre genre = new Genre("Aventure");

        // When
        Genre saved = genreRepository.save(genre);

        // Then
        assertThat(saved.getNo_genre()).isNotZero();
        assertThat(saved.getLibelle()).isEqualTo("Aventure");
    }
}