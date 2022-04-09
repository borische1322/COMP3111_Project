package comp3111.covid;

import java.time.LocalDate;

/**
 * a class that register the record of a country with a date which implements {@link Comparable}
 * 
 *
 */
public class SingleRecord implements Comparable<SingleRecord>{
	
	String countryName;
	LocalDate date;
	LocalDate actualDate;
	
	/**
	 * constructor of SingleRecord
	 * @param recordDate interested date
	 * @param countryName country name
	 * @param actualDate actual date of the record
	 */
	public SingleRecord(LocalDate recordDate, String countryName, LocalDate actualDate) {
		if (!countryName.equals(""))
			this.countryName = countryName;
		if (recordDate != null)
			this.date = recordDate;
		if (actualDate != null && actualDate.isEqual(recordDate)) {
			this.actualDate = null;
		}else {
			this.actualDate = actualDate;
		}
	};
	
	/**
	 * get the date of this record
	 * @return date of the record
	 */
	public LocalDate getDate() {
		return this.date;
	}
	
	/**
	 * get the actual date of the record
	 * @return if the record data is actually not from the date, return the actual date of the record, else, return null
	 */
	public LocalDate getActualDate() {
		return this.actualDate;
	}
	
	/**
	 * check if the record is actually the record of the given date
	 * @return true if this record is from the given date, false if the record is actually from another date
	 */
	public Boolean isActualDate() {
		return actualDate == null;
	}
	
	/**
	 * get the record's country name
	 * @return country name in string
	 */
	public String getCountryName() {
		return this.countryName;
	}
	
	/**
	 * override the compareTo method from the implemented interface Comparable
	 */
	@Override
	public int compareTo(SingleRecord o) {
		if (o != null) {
			return this.countryName.compareTo(o.countryName);
		} else {
			return -1;
		}
		
	}
	
}
