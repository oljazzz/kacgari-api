package kz.kacgari.api.controller;


import kz.kacgari.api.model.Word;
import kz.kacgari.api.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/words")
public class WordController {

    private WordRepository repository;

    @Autowired
    public void setRepository(WordRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createWord(@RequestBody Word word) {
        Word savedWord = repository.save(word);
        return savedWord.getId();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Word> findAllWords() {
        return repository.findAll();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}")
    public Word findWordById(@PathVariable String id) {
        return repository.findOne(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}"
    )
    public String deleteWordWithId(@PathVariable String id) {
        Word word = repository.findOne(id);
        repository.delete(word);
        return word.getId();
    }

}
