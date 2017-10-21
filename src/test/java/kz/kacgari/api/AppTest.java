package kz.kacgari.api;

import kz.kacgari.api.model.Word;
import kz.kacgari.api.repository.WordRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    private WordRepository repository;

    @Autowired
    public void setRepository(WordRepository repository) {
        this.repository = repository;
    }

    @Test
    public void createWord() {
        Word word = new Word("3", "Бала");
    }

    @Test
    public void findAllWords() {
        List<Word> words = repository.findAll();
        assertNotNull(words);
        assertTrue(!words.isEmpty());
    }

    @Test
    public void findWordById() {
        Word word = repository.findOne("3");
        assertNotNull(word);
    }

    @Test
    public void deleteWordWithId() {
        Word word = repository.findOne("59eb7cb85f024d13e4d0daae");
        repository.delete(word);
        assertNotNull(word);
    }

}
