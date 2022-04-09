package comp3111.covid;

import java.time.LocalDate;
import java.util.Comparator;


/**
 * a Class that extends {@link SingleRecord} which records a country's Fully Vacinated Number and Vaccination Rate
 * 
 *
 */
public class VaccinationRate extends SingleRecord {
	
	long vaccinatedNumber;
	double vaccinationRate;
	
	/**
	 * a constructor which creates an instance of VaccinationRate
	 * @param date interested date
	 * @param vaccinatedNumber number of fully vaccinated
	 * @param population of country
	 * @param location interested country
	 * @param actualDate of the record
	 */
	public VaccinationRate(LocalDate date, long vaccinatedNumber, long population, String location,  LocalDate actualDate) {
		
		super(date, location, actualDate);
		
		if (vaccinatedNumber >= 0)
			this.vaccinatedNumber = vaccinatedNumber;
		else
			this.vaccinatedNumber = -1;
		if (population != 0 && vaccinatedNumber >=0) 
			this.vaccinationRate = ((double) vaccinatedNumber)/((double)population)*100.0;
		else
			this.vaccinationRate = -1.0;

		
	}
	
	/**
	 * to get vaccinatedNumber
	 * @return vaccinatedNumber
	 */
	public long getVaccinatedNumberlong() {
		return this.vaccinatedNumber;
	}
	
	/**
	 * to get the string of vaccinatedNumber, N/A if not available, and with actual date if the data is not actually from the date provided
	 * @return string
	 */
	public String getVaccinatedNumber() {
		if (this.vaccinatedNumber == -1) {
			return "N/A";
		} else if (super.actualDate != null){
			return String.valueOf(vaccinatedNumber) + "			(as of " + super.actualDate + ")";
		} else {
			return String.valueOf(vaccinatedNumber);
		}
	}
	
	/**
	 * to get vaccinationRate
	 * @return vaccinationRate
	 */
	public double getVaccinationRatedouble() {
		return this.vaccinationRate;
	}
	
	/**
	 * to get the string of vaccinationRate, N/A if not available, and with actual date if the data is not actually from the date provided
	 * @return string
	 */
	public String getVaccinationRate() {
		if (this.vaccinationRate == -1) {
			return "N/A";
		} else if (super.actualDate != null){
			return String.format("%.2f", vaccinationRate) + "%" + "			(as of " + super.actualDate + ")";
		} else {
			return String.format("%.2f", vaccinationRate) + "%";
		}
	}
	
	/**
	 * to print out VaccinationRate
	 */
	public String toString() {
		return super.date + " " + vaccinatedNumber + " " + vaccinationRate;
	}
	
	/**
	 * used to compare instances of VaccinationRate
	 * 
	 *
	 */
	public static class Comparators {
		
		/**
		 * compare with vaccinatedNumber
		 */
	    public static final Comparator<VaccinationRate> VaccinatedNumber = (VaccinationRate o1, VaccinationRate o2) -> Long.compare(o1.vaccinatedNumber,o2.vaccinatedNumber);
	    
	    /**
		 * compare with vaccinationRate
		 */
	    public static final Comparator<VaccinationRate> VaccinationRate = (VaccinationRate o1, VaccinationRate o2) -> Double.compare(o1.vaccinationRate, o2.vaccinationRate);
	   
	}
	
}
