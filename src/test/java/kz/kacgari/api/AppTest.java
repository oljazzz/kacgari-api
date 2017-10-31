package kz.kacgari.api;

import kz.kacgari.api.model.*;
import kz.kacgari.api.repository.WordRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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
        Word word = new Word();
        word.setText("Абжылан");
        Example example1 = new Example();
        Author author1 = new Author();
        author1.setFirstName("Қыз жібек");
        example1.setText("Бір қыз кетіп барады Алтынды қамшы қолға алып Абжыландай толғанып,"
                + "Бұралып кетіп барады жын соққандай теңселіп");
        example1.setAuthor(author1);

        Example example2 = new Example();
        Author author2 = new Author();
        author2.setFirstName("Cәкен");
        author2.setLastName("Сейфуллин");
        example2.setAuthor(author2);
        example2.setText("Омбыны алдық деген хабар келген соң, төңкеріс дұшпандары апжыланша ысқырып шықты");

        List<Example> examples = new ArrayList<>();
        examples.add(example1);
        examples.add(example2);
        word.setExample(examples);

        word.setDescription("Кейбір зерттеушілер абжылан - \"су жылан\", аб парсынынң \"су\" дегені" +
                "деп түсіндіреді");
        Source source1 = new Source();
        Book book = new Book();
        Author author = new Author();
        author.setLastName("Жәркешева");
        book.setAuthor(author);
        book.setName("Біріккен сөздер мен сөз тіркестерінің орфографиялық сөздігі");
        book.setPublishYear("1960");
        source1.setBook(book);
        List<Source> sources = new ArrayList<>();
        sources.add(source1);
        word.setOldestSourceInHistory(sources);
        List<String> synonyms = new ArrayList<>();
        synonyms.add("59f62bd0e8af032af4114510");
        synonyms.add("59f62b2ce8af032af411450f");
        synonyms.add("59f62acee8af032af411450e");
        word.setSynonymsWordsObjectId(synonyms);
        repository.save(word);
        assertTrue(!word.getId().isEmpty());

    }

    @Test
    public void findAllWords() {
        List<Word> words = repository.findAll();
        assertNotNull(words);
        assertTrue(!words.isEmpty());
    }

    @Test
    public void findWordById() {
        Word word = repository.findOne("59ebc5ed552a8b05604b162a");
        assertNotNull(word);
    }

    @Test
    public void deleteWordWithId() {
        Word word = repository.findOne("59f8b918e8af033770fad215");
        repository.delete(word);
        assertNotNull(word);
    }

}
