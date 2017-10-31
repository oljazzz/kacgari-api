package kz.kacgari.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Source {

    private Book book;
    private String description;
}
