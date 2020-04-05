package com.kaviddiss.model;

import lombok.AllArgsConstructor;
import lombok.Data;



/**
 * La classe Stats
 * 
 *
 */
@Data
@AllArgsConstructor
public class Stats {
	/**
	 * Nome della colonna
	 */
	private String field;
	
	 /**

     * Media aritmetica

     */
	private Double avg;
	
	/**

     * Valore numerico minimo

     */
	private Double min;
	
	 /**

     * Valore numerico massimo

     */
	private Double max;
	
	/**
	 * Valore numerico somma di tutti gli elementi
	 */
	private Double sum;
	
	/**

     * Deviazione standard

     */
	private Double devSTD;
	
	/**

     * Conteggio delle istanze

     */
	private int count;
   
	 /**

     * Costruttore riferito alle statistiche sull'intero dataset in base al campo numerico

     * 

     */
	public Stats(String n, Double a, Double min, Double max, Double s,Double devstd,int c)
	{
		this.field=n;
		this.avg=a;
		this.min=min;
		this.max=max;
		this.sum=s;
		this.devSTD=devstd;
		this.count=c;
	}
	
	/**

     * Metodo per ottenere la deviazione standard nella statistica considerata

     * @return Deviazione standard

     */
	public Double getDevSTD() {
		return devSTD;
	}

	/**

     * Metodo per modificare la deviazione standard nella statistica considerata

     * @param devSTD Deviazione standard

     */
	public void setDevSTD(Double devSTD) {
		this.devSTD = devSTD;
	}
    
	/**
	 * Metodo per ottenere la somma degli elementi nella statistica considerata
	 * @return sum Somma
	 */
	public Double getSum() {
		return sum;
	}

	/**
	 * Metodo per modificare la somma degli elementi nella statistica considerata
	 * @param sum Somma
	 */
	public void setSum(Double sum) {
		this.sum = sum;
	}

	/**

     * Metodo per ottenere la media nella statistica considerata

     * @return Media

     */
	public Double getAvg() {
		return avg;
	}
	
	 /**

     * Metodo per modificare la media nella statistica considerata

     * @param avg Media

     */
	public void setAvg(Double avg) {
		this.avg = avg;
	}
	
	/**

     * Metodo per ottenere il massimo nella statistica considerata

     * @return Massimo

     */
	public Double getMax() {
		return max;
	}
	
	/**

     * Metodo per modificare il massimo nella statistica considerata

     * @param max Massimo

     */
	public void setMax(Double max) {
		this.max = max;
	}
	
	/**

     * Metodo per ottenere il numero di istanze nella statistica considerata

     * @return Conto istanze

     */
	public int getCount() {
		return count;
	}
	
	/**

     * Metodo per modificare il numero di istanze nella statistica considerata

     * @param count Conto istanze

     */
	public void setCount(int count) {
		this.count = count;
	}
	
	/**
	 * Metodo per modificare il nome della colonna nella statistica considerata
	 * @param s Nome della colonna
	 */
	public void setField(String s)
	{
		this.field=s;
	}
	
	/**
	 * Metodo per ottenere il nome della colonna nella statistica considerata
	 * @return Nome della colonna
	 */
	public String getField() {
		return field;
	}
	
	 /**

     * Metodo per ottenere il minimo nella statistica considerata

     * @return Minimo

     */
public Double getMin()
{
	return min;
}

/**

 * Metodo per modificare il minimo nella statistica considerata

 * @param min Minimo

 */
public void setMin(Double min) {
	this.min=min;
}
}
