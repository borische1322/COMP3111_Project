package comp3111.covid;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javafx.scene.control.CheckBox;


import org.apache.commons.csv.*;
import edu.duke.*;

/**
 * 
 * Data Explorer on COVID-19
 * @author <a href=mailto:namkiu@ust.hk>Namkiu Chan</a>
 * @version	1.1
 * 
 */
public class DataAnalysis {
 
	/**
	 * to get the content of the dataset file
	 * @param dataset file name
	 * @return all the content would be stored in CSVParser
	 */
	public static CSVParser getFileParser(String dataset) {
	     FileResource fr = new FileResource("dataset/" + dataset);
	     return fr.getCSVParser(true);
		}
	

//	public static String getConfirmedCases(String dataset, String iso_code) {
//		String oReport = "";	
//		long confirmedCases = 0;
//		long numRecord = 0;
//		long totalNumRecord = 0;
//		
//		for (CSVRecord rec : getFileParser(dataset)) {
//			
//			if (rec.get("iso_code").equals(iso_code)) {
//				String s = rec.get("new_cases");
//				if (!s.equals("")) {
//					confirmedCases += Long.parseLong(s);
//					numRecord++;
//				}
//			}		
//			totalNumRecord++;
//		}
//		
//		oReport = String.format("Dataset (%s): %,d Records\n\n", dataset, totalNumRecord);
//		oReport += String.format("[Summary (%s)]\n", iso_code);
//		oReport += String.format("Number of Confirmed Cases: %,d\n", confirmedCases);
//		oReport += String.format("Number of Days Reported: %,d\n", numRecord);
//		
//		return oReport;
//	}
//	
//	 public static String getConfirmedDeaths(String dataset, String iso_code) {
//			String oReport = "";	
//			long confirmedDeaths = 0;
//			long numRecord = 0;
//			long totalNumRecord = 0;
//			
//			for (CSVRecord rec : getFileParser(dataset)) {
//				
//				if (rec.get("iso_code").equals(iso_code)) {
//					String s = rec.get("new_deaths");
//					if (!s.equals("")) {
//						confirmedDeaths += Long.parseLong(s);
//						numRecord++;
//					}
//				}		
//				totalNumRecord++;
//			}
//			
//			oReport = String.format("Dataset (%s): %,d Records\n\n", dataset, totalNumRecord);
//			oReport += String.format("[Summary (%s)]\n", iso_code);
//			oReport += String.format("Number of Deaths: %,d\n", confirmedDeaths);
//			oReport += String.format("Number of Days Reported: %,d\n", numRecord);
//			
//			return oReport;
//	 }
//	 
//	 public static String getRateOfVaccination(String dataset, String iso_code) {
//			String oReport = "";	
//			long fullyVaccinated = 0;
//			long numRecord = 0;
//			long totalNumRecord = 0;
//			long population = 0;
//			float rate = 0.0f;
//						
//			for (CSVRecord rec : getFileParser(dataset)) {
//				
//				if (rec.get("iso_code").equals(iso_code)) {
//					
//					String s1 = rec.get("people_fully_vaccinated");
//					String s2 = rec.get("population");		
//					if (!s1.equals("") && !s2.equals("")) {
//						fullyVaccinated = Long.parseLong(s1);
//						population = Long.parseLong(s2);						
//						numRecord++;
//					}
//				}		
//				totalNumRecord++;
//			}
//			
//			if (population !=0)
//				rate = (float) fullyVaccinated / population * 100;
//			
//			oReport = String.format("Dataset (%s): %,d Records\n\n", dataset, totalNumRecord);
//			oReport += String.format("[Summary (%s)]\n", iso_code);
//			oReport += String.format("Number of People Fully Vaccinated: %,d\n", fullyVaccinated);
//			oReport += String.format("Population: %,d\n", population);
//			oReport += String.format("Rate of Vaccination: %.2f%%\n", rate);
//			oReport += String.format("Number of Days Reported: %,d\n", numRecord);
//			
//			return oReport;
//	 }
	 
