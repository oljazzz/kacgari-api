package kz.kacgari.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    public Word(String id, String text) {
        this.id = id;
        this.text = text;
    }


}
