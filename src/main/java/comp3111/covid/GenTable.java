package comp3111.covid;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * A Class to process Table
 * 
 *
 */
public class GenTable {
	
	/**
	 * to add all the data in countryRecod to the table 
	 * @param countryRecord the countryRecord storing all the data
	 * @param table to be displayed
	 * @param country TableColumn 1 displaying counties name
	 * @param c1 TableColumn 2 displaying the data
	 * @param c2 TableColumn 3 also displaying the data
	 * @param a name of TableColumn 2
	 * @param b name of TableColumn 3
	 * @param task selected task
	 * @param recordDate interested date
	 * @return the table with all the data added
	 */
	public static TableView<SingleRecord> generateTable(
			CountryRecord countryRecord,
			TableView<SingleRecord> table,
			TableColumn<SingleRecord,String> country,
			TableColumn<SingleRecord,String> c1,
			TableColumn<SingleRecord,String> c2,
			String a,
			String b,
			char task,
			LocalDate recordDate){
		
		country.setCellValueFactory(new PropertyValueFactory<>("countryName"));
		c1.setCellValueFactory(new PropertyValueFactory<>(a));
		c2.setCellValueFactory(new PropertyValueFactory<>(b));
		
		table.getItems().clear();
		table.getItems().addAll(addData(countryRecord, task, recordDate));

    	return table;
	}
	
	/**
	 * add the data to the list inside the table which store all the items
	 * @param countryRecord the countryRecord storing all the data
	 * @param task selected task
	 * @param recordDate interested date
	 * @return list of records
	 */
	public static List<SingleRecord> addData(CountryRecord countryRecord, char task, LocalDate recordDate){
		List<SingleRecord> listOfRecords = new ArrayList<SingleRecord>();
		for (String e : countryRecord.countryName) {
    		try {
    			listOfRecords.add(countryRecord.records.get(e).get(0));
    		}
    		catch (IndexOutOfBoundsException f) {
    			if (task == 'A') {
    				listOfRecords.add(new ConfirmedCases(recordDate, -1, -1.0, e, recordDate));
    			} else if (task == 'B') {
    				listOfRecords.add(new ConfirmedDeaths(recordDate, -1, -1.0, e, recordDate));
    			} else if (task == 'C'){
    				listOfRecords.add(new VaccinationRate(recordDate, -1, -1, e, recordDate));
    			}
    			
    		}
    	}
		return listOfRecords;
	}
	
	/**
	 * sort the table by country name
	 * @param records list of all the records in the table
	 * @param reverse boolean value indication if it is ascending order or descending order
	 * @return list of sorted records
	 */
	public static List<SingleRecord> sortDataByCountry(List<SingleRecord> records, boolean reverse){
		
		if (!reverse) {
			Collections.sort(records);
			Collections.reverse(records);
		} else {
			Collections.sort(records);
		}
		
		return records;
	}
	
	/**
	 * sort the table by the second column
	 * @param records list of all the records in the table
	 * @param reverse boolean value indication if it is ascending order or descending order
	 * @param task selected task
	 * @return list of sorted records
	 */
	public static List<SingleRecord> sortDataByCase(List<SingleRecord> records, boolean reverse, char task){
		
		
		if (task == 'A') {
			ConfirmedCases[] j = {};
			List<ConfirmedCases> jj = Arrays.asList(records.toArray(j));
			Collections.sort(jj, ConfirmedCases.Comparators.CaseNumber);
			
			if (!reverse) {
				Collections.reverse(jj);
			}
			
			for (int i = 0; i < jj.size(); i++) {
				
				records.set(i, jj.get(i));
				
			}
			
			
		} else if (task == 'B') {
			ConfirmedDeaths[] j = {};
			List<ConfirmedDeaths> jj = Arrays.asList(records.toArray(j));
			Collections.sort(jj, ConfirmedDeaths.Comparators.DeathsNumber);
			
			if (!reverse) {
				Collections.reverse(jj);
			}
			
			for (int i = 0; i < jj.size(); i++) {
				
				records.set(i, jj.get(i));
				
			}
			
			
		} else if (task == 'C') {
			VaccinationRate[] j = {};
			List<VaccinationRate> jj = Arrays.asList(records.toArray(j));
			Collections.sort(jj, VaccinationRate.Comparators.VaccinatedNumber);
			
			if (!reverse) {
				Collections.reverse(jj);
			}
			
			for (int i = 0; i < jj.size(); i++) {
				
				records.set(i, jj.get(i));
				
			}
			
			System.out.println(jj);
			System.out.println(records);
			
			
		}
		
		return records;
	}
	
	/**
	 * sort the table by the third column
	 * @param records list of all the records in the table
	 * @param reverse boolean value indication if it is ascending order or descending order
	 * @param task selected task
	 * @return list of sorted records
	 */
	public static List<SingleRecord> sortDataByCasePM(List<SingleRecord> records, boolean reverse, char task){
		if (task == 'A') {
			ConfirmedCases[] j = {};
			List<ConfirmedCases> jj = Arrays.asList(records.toArray(j));
			Collections.sort(jj, ConfirmedCases.Comparators.CaseNumberPerM);
			
			if (!reverse) {
				Collections.reverse(jj);
			}
			
			for (int i = 0; i < jj.size(); i++) {
				
				records.set(i, jj.get(i));
				
			}
			
			
		} else if (task == 'B') {
			ConfirmedDeaths[] j = {};
			List<ConfirmedDeaths> jj = Arrays.asList(records.toArray(j));
			Collections.sort(jj, ConfirmedDeaths.Comparators.DeathsNumberPerM);
			
			if (!reverse) {
				Collections.reverse(jj);
			}
			
			for (int i = 0; i < jj.size(); i++) {
				
				records.set(i, jj.get(i));
				
			}
			
			
		} else if (task == 'C') {
			VaccinationRate[] j = {};
			List<VaccinationRate> jj = Arrays.asList(records.toArray(j));
			Collections.sort(jj, VaccinationRate.Comparators.VaccinationRate);
			
			if (!reverse) {
				Collections.reverse(jj);
			}
			
			for (int i = 0; i < jj.size(); i++) {
				
				records.set(i, jj.get(i));
				
			}
			System.out.println(jj);
			System.out.println(records);
			
			
			
			
		}
		
		
		return records;
	}
	

}
