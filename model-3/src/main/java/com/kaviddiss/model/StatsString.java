package com.kaviddiss.model;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * 
 *
 */
@Data
@AllArgsConstructor
public class StatsString {
	
	/**
	 * Nome della colonna che contiene i valori di tipo stringa
	 */
	private String field;
	
	/**
	 * Conteggio di elementi unici
	 */
	private HashMap<String,Integer> occorrenze;
	
	 /**

     * Costruttore riferito alle statistiche sull'intero dataset in base al campo stringa

     * 

     */
	
	public StatsString(String f, HashMap<String,Integer> h) {
		this.field=f;
		this.occorrenze=h;
	}
	
	/**
	 * Metodo per ottenere il nome della colonna nella statistica considerata
	 * @return field Nome della colonna
	 */
	public String getField() {
		return field;
	}
	
	/**
	 * Metodo per modificare il nome della colonna nella statistica considerata
	 * @param field Nome della colonna
	 */
	public void setField(String field) {
		this.field = field;
	}
	
	/**
	 * Metedo per ottenere il conteggio di elementi unici nella statistica considerata
	 * @return occorrenze Il conteggio di elementi unici
	 */
	public HashMap<String, Integer> getOccorrenze() {
		return occorrenze;
	}
	
	/**
	 * Metodo per modificare il conteggio di elementi unici nella statistica considerata
	 * @param occorrenze Il conteggio di elementi unici
	 */
	public void setOccorrenze(HashMap<String, Integer> occorrenze) {
		this.occorrenze = occorrenze;
	}
	
	

}
