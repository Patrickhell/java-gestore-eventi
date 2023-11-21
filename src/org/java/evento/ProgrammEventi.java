package org.java.evento;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ProgrammEventi {
	
	private String titolo;
	private List<Evento> eventi;
	
	
	public ProgrammEventi(String titolo){
		
		
		setTitolo(titolo);
		//INIZZIALIZZO UNA LISTA DI EVENTI COME UNA NUOVA ARRAYLIST
		 this.eventi = new ArrayList<>();
		
	}

	
	
	public String getTitolo() {
		return titolo;
	}



	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}



	public List<Evento> getEventi() {
		return eventi;
	}



	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}



	public void  addEvent( Evento evento) {
		
		eventi.add(evento);
		
	}
	
	public List<Evento> eventOnSpecificDate(LocalDate data){
		
		return eventi.stream()
                .filter(evento -> evento.getDate().equals(data))
                .collect(Collectors.toList());
	}
	
	public int getEventNumbers() {
		
		return eventi.size();
	}
	
	public void cancelEventList() {
		
		eventi.clear();
	}
	
	public String getEventOrderedByDate() {
		
		String orderedEvent = eventi.stream()
				              //ORDINO IN BASE ALLA DATA
				              .sorted(Comparator.comparing(Evento::getDate))
				              // LI MAPPO IN MODO CHE ABBIANO LA CONFIGURAZIONE DESIDERATA
				              .map(evento -> evento.getDate() + "-" + evento.getTitle())
				              // SI UNISCONO GLI ELEMENTI
				              .collect(Collectors.joining("\n"));
				         
		
		return getTitolo() + orderedEvent  ;
	}

}
