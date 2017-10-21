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
    public void createWord(@RequestBody Word word){
        repository.save(word);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Word> findAllWords(){
        return repository.findAll();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}")
    public Word findWordById(@PathVariable String id){
        return repository.findOne(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}"
    )
    public void deleteWordWithId(@PathVariable String id){
        repository.delete(id);
    }

}
