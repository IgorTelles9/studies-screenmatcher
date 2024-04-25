package com.igor.screenmatch.main;

import com.igor.screenmatch.model.EpisodeData;
import com.igor.screenmatch.model.SeasonData;
import com.igor.screenmatch.model.SeriesData;
import com.igor.screenmatch.service.APIExtract;
import com.igor.screenmatch.service.DataParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private final String ADDRESS = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=328befac";

    private final Scanner scanner = new Scanner(System.in);
    private final APIExtract api = new APIExtract();
    private final DataParser parser = new DataParser();

    public void showMenu(){
        String searched = this.getSearch();
        SeriesData series = this.getSeries(searched);
        List<List<String>> seasons = this.getSeasons(searched, series);
        System.out.println(series);
        seasons.forEach(System.out::println);
    }

    private String getSearch(){
        System.out.println("Search for a serie...");
        String searched = this.scanner.nextLine();
        return searched.toLowerCase().replace(" ", "+");
    }

    private SeriesData getSeries (String searchedValue){
        String fullAddress = this.buildSeriesSearchAddress(searchedValue);
        String response = this.performSearch(fullAddress);
        return this.parser.getData(response, SeriesData.class);
    }

    private ArrayList<List<String>> getSeasons(String searched, SeriesData series){
        ArrayList<List<String>> seasons = new ArrayList<>();
        for (int i = 1; i <= series.seasons(); i++){
            String address = this.buildSeasonSearchAddress(searched, i);
            seasons.add(this.getEpisodesTitle(this.getSeason(address)));
        }
        return seasons;
    }

    private String buildSeriesSearchAddress(String searchedValue){
        return ADDRESS + searchedValue + API_KEY;
    }

    private String buildSeasonSearchAddress(String searchedValue, int number){
        return ADDRESS + searchedValue + "&season=" + number + API_KEY;
    }

    private String performSearch(String address){
        return this.api.getData(address);
    }

    private SeasonData getSeason(String address){
        String response = this.performSearch(address);
        return this.parser.getData(response, SeasonData.class);
    }

    private List<String> getEpisodesTitle(SeasonData season){
        return season.episodes().stream()
                .map(EpisodeData::title)
                .collect(Collectors.toList());
    }
}
