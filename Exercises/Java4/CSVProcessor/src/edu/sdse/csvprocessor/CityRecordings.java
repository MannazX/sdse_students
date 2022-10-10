package edu.sdse.csvprocessor;

public class CityRecordings {
	
	int cityID;
	int year;
	String name;
	int population;
	
	public CityRecordings(int cityID, int year, String name, int population) {
		super();
		this.cityID = cityID;
		this.year = year;
		this.name = name;
		this.population = population;
		// TODO Auto-generated constructor stub
	}

	public int getCityID() {
		return cityID;
	}

	public void setCityID(int cityID) {
		this.cityID = cityID;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
	@Override
	public String toString() {
		return "cityID: " + cityID + ", year: " + year + ", name: " + name + ", population: " + population;
	}

}
