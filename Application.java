package com.kaviddiss;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootApplication
public class Model3Application {

	public static void main(String[] args) {
		SpringApplication.run(Model3Application.class, args);
	}

	@Bean
	CommandLineRunner runner(DataService dataService){
	    return args -> {
			// read JSON and load json
	    	
	    	ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Dato>> typeReference = new TypeReference<List<Dato>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/datiumbria.json");
			try {
				List<Dato> dati = mapper.readValue(inputStream,typeReference);
				
				
				dataService.save(dati);
				System.out.println("Data Saved!");
			} catch (IOException e){
				System.out.println("Unable to save Data: " + e.getMessage());
			}
	    };
	}
}
