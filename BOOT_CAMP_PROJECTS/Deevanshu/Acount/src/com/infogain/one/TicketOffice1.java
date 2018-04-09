package com.infogain.two.synchronizedblock;
/**
 * This class simulates a ticket office. It sell or return tickets
 * for the two cinemas
 *
 */
public class TicketOffice1 implements Runnable {

	/**
	 * The cinema 
	 */
	private Cinema cinema;
	
	/**
	 * Constructor of the class
	 * @param cinema the cinema
	 */
	public TicketOffice1 (Cinema cinema) {
		this.cinema=cinema;
	}
	
	/**
	 * Core method of this ticket office. Simulates selling and returning tickets
	 */
	@Override
	public void run() {
		cinema.sellTickets1(3);
		cinema.sellTickets1(2);
		
	}

}
