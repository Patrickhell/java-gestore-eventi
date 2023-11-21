package org.java.evento;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	

	private String title;
	private LocalDate date;
	private int totalSeatNumbers;
	private int reservedSeats;
	
	public Evento(String title, LocalDate date, int totalSeatNumbers, int reservedSeats) throws Exception{
		
		
		setTitle(title);
		setDate(date);
		setTotalSeatNumbers(totalSeatNumbers);
		reservedSeats = 0;

		
	}
	
	
	public String getTitle() {
		return title;
	}







	public void setTitle(String title) {
		this.title = title;
	}







	public LocalDate getDate() {
		return date;
	}







	public void setDate(LocalDate date) {
		this.date = date;
	}







	public int getTotalSeatNumbers() {
		return totalSeatNumbers;
	}

 



	private void setTotalSeatNumbers(int totalSeatNumbers)throws Exception  {
		
            if(totalSeatNumbers <= 0 ) 
			
			throw new Exception("Il numero di posti non può essere 0 o negativo ");
		
		this.totalSeatNumbers = totalSeatNumbers;
	}







	public int getReservedSeats() {
		return reservedSeats;
	}



    public int availableSeats() {
    	
	   return getTotalSeatNumbers() - getReservedSeats();

    }



	public void reserve() throws Exception{
		
		LocalDate currentDate = LocalDate.now();
		
		
		if(date.isBefore(currentDate)) {
			
			throw new Exception("La data dell'evento non può essere anteriore a quella di oggi ");
		}
		
		if(availableSeats() <= 0 ) {
			throw new Exception("Numero di posti esaurito");
		}
		
		 
		
		reservedSeats++;
	}
	
	public void removeReservedPlace()  throws Exception  {
		LocalDate currentDate = LocalDate.now();
		
        if(date.isBefore(currentDate)) {
			
			throw new Exception("l'evento è passato ");
		}

       if(reservedSeats == 0) {
			
			throw new Exception("Non ci sono prenotazioni");
		}
       
       reservedSeats--;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Titolo - data formattata: " + getTitle() + "-" + getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				
	}
}
	
	