	/**
	 * to get the population of a country
	 * @param dataset file name
	 * @param location country to be searched
	 * @return the population of location in long variable
	 */
	 public static long getPopulation(String dataset, String location) {	
			long population = 0;
						
			for (CSVRecord rec : getFileParser(dataset)) {
				
				if (rec.get("location").equals(location)) {
					
					String s2 = rec.get("population");		
					if (!s2.equals("")) {
						population = Long.parseLong(s2);						
					}
				}		
			}
			
			return population;
	 }
	 
	 /**
	  * to get the ISO of a country
	  * @param dataset file name
	  * @param location county to be searched
	  * @return ISO in string variable
	  */
	 public static String getISO(String dataset, String location) {	
			String ISO = "";
						
			for (CSVRecord rec : getFileParser(dataset)) {
				
				if (rec.get("location").equals(location)) {
					
					String s2 = rec.get("iso_code");		
					if (!s2.equals("")) {
						ISO = s2;						
					}
				}		
			}
			
			return ISO;
	 }
	 
	 /**
	  * to get all the countries name in a csv dataset file
	  * @param dataset file name
	  * @return map of all the counties name
	  */
	 public static Map<String, String> getAllLocation(String dataset) {	
		 Map<String, String> locations = new TreeMap<String,String>();
						
			for (CSVRecord rec : getFileParser(dataset)) {
				
				if (!locations.containsKey(rec.get("iso_code"))) {
					//String s1 = rec.get("iso_code");
					String s2 = rec.get("location");		
					if (!s2.equals("") && !s2.equals("")) {
						locations.put(s2, s2);			
					}
				}		
			}
			
			return locations;
	 }
	 
	 /**
	  * get the records of a country's {@link ConfirmedCases} on a specific date
	  * @param dataset file name
	  * @param location country to be searched
	  * @param date interested date
	  * @return ArrayList storing that record
	  */
	 public static ArrayList<SingleRecord> getConfirmedCasesRecords(String dataset, String location, LocalDate[] date) {
		    ArrayList<SingleRecord> records = new ArrayList<SingleRecord>();	
			long confirmedCases = 0;
			Double confirmedCasesPM = 0.0;
			LocalDate actualDate = null;
			
			if (date == null || location == null) {
				System.out.print("Date or location null");
				return null;
			}
			
			for (CSVRecord rec : getFileParser(dataset)) {
				
	
				if (rec.get("location").equals(location)) {
					String recordstrDate = rec.get("date");
					String[] tokenDates = recordstrDate.split("/");
					LocalDate recordDate = LocalDate.of(Integer.parseInt(tokenDates[2]),
														Integer.parseInt(tokenDates[0]), 
														Integer.parseInt(tokenDates[1]));
					//System.out.println(location);
					String s = rec.get("total_cases");
					String ss = rec.get("total_cases_per_million");
					if (!s.equals("")) {
						actualDate = recordDate;
						confirmedCases = Long.parseLong(s);
						confirmedCasesPM = Double.parseDouble(ss);
							
					} else if (confirmedCases <= 0){
						confirmedCases = -1;
						confirmedCasesPM = -1.0;
					}
					if (!recordDate.isAfter(date[1]) && !recordDate.isBefore(date[0])) {
						if (s.equals("") && confirmedCases != -1  && actualDate.isBefore(recordDate)) {
							records.add(new ConfirmedCases(recordDate, confirmedCases, confirmedCasesPM, location, actualDate));
						}else {
							records.add(new ConfirmedCases(recordDate, confirmedCases, confirmedCasesPM, location, null));
						}
					}
				}
				

					
			}

			
			return records;
		}
	 
