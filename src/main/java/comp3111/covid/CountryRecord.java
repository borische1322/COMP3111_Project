package comp3111.covid;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * CountryRecord is a class that stores the SingleRecords needed to show in a table or in a chart
 *
 * 
 *
 */
public class CountryRecord {
	public LocalDate[] period;
	public ArrayList<String> countryName = new ArrayList<String>();
	public ArrayList<String> countryISO = new ArrayList<String>();
	public Map<String, Long> population = new HashMap<String, Long>();
	public Map<String,ArrayList<SingleRecord>> records = new HashMap<String,ArrayList<SingleRecord>>();
	public char task;
	
	/**
	 * This constructor will store all the relevant SingleRecords inside records
	 * @param dataset file name
	 * @param location all the countries interested
	 * @param task selected task
	 * @param period of interest
	 */
	public CountryRecord(String dataset, String[] location, char task, LocalDate[] period) {
		if (task == 'A' || task == 'B' || task =='C')
			this.task = task;
		else
			this.task = ' ';
		if (period.length == 2)
			this.period = period;
		else if (period.length > 0) {
			LocalDate[] temp = {period[0], period[0]};
			this.period = temp;
		} else{
			this.period = null;
		}
		
		try {
			for (String country : location) {
				countryName.add(country);
				population.put(country, DataAnalysis.getPopulation(dataset,country));
				countryISO.add(DataAnalysis.getISO(dataset,country));
				if (task == 'A') {
					records.put(country, DataAnalysis.getConfirmedCasesRecords(dataset, country, this.period));
				} else if (task == 'B') {
					records.put(country, DataAnalysis.getConfirmedDeathsRecords(dataset, country, this.period));
				} else if (task == 'C') {
					records.put(country, DataAnalysis.getVaxRateRecords(dataset, country, this.period, population.get(country)));
				}
			}
		}
		catch (NullPointerException e) {
			System.out.print("something is Null");
		}
		
		
	}
	
	/**
	 * this will return the ArrayList countryName
	 * @return countryName ArrayList
	 */
	public ArrayList<String> getCountryName() {
		return this.countryName;
	}
	
	/**
	 * this will return the ArrayList countryISO
	 * @return countryISO ArrayList
	 */
	public ArrayList<String> getCountryISO() {
		return this.countryISO;
	}
	

}
