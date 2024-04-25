package com.igor.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieData(
       @JsonAlias("Title") String title,
       @JsonAlias("Director") String director,
       @JsonAlias("imdbRating") String score
) { }
