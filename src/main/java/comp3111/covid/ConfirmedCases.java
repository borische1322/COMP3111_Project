package comp3111.covid;

import java.time.LocalDate;
import java.util.Comparator;

/**
 * a Class that extends {@link SingleRecord} which records a country's Confirmed Case Number and Confirmed Case Per M
 * 
 *
 */
public class ConfirmedCases extends SingleRecord {
	
	long caseNumber;
	Double caseNumberPerM;
	
	/**
	 * a constructor which creates an instance of ConfirmedCases
	 * @param recordDate interested date
	 * @param caseNumber Confirmed Cases number
	 * @param confirmedCasesPM Confirmed Cases Per M
	 * @param location interested country
	 * @param actualDate actual date of record
	 */
	public ConfirmedCases(LocalDate recordDate, long caseNumber, Double confirmedCasesPM, String location, LocalDate actualDate) {
		
		super(recordDate, location, actualDate); 
		
		if (caseNumber >=0)
			this.caseNumber = caseNumber;
		else
			this.caseNumber = -1;
		
		if (confirmedCasesPM >= 0)
			this.caseNumberPerM = confirmedCasesPM;
		else
			this.caseNumberPerM = -1.0;
	}
	
	/**
	 * to get caseNumber
	 * @return caseNumber
	 */
	public long getCaseNumberlong() {
		return this.caseNumber;
	}
	
	/**
	 * to get the string of caseNumber, N/A if not available, and with actual date if the data is not actually from the date provided
	 * @return string
	 */
	public String getCaseNumber() {
		if (caseNumber == -1) {
			return "N/A";
		} else if (super.actualDate != null){
			return String.valueOf(caseNumber) + "			(as of " + super.actualDate + ")";
		} else {
			return String.valueOf(caseNumber);
		}
	}
	
	/**
	 * to get caseNumberPerM
	 * @return caseNumberPerM
	 */
	public double getCaseNumberPerMdouble() {
		return this.caseNumberPerM;
	}
	
	/**
	 * to get the string of caseNumberPerM, N/A if not available, and with actual date if the data is not actually from the date provided
	 * @return string
	 */
	public String getCaseNumberPerM() {
		if (this.caseNumberPerM == -1) {
			return "N/A";
		} else if (super.actualDate != null){
			return String.format("%.2f", caseNumberPerM) + "			(as of " + super.actualDate + ")";
		} else {
			 return String.format("%.2f", caseNumberPerM);
		}
	}
	
	/**
	 * to print out ConfirmedCases
	 */
	public String toString() {
		return super.date + " " + caseNumber + " " + caseNumberPerM;
	}
	
	/**
	 * used to compare instances of ConfirmedCases
	 * 
	 *
	 */
	public static class Comparators {
		/**
		 * compare with caseNumber
		 */
	    public static final Comparator<ConfirmedCases> CaseNumber = (ConfirmedCases o1, ConfirmedCases o2) -> Long.compare(o1.caseNumber,o2.caseNumber);
	    
	    /**
		 * compare with caseNumberPerM
		 */
	    public static final Comparator<ConfirmedCases> CaseNumberPerM = (ConfirmedCases o1, ConfirmedCases o2) -> Double.compare(o1.caseNumberPerM, o2.caseNumberPerM);
	   
	}
	
	
}
