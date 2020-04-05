package com.kaviddiss.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaviddiss.model.Dato;
import com.kaviddiss.model.Stats;
import com.kaviddiss.model.StatsString;
import com.kaviddiss.repository.DataRestRepository;

/**
 * Produce i dati e i servizi
 * Utilizza una Repository personalizzata - DataRestRepository
 * Il DataRestRepository è estesa con JPARepository e CRUDRepository
 */

@Service
public class DataService {
	private DataRestRepository dataRestRepository;
 
	@Autowired
    public DataService(DataRestRepository dataRestRepository) {
        this.dataRestRepository = dataRestRepository;
    }
    
	/**
	 * Restituisce tutti i dati dal repository
	 * @return Tutti i dati
	 */
    public Iterable<Dato> list() {
        return dataRestRepository.findAll();
    }
    
    /**
     * Salva un valore di tipo Dato nel repository
     * @param dato il valore di tipo Dato da salvare nel repository
     * @return salva il valore nel repository
     */
    public Dato save(Dato dato) {
        return dataRestRepository.save(dato);
    }
    
    /**
     * Salva una lista di valori di tipo Dato nel repository
     * @param dati una lista di valori di tipo Dato da salvare nel repository
     */
    public void save(List<Dato> dati) {
        dataRestRepository.saveAll(dati);
        }
    
    /**
     * Elimina un elemento dal repository
     * @param id indica elemento da eliminare
     * @return comunica se elemento è stato cancellato o no
     */
    public String delete(Long id) {
    	Optional<Dato> dato = dataRestRepository.findById(id);
    	if(dato.isPresent()) {
    	dataRestRepository.delete(dato.get());
    	return "deleted";}
    	else
    	return "not found";
    }
    /**
     * Le prossime 5 funzioni producono le statistiche sulle colonne numeriche
     * @param field nome della colonna
     * @param dstd deviazione standard calcolato sulla colonna
     * @return le statistiche sulla colonna
     */
    
	public Stats getStatsID(String field,double dstd) {
		   Double avg=null,min=null,max=null,sum=null;
		   int count=0;
		   min=dataRestRepository.getminID();
		   max=dataRestRepository.getmaxID();
		   sum=dataRestRepository.getsumID();
		   avg=dataRestRepository.getavgID();
		   count=dataRestRepository.getcountID();
		   
		   Stats s=new Stats(field,avg,min,max,sum,dstd,count);
		   return s;
	}

	public Stats getStatsapI(String field,double dstd) {
		   Double avg=null,min=null,max=null,sum=null;
		   int count=0;
		   min=dataRestRepository.getminapI();
		   max=dataRestRepository.getmaxapI();
		   sum=dataRestRepository.getsumapI();
		   avg=dataRestRepository.getavgapI();
		   count=dataRestRepository.getcountapI();
		   Stats s=new Stats(field,avg,min,max,sum,dstd,count);
		   return s;
	}

	public Stats getStatsapE(String field,double dstd) {
		   Double avg=null,min=null,max=null,sum=null;
		   int count=0;
		   min=dataRestRepository.getminapE();
		   max=dataRestRepository.getmaxapE();
		   sum=dataRestRepository.getsumapE();
		   avg=dataRestRepository.getavgapE();
		   count=dataRestRepository.getcountapE();
		   Stats s=new Stats(field,avg,min,max,sum,dstd,count);
		   return s;
	}

	public Stats getStatslat(String field,double dstd) {
		   Double avg=null,min=null,max=null,sum=null;
		   int count=0;
		   min=dataRestRepository.getminLat();
		   max=dataRestRepository.getmaxLat();
		   sum=dataRestRepository.getsumLat();
		   avg=dataRestRepository.getavgLat();
		   count=dataRestRepository.getcountLat();
		   Stats s=new Stats(field,avg,min,max,sum,dstd,count);
		   return s;
	}

	public Stats getStatslon(String field,double dstd) {
		   Double avg=null,min=null,max=null,sum=null;
		   int count=0;
		   min=dataRestRepository.getminLon();
		   max=dataRestRepository.getmaxLon();
		   sum=dataRestRepository.getsumLon();
		   avg=dataRestRepository.getavgLon();
		   count=dataRestRepository.getcountLon();
		   Stats s=new Stats(field,avg,min,max,sum,dstd,count);
		   return s;
	}
    
	/**
	 * Le prossime 2 funzioni producono le statistiche sulle colonne stringhe
	 * @param field nome della colonna
	 * @return Statistiche sulla colonna
	 */
	public StatsString getStatsComune(String field){
		   ArrayList<String> dati = dataRestRepository.getDistinctComune();
		   HashMap<String,Integer> statsColonna = new HashMap<String,Integer>();
		   for(int i=0; i<dati.size(); i++)
		   {
			statsColonna.put(dati.get(i), dataRestRepository.countComuneByName(dati.get(i)));   
		   }
		   
		   StatsString s = new StatsString (field,statsColonna);
		   return s;
	       }

	public StatsString getStatsAccessPoint(String field){
		   
		  ArrayList<String>  dati = dataRestRepository.getDistinctAccessPoint();
		 
		   HashMap<String,Integer> statsColonna = new HashMap<String,Integer>();
		   for(int i=0; i<dati.size(); i++)
		   {
			statsColonna.put(dati.get(i), dataRestRepository.countAccessPointByName(dati.get(i)));   
		   }
		   StatsString s = new StatsString (field,statsColonna);
		   return s;
		   }
	
	/**
	 * Calcola deviazione standard sulle colonne numeriche
	 * @param field nome della colonna sul quale calcolare la deviazione standard
	 * @return Deviazione Standard calcolata sulla colonna desiderata
	 */
	public double devSTD(String field) {
		ArrayList<Double> array = new ArrayList<Double>();
		double sum = 0;
		Double avg; 
		
		
		if(field.equals("id")) {
			array=dataRestRepository.getAllID();
			avg=dataRestRepository.getavgID();}
		
		else if(field.equals("ap_interno")) {
			array=dataRestRepository.getAllAp_interno();
			avg=dataRestRepository.getavgapI();}
		
		else if(field.equals("ap_esterno")) {
			array=dataRestRepository.getAllAp_esterno();
			avg=dataRestRepository.getavgapE();
		}
		else if(field.equals("lat")){
			array=dataRestRepository.getAllLat();
			avg=dataRestRepository.getavgLat();
		}
		else {
			array=dataRestRepository.getAllLon();
			avg=dataRestRepository.getavgLon();
		}
		
		for(int i=0;i<array.size();i++) {
				sum += (double) Math.pow(array.get(i)-avg,2);
			}
		
		
		return (double) Math.pow(sum/array.size(), 0.5);
	}
	
		
	}

      
    
