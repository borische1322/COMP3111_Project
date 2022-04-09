package comp3111.covid;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;

import javafx.scene.SnapshotParameters;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.WritableImage;

/**
 * a class to process Chart
 * 
 *
 */
public class GenChart {
	/**
	 * to add all the data in countryRecod to the chart
	 * @param lineChart the LineChart to add the data
	 * @param countryRecord the countryRecord storing all the data
	 * @param days the duration of the interested period in days
	 * @param selectedCountries all the selected counties
	 * @param task selected task
	 * @return return the LineChart with data added
	 */
	public static LineChart<String, Number> generateChart(
			LineChart<String, Number> lineChart,
			CountryRecord countryRecord,
			long days,
			ArrayList<String> selectedCountries,
			char task){
		
		// Set the title
		if(task == 'A')
			lineChart.setTitle("Cumulative Confirmed COVID-19 Cases (per 1M)");
		else if(task == 'B')
			lineChart.setTitle("Cumulative Confirmed COVID-19 Deaths (per 1M)");
		else if(task == 'C')
			lineChart.setTitle("Cumulative Rate of Vaccination against COVID-19 ");
		//fix the x- axis to the input period
        XYChart.Series<String, Number> range = new XYChart.Series<>();
        
        	
        ZoneId zoneIdrange = ZoneId.systemDefault();
        	
        String patternrange = "MMM d, yyyy";
        DateFormat dfrange = new SimpleDateFormat(patternrange);
        	  
        
        LocalDate currentDaytest = countryRecord.period[0];
        range.setName("From " + currentDaytest + " to " + countryRecord.period[1]);
        makeASeries(days, 
        		currentDaytest,
        		zoneIdrange,
        		dfrange,
				null,
				null,
				1,
				'R',
				range);
        	
        lineChart.getData().add(range); 
        range.getNode().setVisible(false);
        
      //Preparing the data points for the line
        for(int i=0; i<selectedCountries.size(); i++) {
        	XYChart.Series<String, Number> series = new XYChart.Series<>();
        	series.setName(selectedCountries.get(i));
        	
            ZoneId zoneId = ZoneId.systemDefault();
        	
        	String pattern = "MMM d, yyyy";
        	DateFormat df = new SimpleDateFormat(pattern);
        	
        	System.out.println(countryRecord.records.size());
        	System.out.println(countryRecord.period.length);
        	LocalDate currentDay = countryRecord.period[0];
        	
        	makeASeries(days, 
					currentDay,
					zoneId,
					df,
					countryRecord,
					selectedCountries,
					i,
					task,
					series);

        	lineChart.getData().add(series); 
        }
        
		return lineChart;
	}
	
	/**
	 * to add all the data of a specific county to a XYChart.Series
	 * @param days duration of interested period in days
	 * @param currentDay the first date of the period
	 * @param zoneId a ZoneId
	 * @param df a DateFormat for displaying the dates
	 * @param countryRecord the countryRecord that includes the records of the country
	 * @param selectedCountries countries selected
	 * @param i the index of the country to be added in the selectedCountry ArrayList
	 * @param task selected task
	 * @param series to be added with data
	 * @return series XYChart.Series with all the data of a specific county added
	 */
	public static  XYChart.Series<String, Number> makeASeries(long days, 
																LocalDate currentDay,
																ZoneId zoneId,
																DateFormat df,
																CountryRecord countryRecord,
																ArrayList<String> selectedCountries,
																int i,
																char task,
																 XYChart.Series<String, Number> series){
		for(int y=0, k = 0; y<days; y++) {
    		ZonedDateTime zdt = currentDay.atStartOfDay(zoneId);
            Date date2 = Date.from(zdt.toInstant());
            String date = df.format(date2);
            

        	try{
        		if (task == 'R') {
        			series.getData().add(new XYChart.Data<String, Number>(date,0));
        		}else {
        		if(!countryRecord.records.get(selectedCountries.get(i)).get(k).getDate().isEqual(currentDay)) {
               
                	currentDay = currentDay.plusDays(1);
                	continue;
                }
        		
        		if (task == 'A') {
        		if(((ConfirmedCases) countryRecord.records.get(selectedCountries.get(i)).get(k)).getCaseNumberlong() > -1) {
        			if (countryRecord.records.get(selectedCountries.get(i)).get(k).isActualDate()) {
        				SingleRecord single = (ConfirmedCases) countryRecord.records.get(selectedCountries.get(i)).get(k);
	        			series.getData().add(new XYChart.Data<String, Number>(date,((ConfirmedCases) single).caseNumberPerM));
        			}
                }
        		} else if (task == 'B') {
        			if(((ConfirmedDeaths) countryRecord.records.get(selectedCountries.get(i)).get(k)).getDeathNumberlong() > -1) {
	        			if (countryRecord.records.get(selectedCountries.get(i)).get(k).isActualDate()) {
	        				SingleRecord single = (ConfirmedDeaths) countryRecord.records.get(selectedCountries.get(i)).get(k);
		        			series.getData().add(new XYChart.Data<String, Number>(date,((ConfirmedDeaths) single).deathNumberPerM));
	        			}
	                }
        		} else if (task == 'C'){
        			if(((VaccinationRate) countryRecord.records.get(selectedCountries.get(i)).get(k)).getVaccinatedNumberlong() > -1) {
	        			if (countryRecord.records.get(selectedCountries.get(i)).get(k).isActualDate()) {
	        				SingleRecord single = (VaccinationRate) countryRecord.records.get(selectedCountries.get(i)).get(k);
		        			series.getData().add(new XYChart.Data<String, Number>(date,((VaccinationRate) single).vaccinationRate));
	        			}
	                } 
        		}
        		}
        		
        	}
        	catch (IndexOutOfBoundsException f) {
        		
        	}
        	k++;
        	currentDay = currentDay.plusDays(1);
    	}
		return series;
	}
	
	
	/**
	 * this function saves a line chart as a png file in the designated location
	 * @param lineChart the LineChart in javafx to be saved
	 * @param file path the relative path (of the project) to save the resulting png image
	 * @throws IOException
	 */
	
    public static void saveAsPng(LineChart<String,Number> lineChart, File file) throws IOException{
        WritableImage image = lineChart.snapshot(new SnapshotParameters(), null);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        	Alert alert = new Alert(AlertType.CONFIRMATION,"Image successfully saved as " + file.getAbsolutePath());
        	alert.setHeaderText(null);
        	alert.setGraphic(null);
        	alert.showAndWait();
        	
        } catch (IOException e) {
        	throw new IOException();
        }
    }
}


