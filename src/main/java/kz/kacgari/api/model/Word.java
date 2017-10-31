package kz.kacgari.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "word")
public class Word {
    @Id
    @Field("id")
    private String id;

    @NotNull
    @Field("text")
    @Size(min = 1)
    private String text;

    @NotNull
    @Field("description")
    @Size(min = 1)
    private String description;


    @NotNull
    @Field("example")
    private List<Example> example;

    @NotNull
    @Field("oldest_source_in_history")
    private List<Source> oldestSourceInHistory;


    @NotNull
    @Field("synonyms")
    private List<Word> synonyms;


    public Word(String id, String text) {
        this.id = id;
        this.text = text;
    }


}
