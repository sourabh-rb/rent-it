package com.rentit.model;


public class ModelWrapper {
	private Clients client;
	private Bookings booking;
	private Vehicles vehicle;
	private Clerks clerk;
	
	
	public ModelWrapper() {
		client = new Clients();
		booking = new Bookings();
		vehicle = new Vehicles();
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
