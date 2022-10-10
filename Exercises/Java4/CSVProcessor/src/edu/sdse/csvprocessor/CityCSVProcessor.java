package edu.sdse.csvprocessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

public class CityCSVProcessor {
	
	public void readAndProcess(File file) {
		//Try with resource statement (as of Java 8)
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			//Discard header row
			br.readLine();
			
			String line;
			
			while ((line = br.readLine()) != null) {
				// Parse each line
				String[] rawValues = line.split(",");
				
				int id = convertToInt(rawValues[0]);
				int year = convertToInt(rawValues[1]);
				String city = convertToString(rawValues[2]);
				int population = convertToInt(rawValues[3]);
				
				System.out.println("id: " + id + ", year: " + year + ", city: " + city + ", population: " + population);
				
				//TODO: Extend the program to process entries!
			}
		} catch (Exception e) {
			System.err.println("An error occurred:");
			e.printStackTrace();
		}
	}
	
	public void cityRecorder(File file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			List<CityRecordings> cityRecordings = new ArrayList<CityRecordings>();
			String line = "";
			String DELIM = ",";
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] cityRecording = line.split(DELIM);
				
				if (cityRecording.length > 0) {
					CityRecordings recording = new CityRecordings(Integer.parseInt(cityRecording[0]), Integer.parseInt(cityRecording[1]), cityRecording[2], Integer.parseInt(cityRecording[3]));
					cityRecordings.add(recording);
				}
			}
			
			for (CityRecordings recording : cityRecordings) {
				System.out.println(cityRecordings.toString());
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String cleanRawValue(String rawValue) {
		return rawValue.trim();
	}
	
	private int convertToInt(String rawValue) {
		rawValue = cleanRawValue(rawValue);
		return Integer.parseInt(rawValue);
	}
	
	private String convertToString(String rawValue) {
		rawValue = cleanRawValue(rawValue);
		
		if (rawValue.startsWith("\"") && rawValue.endsWith("\"")) {
			return rawValue.substring(1, rawValue.length() - 1);
		}
		
		return rawValue;
	}
	
	public static final void main(String[] args) {
		CityCSVProcessor reader = new CityCSVProcessor();
		
		File dataDirectory = new File("data/");
		File csvFile = new File(dataDirectory, "Cities.csv");
		
		reader.readAndProcess(csvFile);
		reader.cityRecorder(csvFile);
	}
}
