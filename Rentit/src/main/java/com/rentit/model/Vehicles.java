package com.rentit.model;

public class Vehicles {
	private Integer id;
	private String LicPlate;
	private String Type;
	private String Make;
	private String Model;
	private String iYear;
	private String Color;
	
	public  int index = 0;
	
	
	public Vehicles(String id,String Make, String Model,String iYear,String Type) {
		super();
		this.id = index ++;
		this.Make = Make;
		this.Model= Model;
		this.Type = Type;
		this.iYear = iYear;
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


	
	
	


}
