package kz.kacgari.api.repository;


import kz.kacgari.api.model.Word;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface WordRepository extends MongoRepository<Word, String> {

}
