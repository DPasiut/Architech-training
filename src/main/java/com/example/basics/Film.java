package com.example.basics;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "films")
class Film {

    @Transient
    public static final String SEQUENCE_NAME = "films_sequence";

    @Id
    String id;
    String title;
    String author;
    String description;
    String category;
    String url;
    FilmDto dto(){
        return FilmDto.builder()
                .author(author)
                .description(description)
                .title(title)
                .url(url)
                .category(category)
                .build();
    }
}
