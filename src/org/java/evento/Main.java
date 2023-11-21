package org.java.evento;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		 float prezzoConcerto = 25.0f;

		 try {
	            // Input dei dati per creare un nuovo evento
	            System.out.println("Inserisci il titolo: ");
	            String title = sc.nextLine().toLowerCase();

	            System.out.println("Inserisci la data nel formato dd-MM-yyyy:");
	            String input = sc.nextLine();
	            LocalDate date = LocalDate.parse(input, formatter);

	            System.out.println("Inserisci il numero totale di posti: ");
	            int totalSeatNumbers = Integer.parseInt(sc.nextLine());

	            // Creazione di un nuovo evento
	            Evento event = new Evento(title, date, totalSeatNumbers, 0);

	            // PRENOTAZIONI
	            System.out.println("Vuoi effettuare delle prenotazioni? (Si/No)");
	            String risposta = sc.nextLine().toLowerCase();

	            if (risposta.equals("si")) {
	                System.out.println("Quante prenotazioni vuoi effettuare?");
	                int numeroPrenotazioni = Integer.parseInt(sc.nextLine());

	                for (int i = 0; i < numeroPrenotazioni; i++) {
	                	
	                	event.reserve();
	                }
	                	
	                    try {
	                        
	                     System.out.println("Prenotazione effettuata con successo!");
	                    } catch (Exception e) {
	                        System.out.println("Impossibile effettuare la prenotazione: " + e.getMessage());
	                    }

	                System.out.println("Posti prenotati: " + event.getReservedSeats());
	                System.out.println("Posti disponibili: " + (event.getTotalSeatNumbers() - event.getReservedSeats()));

	                // DISDETTE
	                System.out.println("Vuoi disdire delle prenotazioni? (Si/No)");
	                String disdette = sc.nextLine().toLowerCase();

	                if (disdette.equals("si")) {
	                    System.out.println("Quante prenotazioni vuoi disdire?");
	                    int nroDisdette = Integer.parseInt(sc.nextLine());

	                    for (int i = 0; i < nroDisdette; i++) {
	                    	
	                    	event.removeReservedPlace();
	                    }
	                        try {
	                            
	                            System.out.println("Disdetta effettuata con successo!");
	                        } catch (Exception e) {
	                            System.out.println("Impossibile effettuare la disdetta: " + e.getMessage());
	                        }

	                    System.out.println("Posti prenotati dopo le disdette: " + event.getReservedSeats());
	                    System.out.println("Posti disponibili: " + (event.getTotalSeatNumbers() - event.getReservedSeats()));
	                    
	                    Concerto c = new Concerto(title, date, totalSeatNumbers, event.getReservedSeats(), LocalTime.of(18, 30),prezzoConcerto  );
	        	   		System.out.println(c);
	                }
	            } else {
	                System.out.println("Nessuna prenotazione effettuata.");
	            }
	          
	   		
	        } catch (Exception e) {
	            System.out.println("Errore durante la gestione dell'evento: " + e.getMessage());
	        } finally {
	            sc.close();
	        }

	}

	
		
}



