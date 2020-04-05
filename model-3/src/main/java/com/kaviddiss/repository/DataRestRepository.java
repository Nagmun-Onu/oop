package com.kaviddiss.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kaviddiss.model.Dato;
/**
 * Archivio dell'applicazione
 * I dati vengono salvati nel H2 DB
 * I dati vengono manipulati tramite JPA @Query, JPARepository e CrudRepository
 * 
 *
 */

@Repository
public interface DataRestRepository extends JpaRepository<Dato,Long>,CrudRepository<Dato, Long>{
	
	/** Restituisce statistiche sulla colonna id
	 * 
	 * @Query
	 */
	@Query("select min(id) from Dato")
	   double getminID();
	@Query("select max(id) from Dato")
	   double getmaxID();
	@Query("select avg(id) from Dato")
	   double getavgID();
	@Query("select count(id) from Dato")
	   int getcountID();
	@Query("select sum(id) from Dato")
	   double getsumID();
	@Query("select id from Dato")
	    ArrayList<Double> getAllID();
	
	
	/** Restituisce statistiche sulla colonna ap_interno 
	 * 
	 */
	@Query("select min(ap_interno) from Dato")
	   double getminapI();
	@Query("select max(ap_interno) from Dato")
	   double getmaxapI();
	@Query("select avg(ap_interno) from Dato")
	   double getavgapI();
	@Query("select count(ap_interno) from Dato")
	   int getcountapI();
	@Query("select sum(ap_interno) from Dato")
	   double getsumapI();
	@Query("select ap_interno from Dato")
	ArrayList<Double> getAllAp_interno();
	
	

	/** Restituisce statistiche sulla colonna ap_esterno
	 * 
	 */
	@Query("select min(ap_esterno) from Dato")
	   double getminapE();
	@Query("select max(ap_esterno) from Dato")
	   double getmaxapE();
	@Query("select avg(ap_esterno) from Dato")
	   double getavgapE();
	@Query("select count(ap_esterno) from Dato")
	   int getcountapE();
	@Query("select sum(ap_esterno) from Dato")
	   double getsumapE();
	@Query("select ap_esterno from Dato")
	ArrayList<Double> getAllAp_esterno();
	
	/** Restituisce statistiche sulla colonna latitudine
	 * 
	 * @Query
	 */
	@Query("select min(lat) from Dato")
	   double getminLat();
	@Query("select max(lat) from Dato")
	   double getmaxLat();
	@Query("select avg(lat) from Dato")
	   double getavgLat();
	@Query("select count(lat) from Dato")
	   int getcountLat();
	@Query("select sum(lat) from Dato")
	   double getsumLat();
	@Query("select lat from Dato")
	   ArrayList<Double> getAllLat();
	
	/** Restituisce statistiche sulla colonna longitudine
	 * 
	 * @Query
	 */
	@Query("select min(lon) from Dato")
	   double getminLon();
	@Query("select max(lon) from Dato")
	   double getmaxLon();
	@Query("select avg(lon) from Dato")
	   double getavgLon();
	@Query("select count(lon) from Dato")
	   int getcountLon();
	@Query("select sum(lon) from Dato")
	   double getsumLon();
	@Query("select lon from Dato")
	   ArrayList<Double> getAllLon();
	
	
	/** Restituisce statistiche sulla colonna comune
	 * 
	 * @Query
	 */
	 @Query("select distinct comune from Dato")
	   ArrayList<String> getDistinctComune();
	 @Query("select count(comune) from Dato where comune = ?1")
	   int countComuneByName(String comune);
	 
	 /** Restituisce statistiche sulla colonna access_point
		 * 
		 * @Query
		 */
		 @Query("select distinct access_point from Dato")
		   ArrayList<String> getDistinctAccessPoint();
		 @Query("select count(access_point) from Dato where access_point = ?1")
		   int countAccessPointByName(String access_point);
}
