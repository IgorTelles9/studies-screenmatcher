package com.igor.screenmatch;

import com.igor.screenmatch.service.APIExtract;
import com.igor.screenmatch.service.DataParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var api = new APIExtract();
		String res = api.getData("https://www.omdbapi.com/?i=tt3896198&apikey=328befac");
		System.out.println(res);
		DataParser parser = new DataParser();
		MovieData movie = parser.getData(res, MovieData.class);
		System.out.println(movie);
	}


}
