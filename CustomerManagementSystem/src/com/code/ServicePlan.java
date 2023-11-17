package com.code;

public enum ServicePlan {
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);
	private double charges;
	
	private ServicePlan(double charges) {
		this.charges=charges;
	}
	
	public double getCharges() {
		return charges;
	}
	
	public void setCharges(double charges) {
		this.charges=charges;
	}
	
	public String toString() {
		return name().toLowerCase()+ " Charges: "+ charges;
	}
}
