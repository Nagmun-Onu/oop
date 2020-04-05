package com.kaviddiss;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kaviddiss.service.DataService;
import com.kaviddiss.model.*;



/**

 * Classe da cui parte l'esecuzione del programma, avviando il servizio

 */
@SpringBootApplication
public class Model3Application {
	
	/**

	 * Funzione che inizializza l'applicazione e la fa partire. Prima di avviare l'applicazione Spring Boot verrà scaricato

	 * il file JSON contenente il dataset si trova nel path: /src/main/resource 
	 * @param args Eventuali argomenti passati tramite cli

	 */

	public static void main(String[] args) {
		SpringApplication.run(Model3Application.class, args);
	}

	@Bean
	CommandLineRunner runner(DataService dataService){
	    return args -> {
			/** read JSON and load json
			 * Il dataset viene caricato nel H2 DB 
			 */
	    	
	    	ObjectMapper mapper = new ObjectMapper();
	    	mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);
	    	mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_VALUES, true);
	    	mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, true);
	        //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
	    	
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
