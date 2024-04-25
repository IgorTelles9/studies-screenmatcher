package com.igor.screenmatch.model;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episode {
    private Integer season;
    private String title;
    private Integer number;
    private Double score;
    private LocalDate releaseDate;

    public Episode(Integer season, EpisodeData ep){
        this.season = season;
        this.title = ep.title();
        this.number = ep.number();
        try{
            this.score = Double.valueOf(ep.score());
        } catch (NumberFormatException e){
            this.score = 0.0;
        }
        try{
            this.releaseDate = LocalDate.parse(ep.releaseDate());
        } catch (DateTimeParseException e){
            this.releaseDate = null;
        }
    }

    @Override
    public String toString() {
        return "Episode{" +
                "season=" + season +
                ", title='" + title + '\'' +
                ", number=" + number +
                ", score=" + score +
                ", releaseDate=" + releaseDate +
                '}';
    }

    public Double getScore() {
        return score;
    }
}
