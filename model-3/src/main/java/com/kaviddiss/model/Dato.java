package com.kaviddiss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity

/**

 * La classe Dato modella un singolo elemento del dataset, rappresentante l'elenco degli hotspot UmbriaWiFi con la loro localizzazione
 */
public class Dato {
	@Id
    @GeneratedValue (strategy = GenerationType.AUTO)
	/**

     * Identificatore univoco del Hotspot

     */

    @JsonPropertyDescription("Identificatore Univoco del Hotspot")
	private Long id;
	
	/**

     * Comune del Hotspot

     */
	 @JsonPropertyDescription("Comune del Hotspot")
	private String comune;
	
	 /**

     * Access Point del Hotspot

     */

    @JsonPropertyDescription("Access Point del Hotspot")
	private String access_point;
    
    /**

     * Access Point da Interno

     */

    @JsonPropertyDescription("Access Point da Interno")
	private int ap_interno;
    
    /**

     * Access Point da Esterno

     */

    @JsonPropertyDescription("Access Point da Esterno")
	private int ap_esterno;
    
    /**

     * Latitudine del Hotspot

     */

    @JsonPropertyDescription("Latitudine del Hotspot")
	private Double lat;
    
    /**

     * Longitudine del Hotspot

     */

    @JsonPropertyDescription("Longitudine del Hotspot")
	private Double lon;
    
    
    
    
    /** Funzioni dell'oggetto
     * 
     * Getters and Setters dell oggetto
     * @param  Modifica una proprietà dell'oggetto considerato
     * @return Restituisce una proprietà dell'oggetto considerato
     */
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	public String getAccess_point() {
		return access_point;
	}
	public void setAccess_point(String access_point) {
		this.access_point = access_point;
	}
	public int getAp_interno() {
		return ap_interno;
	}
	public void setAp_interno(int ap_interno) {
		this.ap_interno = ap_interno;
	}
	public int getAp_esterno() {
		return ap_esterno;
	}
	public void setAp_esterno(int ap_esterno) {
		this.ap_esterno = ap_esterno;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	 
    
}
