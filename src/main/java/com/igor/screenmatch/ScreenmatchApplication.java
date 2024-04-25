package com.igor.screenmatch;

import com.igor.screenmatch.main.Main;
import com.igor.screenmatch.model.EpisodeData;
import com.igor.screenmatch.model.MovieData;
import com.igor.screenmatch.model.SeasonData;
import com.igor.screenmatch.model.SeriesData;
import com.igor.screenmatch.service.APIExtract;
import com.igor.screenmatch.service.DataParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Main main = new Main();
		main.showMenu();
	}
}
