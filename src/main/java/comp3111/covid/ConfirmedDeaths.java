package comp3111.covid;

import java.time.LocalDate;
import java.util.Comparator;

/**
 * a Class that extends {@link SingleRecord} which records a country's Confirmed Death Number and Confirmed Deaths Per M
 * 
 *
 */
public class ConfirmedDeaths extends SingleRecord {
	
	long deathNumber;
	double deathNumberPerM;
	
	/**
	 * a constructor which creates an instance of ConfirmedDeaths
	 * @param date interested date
	 * @param deathNumber Confirmed Deaths number
	 * @param confirmedDeathsPM Confirmed Deaths Per M
	 * @param location interested country
	 * @param actualDate actual date of the record
	 */
	public ConfirmedDeaths(LocalDate date, long deathNumber, Double confirmedDeathsPM, String location,  LocalDate actualDate) {
		
		super(date, location, actualDate);
		//System.out.println(date);
		//System.out.println(location);
		
		if (deathNumber >= 0)
			this.deathNumber = deathNumber;
		else
			this.deathNumber = -1;
		
		if (confirmedDeathsPM >= 0)
			this.deathNumberPerM = confirmedDeathsPM;
		else
			this.deathNumberPerM = -1.0;
		
	}
	
	/**
	 * to get deathNumber
	 * @return deathNumber
	 */
	public long getDeathNumberlong() {
		return this.deathNumber;
	}
	
	/**
	 * to get the string of deathNumber, N/A if not available, and with actual date if the data is not actually from the date provided
	 * @return string
	 */
	public String getDeathNumber() {
		if (deathNumber == -1) {
			return "N/A";
		}else if (super.actualDate != null){
			return String.valueOf(deathNumber) + "			(as of " + super.actualDate + ")";
		}else {
			return String.valueOf(deathNumber);
		}
	}
	
	/**
	 * to get deathNumberPerM
	 * @return deathNumberPerM
	 */
	public double getDeathNumberPerMdouble() {
		return this.deathNumberPerM;
	}
	
	/**
	 * to get the string of deathNumberPerM, N/A if not available, and with actual date if the data is not actually from the date provided
	 * @return string
	 */
	public String getDeathNumberPerM() {
		if (this.deathNumberPerM == -1) {
			return "N/A";
		} else if (super.actualDate != null){
			return String.format("%.2f", deathNumberPerM)  + "			(as of " + super.actualDate + ")";
		} else {
			 return String.format("%.2f", deathNumberPerM);
		}
	}
	
	
	/**
	 * to print out ConfirmedDeaths
	 */
	public String toString() {
		return super.date + " " + deathNumber + " " + deathNumberPerM;
	}
	
	/**
	 * used to compare instances of ConfirmedDeaths
	 * 
	 *
	 */
	public static class Comparators {
		/**
		 * compare with deathNumber
		 */
	    public static final Comparator<ConfirmedDeaths> DeathsNumber = (ConfirmedDeaths o1, ConfirmedDeaths o2) -> Long.compare(o1.deathNumber,o2.deathNumber);
	   
	    /**
	     * compare with deathNumberPerM
	     */
	    public static final Comparator<ConfirmedDeaths> DeathsNumberPerM = (ConfirmedDeaths o1, ConfirmedDeaths o2) -> Double.compare(o1.deathNumberPerM, o2.deathNumberPerM);
	   
	}
}
