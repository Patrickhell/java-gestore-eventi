package org.java.evento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
	
	private LocalTime ora;
	private float prezzo;
	
	public Concerto(String title, LocalDate date, int totalSeatNumbers, int reservedSeats, LocalTime ora, float prezzo)throws Exception {
		
		super(title, date, totalSeatNumbers, reservedSeats);
		
		setOra(ora);
		setPrezzo(prezzo);
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		
		
		this.ora = ora;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	
    public String getDateFormatter() {
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    	
        return super.getDate().format(formatter);
    }
    
    public String getHourFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return ora.format(formatter);
    }
    
    public String getPrezzoFormatter() {
        return String.format("%.2f€", prezzo);
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "data e ora formattata - titolo - prezzo formattato" + "\n"
    		   + getDateFormatter() +  ","
    	       + getHourFormatter() 
    	       + "-" +  super.getTitle() 
    	       + "-" + getPrezzoFormatter();
    	                      
    			
    }
}