	 /**
	  * get the records of a country's {@link VaccinationRate} on a specific date
	  * @param dataset file name
	  * @param location country to be searched
	  * @param date interested date
	  * @param population of the country
	  * @return ArrayList storing that record
	  */
	 public static ArrayList<SingleRecord> getVaxRateRecords(String dataset, String location, LocalDate[] date, long population) {
		    ArrayList<SingleRecord> records = new ArrayList<SingleRecord>();	
			long vaxNum = 0;
			LocalDate recordDate = null;
			LocalDate actualDate = null;
			
			if (date == null || location == null) {
				return null;
			}
			
			for (CSVRecord rec : getFileParser(dataset)) {
				

				if (rec.get("location").equals(location)) {
					String recordstrDate = rec.get("date");
					
					String[] tokenDates = recordstrDate.split("/");
					recordDate = LocalDate.of(Integer.parseInt(tokenDates[2]),
							Integer.parseInt(tokenDates[0]), 
							Integer.parseInt(tokenDates[1]));
					System.out.println(location);
					System.out.println(recordstrDate);
					String s = rec.get("people_fully_vaccinated");
					if (!s.equals("")) {
						actualDate = recordDate;
						vaxNum = Long.parseLong(s);
							
					} else if(vaxNum <= 0) {
						vaxNum = -1;
							
					} 
					if (!recordDate.isAfter(date[1]) && !recordDate.isBefore(date[0])) {
					
						if (s.equals("") && vaxNum != -1 && actualDate.isBefore(recordDate)) {

							records.add(new VaccinationRate(recordDate, vaxNum, population, location, actualDate));
						}else {
							records.add(new VaccinationRate(recordDate, vaxNum, population, location, null));
						}
					}
				}
				
						
			}
		

			
			return records;
		}
	 
	 /**
	  * get the records of a country's {@link ConfirmedDeaths} on a specific date
	  * @param dataset file name
	  * @param location country to be searched
	  * @param date interested date
	  * @return ArrayList storing that record
	  */
	 public static ArrayList<SingleRecord> getConfirmedDeathsRecords(String dataset, String location, LocalDate[] date) {
		    ArrayList<SingleRecord> records = new ArrayList<SingleRecord>();	
			long confirmedDeaths = 0;
			Double confirmedDeathsPM = 0.0;
			LocalDate actualDate = null;
			
			if (date == null || location == null) {
				return null;
			}
			
			for (CSVRecord rec : getFileParser(dataset)) {
				

				if (rec.get("location").equals(location)) {
					String recordstrDate = rec.get("date");
					String[] tokenDates = recordstrDate.split("/");
					LocalDate recordDate = LocalDate.of(Integer.parseInt(tokenDates[2]),
							Integer.parseInt(tokenDates[0]), 
							Integer.parseInt(tokenDates[1]));
					//System.out.println(location);
					String s = rec.get("total_deaths");
					String ss = rec.get("total_deaths_per_million");
					if (!s.equals("")) {
						actualDate = recordDate;
						confirmedDeaths = Long.parseLong(s);
						confirmedDeathsPM = Double.parseDouble(ss);
						
					} else if (confirmedDeaths <= 0){
						confirmedDeaths = -1;
						confirmedDeathsPM = -1.0;
							
					}
					if (!recordDate.isAfter(date[1]) && !recordDate.isBefore(date[0])) {
						if (s.equals("") && confirmedDeaths != -1 && actualDate.isBefore(recordDate)) {
							records.add(new ConfirmedDeaths(recordDate, confirmedDeaths, confirmedDeathsPM, location, actualDate));
						}else {
						records.add(new ConfirmedDeaths(recordDate, confirmedDeaths, confirmedDeathsPM, location, null));
						}
					}
				}	
				
			
					
			}
			
			
			return records;
		}
	 
	 /**
	  * to get all the countries selected by the user
	  * @param location_boxes of all the countries
	  * @return ArrayList of all the selected country names
	  */
	 public static ArrayList<String> getSelectedCountries(List<CheckBox> location_boxes){
		 
	    	ArrayList<String> selectedCountries = new ArrayList<String>();
	    	
	    	for (CheckBox box:location_boxes) {
	    		if (box.isSelected()) {
	    			selectedCountries.add(box.getText());
	    		}
	    	};
	    	
	    	return selectedCountries;
	 }
	 
	 
 
}