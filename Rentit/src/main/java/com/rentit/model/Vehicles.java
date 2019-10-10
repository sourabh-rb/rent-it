package com.rentit.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

import com.rentit.test_class.TestClass;

/**
 * Vehicles model class.
 * @author Basant Gera
 *
 */
public class Vehicles    {
	private Integer id;
	private String LicPlate;
	private String Type;
	private String Make;
	private String Model;
	private String iYear;
	private String Color;

	private boolean isAvailable=true;
	


	public boolean isAvailable() {
		return isAvailable;
	}


	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public  int index;
	
	
	
	 
	public Vehicles(int id,String Make, String Model,String iYear,String Type,String Color,String LicPlate,boolean isAvailable) {
		super();
		this.id = id;
		this.Make = Make;
		this.Model= Model;
		this.Type = Type;
		this.iYear = iYear;
		this.Color = Color;
		this.LicPlate = LicPlate;
		this.isAvailable=isAvailable;
	}

	
	public Vehicles() {
		this.id = index ++;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLicPlate() {
		return LicPlate;
	}

	public void setLicPlate(String licPlate) {
		LicPlate = licPlate;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getMake() {
		return Make;
	}

	public void setMake(String make) {
		Make = make;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public String getiYear() {
		return iYear;
	}

	public void setiYear(String iYear) {
		this.iYear = iYear;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	@Override
	public String toString() {
		return "Vehicles [id=" + id + ", LicPlate=" + LicPlate + ", Type=" + Type + ", Make=" + Make + ", Model="
				+ Model + ", iYear=" + iYear + ", Color=" + Color + ", index=" + index + "]";
	}
	
	public Integer getNext() {
		
		//return this.id;
		//return vehicleService.getNextVehicle(this.id);
		return (id>=13) ? 13 :this.id + 1;
		
	}
	
	public Integer getPrevious() {
		//return this.id - 1;
		return (id<=1) ? 1 :this.id - 1;
		
	}



}
