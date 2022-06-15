package com.example.basics;

import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilmDto {
    private String title;
    private String author;
    private String description;
    private String url;

}
