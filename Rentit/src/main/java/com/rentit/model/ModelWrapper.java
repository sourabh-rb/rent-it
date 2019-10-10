package com.rentit.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Models wrapper class
 * @author soura
 *
 */
public class ModelWrapper {
	private Clients client;
	private Bookings booking;
	private Vehicles vehicle;
	private Clerks clerk;
	private ArrayList<Vehicles> catalogList;
	
	
	public ModelWrapper() {
		client = new Clients();
		booking = new Bookings();
		vehicle = new Vehicles();
		clerk = new Clerks();
		catalogList = new ArrayList<Vehicles>();
	}

	public ArrayList<Vehicles> getCatalogList() {
		return catalogList;
	}

	public void setCatalogList(List<Vehicles> result) {
		this.catalogList = (ArrayList<Vehicles>) result;
	}

	public Clients getClient() {
		return client;
	}
	
	public void setClient(Clients client) {
		this.client = client;
	}
	
	public Bookings getBooking() {
		return booking;
	}
	
	public void setBooking(Bookings booking) {
		this.booking = booking;
	}

	public Vehicles getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicles vehicle) {
		this.vehicle = vehicle;
	}

	public Clerks getClerk() {
		return clerk;
	}

	public void setClerk(Clerks clerk) {
		this.clerk = clerk;
	}
	
	

}
