package com.kaviddiss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import com.kaviddiss.model.Dato;
import com.kaviddiss.model.Stats;
import com.kaviddiss.model.StatsString;
import com.kaviddiss.service.DataService;

/**

 * Controller dell'applicazione che gestisce tutte le rotte della rest API

 */


@RestController
@RequestMapping("/GET")
public class DataController {

	    private DataService dataService;

	    public DataController(DataService dataService) {
			this.dataService = dataService;
	    }
	   
	    /**

	     * Rotta che mostra intero dataset nel formato JSON
	     
	     * @return Restituisce tutti i dati

	     */

	    @GetMapping("/data")
	    public Iterable<Dato> list() {
	    	
	        return dataService.list();
	    }
	    
	    /**

	     * Rotta per cancellare un elemento fornendo l'identificatore numerico del dato da cancellare
	     * @param id Identificatore numerico del dato da cancellare
         * @return Restituisce un messaggio: 
         *  "Deleted" - Significa che id inserito è corrette ed esiste nel dataset e il corrispondente dato viene eliminato;
         *  "Not Found"- Significa che id inserito non è corretto oppure non esiste un dato corrispondente all'id nel dataset.

	     */

	   @GetMapping("/data/delete/{id}")
	   public String delete(@PathVariable(value="id") Long id) {
		   return dataService.delete(id);
	   }
	   
	   /**
	    * Gestisce il problema quando il nome dell'attributo è inesistente quando si richiedono statistiche 
	    * @param field il nome dell'attributo
	    * @return comunicazione del campo inesistente
	    */
	   @ResponseBody
	   @GetMapping(value="/stats/{field}")
	   public String statsFieldError(@PathVariable(value="field")String field){
		   return "Il campo inserito: "+field+" è inesistente!";
	   }
	   
	/**

     * Rotte che mostra le statistiche sulle colonna numeriche
     * @param dstd deviazione standard calcolato sulla colonna
     * @return Restituisce le statistiche
     
	 */
	   @GetMapping(value="/stats/id")
	   public Stats statsID() {
		     double dstd=dataService.devSTD("id");
			   return dataService.getStatsID("id",dstd);}
		  
	   @GetMapping(value="/stats/ap_interno")
		  public Stats StatsapI() {
		      double dstd=dataService.devSTD("ap_interno");
			  return  dataService.getStatsapI("ap_interno",dstd);}
	   @GetMapping(value="/stats/ap_esterno")
	       public Stats StatsapE() {
		   double dstd=dataService.devSTD("ap_esterno");
		   return dataService.getStatsapE("ap_esterno",dstd);}
			   
		@GetMapping(value="/stats/lat")
		   public Stats StatLat() {
			double dstd =dataService.devSTD("lat");
			  return   dataService.getStatslat("lat",dstd);}
			   
		@GetMapping(value="/stats/long")	  
		  public Stats statLong() {
			double dstd=dataService.devSTD("long");
		     return dataService.getStatslon("long",dstd);}
		
		
		  /**
		   * Rotte che restituisce le statistiche sulle colonne stringhe
		   * @return Restituisce le statistiche
		   */
		@GetMapping(value="/stats/comune")  
		  public StatsString statComune() {
			   return  dataService.getStatsComune("comune");}
		 
		@GetMapping(value="/stats/access_point")  
		   public StatsString statAP() {
			    return dataService.getStatsAccessPoint("access_point");}
		
		
		/**
		 * Rotta che restituisce il metadata
		 * 
		 * @return elenco degli attributi e del tipo
		 * @throws JsonMappingException
		 */
		@GetMapping(value = "/metadata")
		JsonSchema getMetadata() throws JsonMappingException{

         ObjectMapper mapper = new ObjectMapper();
         JsonSchemaGenerator schemaGen = new JsonSchemaGenerator(mapper);
         JsonSchema schema = schemaGen.generateSchema(Dato.class);
		 return schema;		}
			   
		  
	  
}
	   

