package kz.kacgari.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {

    private Author author;
    private String name;
    private String publishYear;

}
