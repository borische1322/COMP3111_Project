package deCOVIDTest;

import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import comp3111.covid.ConfirmedCases;
import comp3111.covid.ConfirmedDeaths;
import comp3111.covid.CountryRecord;
import comp3111.covid.DataAnalysis;
import comp3111.covid.FilePicker;
import comp3111.covid.GenChart;
import comp3111.covid.GenTable;
import comp3111.covid.SingleRecord;
import comp3111.covid.UpdateCountry;
import comp3111.covid.VaccinationRate;
import javafx.scene.chart.XYChart;

public class Testing {

	@Test
	public void getConfirmedCasesRecordsTesting1() {
		//Correct Confirmed Cases Records object with a date that doesn't have a record
		LocalDate h = LocalDate.of(2020, 1, 22);
		LocalDate[] hh = {h,h};
		
		ArrayList<SingleRecord> ok = DataAnalysis.getConfirmedCasesRecords("COVID_Dataset_v1.0.csv", "Hong Kong", hh);
		assertTrue(ok.isEmpty());
		
		ok.add(new ConfirmedCases(LocalDate.of(2020, 12, 13), -1, -1.0, "NO", null));
		assertEquals("N/A", ((ConfirmedCases) ok.get(0)).getCaseNumber());
		assertEquals("N/A", ((ConfirmedCases) ok.get(0)).getCaseNumberPerM());
		
	}
	
	@Test
	public void getConfirmedCasesRecordsTesting2() {
		//Correct Confirmed Cases Records object with a date that doesn't have a record
		LocalDate b = LocalDate.of(2021, 7, 21);
		LocalDate[] bb = {b,b};
		
		ArrayList<SingleRecord> ok = DataAnalysis.getConfirmedCasesRecords("COVID_Dataset_v1.0.csv", "Hong Kong", bb);
		assertTrue(ok.isEmpty());

	}
	
	@Test
	public void getConfirmedCasesRecordsTesting3() {
		//Correct Confirmed Cases Records object with a date that has a record
		LocalDate j = LocalDate.of(2020, 1, 23);
		LocalDate[] jj = {j,j};
		
		ArrayList<SingleRecord> ok = DataAnalysis.getConfirmedCasesRecords("COVID_Dataset_v1.0.csv", "Hong Kong", jj);
		assertEquals(2, ((ConfirmedCases) ok.get(0)).getCaseNumberlong());
		assertEquals(0.267, ((ConfirmedCases) ok.get(0)).getCaseNumberPerMdouble(),0.0);
		assertEquals(String.valueOf(((ConfirmedCases) ok.get(0)).getCaseNumberlong()), ((ConfirmedCases) ok.get(0)).getCaseNumber());
		assertEquals(String.format("%.2f",((ConfirmedCases) ok.get(0)).getCaseNumberPerMdouble()), ((ConfirmedCases) ok.get(0)).getCaseNumberPerM());
		assertTrue(ok.get(0).getDate().isEqual(j));

	}
	
	@Test
	public void getConfirmedCasesRecordsTesting4() {
		//Correct Confirmed Cases Records object with a date that has a record
		LocalDate k = LocalDate.of(2020, 1, 24);
		LocalDate[] kk = {k,k};
		
		ArrayList<SingleRecord> ok = DataAnalysis.getConfirmedCasesRecords("COVID_Dataset_v1.0.csv", "Hong Kong", kk);
		assertEquals(2, ((ConfirmedCases) ok.get(0)).getCaseNumberlong());
		assertEquals(0.267, ((ConfirmedCases) ok.get(0)).getCaseNumberPerMdouble(),0.0);
		assertEquals(String.valueOf(((ConfirmedCases) ok.get(0)).getCaseNumberlong()), ((ConfirmedCases) ok.get(0)).getCaseNumber());
		assertEquals(String.format("%.2f",((ConfirmedCases) ok.get(0)).getCaseNumberPerMdouble()), ((ConfirmedCases) ok.get(0)).getCaseNumberPerM());
		assertTrue(ok.get(0).getDate().isEqual(k));

	}
	
	@Test
	public void getConfirmedCasesRecordsTesting5() { 
		//Correct Confirmed Cases Records object with a date that has a record
		LocalDate m = LocalDate.of(2021, 7, 19);
		LocalDate[] mm = {m,m};
		
		ArrayList<SingleRecord> ok = DataAnalysis.getConfirmedCasesRecords("COVID_Dataset_v1.0.csv", "Hong Kong", mm);
		assertEquals(11958, ((ConfirmedCases) ok.get(0)).getCaseNumberlong());
		assertEquals(1595.041, ((ConfirmedCases) ok.get(0)).getCaseNumberPerMdouble(),0.0);
		assertEquals(String.valueOf(((ConfirmedCases) ok.get(0)).getCaseNumberlong()), ((ConfirmedCases) ok.get(0)).getCaseNumber());
		assertEquals(String.format("%.2f",((ConfirmedCases) ok.get(0)).getCaseNumberPerMdouble()), ((ConfirmedCases) ok.get(0)).getCaseNumberPerM());
		assertTrue(ok.get(0).getDate().isEqual(m));
	}
	
	@Test
	public void getConfirmedCasesRecordsTesting6() {
		//Correct Confirmed Cases Records object with a date that has a record
		LocalDate n = LocalDate.of(2021, 7, 20);
		LocalDate[] nn = {n,n};

		
		ArrayList<SingleRecord> ok = DataAnalysis.getConfirmedCasesRecords("COVID_Dataset_v1.0.csv", "Hong Kong", nn);
		assertEquals(11965, ((ConfirmedCases) ok.get(0)).getCaseNumberlong());
		assertEquals(1595.974, ((ConfirmedCases) ok.get(0)).getCaseNumberPerMdouble(),0.0);
		assertEquals(String.valueOf(((ConfirmedCases) ok.get(0)).getCaseNumberlong()), ((ConfirmedCases) ok.get(0)).getCaseNumber());
		assertEquals(String.format("%.2f",((ConfirmedCases) ok.get(0)).getCaseNumberPerMdouble()), ((ConfirmedCases) ok.get(0)).getCaseNumberPerM());
		assertTrue(ok.get(0).getDate().isEqual(n));
	}
	
	@Test
	public void getConfirmedCasesRecordsTestingNullInput() {

		LocalDate n = LocalDate.of(2021, 7, 20);
		LocalDate[] nn = {n,n};

		//Confirmed Cases Records object with no dates
		ArrayList<SingleRecord> ok = DataAnalysis.getConfirmedCasesRecords("COVID_Dataset_v1.0.csv", "Hong Kong", null);
		assertEquals(ok, null);
		//Confirmed Cases Records object with no ISO
		ok = DataAnalysis.getConfirmedCasesRecords("COVID_Dataset_v1.0.csv", null , nn);
		assertEquals(ok, null);
	}
	
	
	
	@Test
	public void getConfirmedDeathsRecordsTesting1() {
		//Correct Confirmed Deaths Records object with a date that doesn't have a record
		LocalDate h = LocalDate.of(2020, 1, 22);
		LocalDate[] hh = {h,h};
		
		ArrayList<SingleRecord> ok = DataAnalysis.getConfirmedDeathsRecords("COVID_Dataset_v1.0.csv", "Hong Kong", hh);
		assertTrue(ok.isEmpty());
		
	}
	
	@Test
	public void getConfirmedDeathsRecordsTesting2() {
		//Correct Confirmed Deaths Records object with a date that doesn't have a record
		LocalDate b = LocalDate.of(2021, 7, 21);
		LocalDate[] bb = {b,b};
		
		ArrayList<SingleRecord> ok = DataAnalysis.getConfirmedDeathsRecords("COVID_Dataset_v1.0.csv", "Hong Kong", bb);
		assertTrue(ok.isEmpty());

	}
	
	@Test
	public void getConfirmedDeathsRecordsTesting3() {
		//Correct Confirmed Deaths Records object with a date that has a record but no data in such attribute
		LocalDate j = LocalDate.of(2020, 1, 23);
		LocalDate[] jj = {j,j};
		
		ArrayList<SingleRecord> ok = DataAnalysis.getConfirmedDeathsRecords("COVID_Dataset_v1.0.csv", "Hong Kong", jj);
		assertEquals(-1, ((ConfirmedDeaths) ok.get(0)).getDeathNumberlong());
		assertEquals(-1, ((ConfirmedDeaths) ok.get(0)).getDeathNumberPerMdouble(),0.0);
		assertEquals("N/A", ((ConfirmedDeaths) ok.get(0)).getDeathNumber());
		assertEquals("N/A", ((ConfirmedDeaths) ok.get(0)).getDeathNumberPerM());
		assertTrue(ok.get(0).getDate().isEqual(j));

	}
	
	@Test
	public void getConfirmedDeathsRecordsTesting4() {
		//Correct Confirmed Deaths Records object with a date that has a record but no data in such attribute
		LocalDate k = LocalDate.of(2020, 1, 24);
		LocalDate[] kk = {k,k};
		
		ArrayList<SingleRecord> ok = DataAnalysis.getConfirmedDeathsRecords("COVID_Dataset_v1.0.csv", "Hong Kong", kk);
		assertEquals(-1, ((ConfirmedDeaths) ok.get(0)).getDeathNumberlong());
		assertEquals(-1, ((ConfirmedDeaths) ok.get(0)).getDeathNumberPerMdouble(),0.0);
		assertEquals("N/A", ((ConfirmedDeaths) ok.get(0)).getDeathNumber());
		assertEquals("N/A", ((ConfirmedDeaths) ok.get(0)).getDeathNumberPerM());
		assertTrue(ok.get(0).getDate().isEqual(k));

	}
	
	@Test
	public void getConfirmedDeathsRecordsTesting5() { 
		//Correct Confirmed Deaths Records object with a date that has a record 
		LocalDate m = LocalDate.of(2021, 7, 19);
		LocalDate[] mm = {m,m};
		
		ArrayList<SingleRecord> ok = DataAnalysis.getConfirmedDeathsRecords("COVID_Dataset_v1.0.csv", "Hong Kong", mm);
		assertEquals(212, ((ConfirmedDeaths) ok.get(0)).getDeathNumberlong());
		assertEquals(28.278, ((ConfirmedDeaths) ok.get(0)).getDeathNumberPerMdouble(),0.0);
		assertEquals(String.valueOf(((ConfirmedDeaths) ok.get(0)).getDeathNumberlong()), ((ConfirmedDeaths) ok.get(0)).getDeathNumber());
		assertEquals(String.format("%.2f",((ConfirmedDeaths) ok.get(0)).getDeathNumberPerMdouble()), ((ConfirmedDeaths) ok.get(0)).getDeathNumberPerM());
		assertTrue(ok.get(0).getDate().isEqual(m));
	}
	
	@Test
	public void getConfirmedDeathsRecordsTesting6() {
		//Correct Confirmed Deaths Records object with a date that has a record 
		LocalDate n = LocalDate.of(2021, 7, 20);
		LocalDate[] nn = {n,n};

		
		ArrayList<SingleRecord> ok = DataAnalysis.getConfirmedDeathsRecords("COVID_Dataset_v1.0.csv", "Hong Kong", nn);
		assertEquals(212, ((ConfirmedDeaths) ok.get(0)).getDeathNumberlong());
		assertEquals(28.278, ((ConfirmedDeaths) ok.get(0)).getDeathNumberPerMdouble(),0.0);
		assertEquals(String.valueOf(((ConfirmedDeaths) ok.get(0)).getDeathNumberlong()), ((ConfirmedDeaths) ok.get(0)).getDeathNumber());
		assertEquals(String.format("%.2f",((ConfirmedDeaths) ok.get(0)).getDeathNumberPerMdouble()), ((ConfirmedDeaths) ok.get(0)).getDeathNumberPerM());
		assertTrue(ok.get(0).getDate().isEqual(n));
	}
	
	@Test
	public void getConfirmedDeathsRecordsTestingNullInput() {

		LocalDate n = LocalDate.of(2021, 7, 20);
		LocalDate[] nn = {n,n};

		//Confirmed Cases Deaths object with no dates
		ArrayList<SingleRecord> ok = DataAnalysis.getConfirmedDeathsRecords("COVID_Dataset_v1.0.csv", "Hong Kong", null);
		assertEquals(ok, null);
		//Confirmed Cases Deaths object with no ISO
		ok = DataAnalysis.getConfirmedDeathsRecords("COVID_Dataset_v1.0.csv", null , nn);
		assertEquals(ok, null);
	}
	
	
	
	@Test
	public void getVaxRateRecordsTesting1() {
		//Correct Vax Rate Records object with a date that doesn't have a record 
		LocalDate h = LocalDate.of(2020, 1, 22);
		LocalDate[] hh = {h,h};
		
		ArrayList<SingleRecord> ok = DataAnalysis.getVaxRateRecords("COVID_Dataset_v1.0.csv", "Hong Kong", hh, 7496988);
		assertTrue(ok.isEmpty());
		
	}
	
	@Test
	public void getVaxRateRecordsTesting2() {
		//Correct Vax Rate Records object with a date that doesn't have a record 
		LocalDate b = LocalDate.of(2021, 7, 21);
		LocalDate[] bb = {b,b};
		
		ArrayList<SingleRecord> ok = DataAnalysis.getVaxRateRecords("COVID_Dataset_v1.0.csv", "Hong Kong", bb,7496988);
		assertTrue(ok.isEmpty());

	}
	
	@Test
	public void getVaxRateRecordsTesting3() {
		//Correct Vax Rate Records object with a date that has a record but no data in such attribute
		LocalDate j = LocalDate.of(2020, 1, 23);
		LocalDate[] jj = {j,j};
		
		ArrayList<SingleRecord> ok = DataAnalysis.getVaxRateRecords("COVID_Dataset_v1.0.csv", "Hong Kong", jj,7496988);
		assertEquals(-1, ((VaccinationRate) ok.get(0)).getVaccinatedNumberlong());
		assertEquals(-1, ((VaccinationRate) ok.get(0)).getVaccinationRatedouble(),0.0);
		assertEquals("N/A", ((VaccinationRate) ok.get(0)).getVaccinatedNumber());
		assertEquals("N/A", ((VaccinationRate) ok.get(0)).getVaccinationRate());
		assertTrue(ok.get(0).getDate().isEqual(j));

	}
	
	@Test
	public void getVaxRateRecordsTesting4() {
		//Correct Vax Rate Records object with a date that has a record but no data in such attribute
		LocalDate k = LocalDate.of(2020, 1, 24);
		LocalDate[] kk = {k,k};
		
		ArrayList<SingleRecord> ok = DataAnalysis.getVaxRateRecords("COVID_Dataset_v1.0.csv", "Hong Kong", kk,7496988);
		assertEquals(-1, ((VaccinationRate) ok.get(0)).getVaccinatedNumberlong());
		assertEquals(-1, ((VaccinationRate) ok.get(0)).getVaccinationRatedouble(),0.0);
		assertEquals("N/A", ((VaccinationRate) ok.get(0)).getVaccinatedNumber());
		assertEquals("N/A", ((VaccinationRate) ok.get(0)).getVaccinationRate());
		assertTrue(ok.get(0).getDate().isEqual(k));

	}
	
	@Test
	public void getVaxRateRecordsTesting5() { 
		//Correct Vax Rate Records object with a date that has a record 
		LocalDate m = LocalDate.of(2021, 7, 19);
		LocalDate[] mm = {m,m};
		
		ArrayList<SingleRecord> ok = DataAnalysis.getVaxRateRecords("COVID_Dataset_v1.0.csv", "Hong Kong", mm,7496988);
		assertEquals(2038442, ((VaccinationRate) ok.get(0)).getVaccinatedNumberlong());
		assertEquals(((double)2038442)/((double)7496988) * 100.0, ((VaccinationRate) ok.get(0)).getVaccinationRatedouble(),0.0);
		assertEquals(String.valueOf(((VaccinationRate) ok.get(0)).getVaccinatedNumberlong()), ((VaccinationRate) ok.get(0)).getVaccinatedNumber());
		assertEquals(String.format("%.2f",((VaccinationRate) ok.get(0)).getVaccinationRatedouble()) + "%", ((VaccinationRate) ok.get(0)).getVaccinationRate());
		assertTrue(ok.get(0).getDate().isEqual(m));
	}
	
	@Test
	public void getVaxRateRecordsTesting6() {
		//Correct Vax Rate Records object with a date that has a record 
		LocalDate n = LocalDate.of(2021, 7, 20);
		LocalDate[] nn = {n,n};

		
		ArrayList<SingleRecord> ok = DataAnalysis.getVaxRateRecords("COVID_Dataset_v1.0.csv", "Hong Kong", nn,7496988);
		assertEquals(2065375, ((VaccinationRate) ok.get(0)).getVaccinatedNumberlong());
		assertEquals(((double)2065375)/((double)7496988) * 100.0, ((VaccinationRate) ok.get(0)).getVaccinationRatedouble(),0.0);
		assertEquals(String.valueOf(((VaccinationRate) ok.get(0)).getVaccinatedNumberlong()), ((VaccinationRate) ok.get(0)).getVaccinatedNumber());
		assertEquals(String.format("%.2f",((VaccinationRate) ok.get(0)).getVaccinationRatedouble()) + "%", ((VaccinationRate) ok.get(0)).getVaccinationRate());
		assertTrue(ok.get(0).getDate().isEqual(n));
	}
	
	@Test
	public void getVaxRateRecordsTestingNullInput() {

		LocalDate n = LocalDate.of(2021, 7, 20);
		LocalDate[] nn = {n,n};

		//Vax Rate Records object with no dates
		ArrayList<SingleRecord> ok = DataAnalysis.getVaxRateRecords("COVID_Dataset_v1.0.csv", "Hong Kong", null,7496988);
		assertEquals(ok, null);
		//Vax Rate Records object with no location
		ok = DataAnalysis.getVaxRateRecords("COVID_Dataset_v1.0.csv", null , nn, 0);
		assertEquals(ok, null);
	}
	
	@Test
	public void testActualDate() {
		
		LocalDate date = LocalDate.of(2020, 7, 1);
		LocalDate actual = LocalDate.of(2020, 6, 30);
		ConfirmedCases haha = new ConfirmedCases(date, 10, 10.0, "Hong Kong", actual);
		ConfirmedDeaths haha1 = new ConfirmedDeaths(date, 10, 10.0, "Hong Kong", actual);
		VaccinationRate haha2 = new VaccinationRate(date, 10, 10, "Hong Kong", actual);
		
		String ha = String.valueOf(haha.getCaseNumberlong()) + "			(as of " + haha.getActualDate() + ")";
		String hahaha = String.format("%.2f",haha.getCaseNumberPerMdouble()) + "			(as of " + haha.getActualDate() + ")";
		assertEquals(ha, haha.getCaseNumber());
		assertEquals(hahaha, haha.getCaseNumberPerM());
		
		String ha1 = String.valueOf(haha1.getDeathNumberlong()) + "			(as of " + haha1.getActualDate() + ")";
		String hahaha1 = String.format("%.2f",haha1.getDeathNumberPerMdouble()) + "			(as of " + haha1.getActualDate() + ")";
		assertEquals(ha1, haha1.getDeathNumber());
		assertEquals(hahaha1, haha1.getDeathNumberPerM());
		
		String ha2 = String.valueOf(haha2.getVaccinatedNumberlong()) + "			(as of " + haha2.getActualDate() + ")";
		String hahaha2 = String.format("%.2f",haha2.getVaccinationRatedouble()) + "%" + "			(as of " + haha2.getActualDate() + ")";
		assertEquals(ha2, haha2.getVaccinatedNumber());
		assertEquals(hahaha2, haha2.getVaccinationRate());
	}
	
	
	
	@Test
	public void countryRecordTestingISO() {
		String[] j = {"Hong Kong"};
		
		String kk = "HKG";
		String ii = "JPN";
		
		String t = "Hong Kong";
		String tt =  "Japan";
		
		String[] k = {t, tt};
		LocalDate s = LocalDate.of(2021, 7, 18);
		LocalDate e = LocalDate.of(2021, 7, 20);
		LocalDate[] p = {s,e};
		
		//Country Record with one correct location
		CountryRecord jj = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'A', p);
		assertEquals(jj.getCountryISO().get(0), kk);
		assertEquals(jj.getCountryName().get(0), t);
		assertEquals(jj.records.size(), 1);
		
		//Country Record with two/more correct location
		CountryRecord jjj = new CountryRecord("COVID_Dataset_v1.0.csv", k, 'A', p);
		assertEquals(jjj.getCountryISO().get(0), kk);
		assertEquals(jjj.getCountryISO().get(1), ii);
		assertEquals(jjj.countryName.get(0), t);
		assertEquals(jjj.countryName.get(1), tt);
		assertEquals(jjj.records.size(), 2);
		
		//Country Record with no location
		CountryRecord jjjj = new CountryRecord("COVID_Dataset_v1.0.csv", null, 'A', p);
		assertTrue(jjjj.countryISO.isEmpty());
		assertTrue(jjjj.countryName.isEmpty());
		assertTrue(jjjj.records.isEmpty());
		
	}
	
	@Test
	public void countryRecordTestingTask() {
		String[] j = {"Hong Kong"};
		LocalDate s = LocalDate.of(2021, 7, 18);
		LocalDate e = LocalDate.of(2021, 7, 20);
		LocalDate[] p = {s,e};
		
		//Country Record with task A
		CountryRecord jj = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'A', p);
		assertEquals(jj.records.size(), 1);
		
		//Country Record with task B
		jj = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'B', p);
		assertEquals(jj.records.size(), 1);
		
		//Country Record with task C
		jj = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'C', p);
		assertEquals(jj.records.size(), 1);
		
		//Country Record with wrong Char
		jj = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'K', p);
		assertEquals(jj.records.size(), 0);
		
	}

	@Test
	public void countryRecordTestingPeriod() {
		String location = "Hong Kong";
		String[] j = {location};
		LocalDate s = LocalDate.of(2021, 7, 18);
		LocalDate e = LocalDate.of(2021, 7, 20);
		LocalDate ee = LocalDate.of(2021, 7, 21);
		LocalDate eee = LocalDate.of(2020, 1, 22);
		LocalDate[] p = {s,e};
		LocalDate[] pp = {s, s};
		LocalDate[] ppp = {s, ee};
		LocalDate[] pppp = {ee, ee};
		LocalDate[] ppppp = {eee, eee};
		LocalDate[] pppppp = {eee, eee, eee};
		LocalDate[] ppppppp = {};
		
		//Country Record with a period of 3 valid dates
		CountryRecord jj = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'A', p);
		assertEquals(jj.records.get(location).size(), 3);
		//Country Record with a valid date
		jj = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'A', pp);
		assertEquals(jj.records.get(location).size(), 1);
		//Country Record with a period of 4 dates but only 3 dates is valid
		jj = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'A', ppp);
		assertEquals(jj.records.get(location).size(), 3);
		//Country Record with an invalid date before the first date
		jj = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'A', pppp);
		assertEquals(jj.records.get(location).size(), 0);
		//Country Record with an invalid date after the latest date
		jj = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'A', ppppp);
		assertEquals(jj.records.get(location).size(), 0);
		
		jj = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'A', pppppp);
		assertEquals(jj.records.get(location).size(), 0);
		
		jj = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'A', ppppppp);
		assertEquals(jj.records.get(location), null);
	}


	@Test
	public void checkTable() {
		
 
        String location = "Hong Kong";
		String[] j = {location};
		LocalDate s = LocalDate.of(2021, 7, 18);


		LocalDate[] pp = {s, s};

		
        CountryRecord countryRecord = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'A', pp);
        CountryRecord countryRecord1 = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'B', pp);
        CountryRecord countryRecord2 = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'C', pp);
        CountryRecord countryRecord3 = new CountryRecord("COVID_Dataset_v1.0.csv", null, 'R', pp);
        countryRecord3.getCountryName().add("Hong Kong");    
        countryRecord3.records.put("Hong Kong", new ArrayList<SingleRecord>());
        
        List<SingleRecord> haha = GenTable.addData(countryRecord, 'A', s);
        for (int i = 0; i < haha.size(); i++) {
        	assertEquals(haha.get(i).getDate(),countryRecord.records.get(location).get(i).getDate());
        	assertEquals(((ConfirmedCases)haha.get(i)).getCaseNumberlong(),((ConfirmedCases)countryRecord.records.get(location).get(i)).getCaseNumberlong());
        }
        
        List<SingleRecord> haha1 = GenTable.addData(countryRecord1, 'B', s);
        for (int i = 0; i < haha1.size(); i++) {
        	assertEquals(haha.get(i).getDate(),countryRecord1.records.get(location).get(i).getDate());
        	assertEquals(((ConfirmedDeaths)haha1.get(i)).getDeathNumberlong(),((ConfirmedDeaths)countryRecord1.records.get(location).get(i)).getDeathNumberlong());
        }
        
        List<SingleRecord> haha2 = GenTable.addData(countryRecord2, 'C', s);
        for (int i = 0; i < haha2.size(); i++) {
        	assertEquals(haha.get(i).getDate(),countryRecord2.records.get(location).get(i).getDate());
        	assertEquals(((VaccinationRate)haha2.get(i)).getVaccinatedNumberlong(),((VaccinationRate)countryRecord2.records.get(location).get(i)).getVaccinatedNumberlong());
        }
        List<SingleRecord> haha3 = GenTable.addData(countryRecord3, 'R', s);

        assertTrue(haha3.isEmpty());
 
        
	}
	


	@Test
	public void checkTableNull() {
		
 
        String location = "Hong Kong";
		String[] j = {location};
		LocalDate s = LocalDate.of(2020, 1, 22);

		LocalDate[] pp = {s, s};


		
        CountryRecord countryRecord = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'A', pp);
        CountryRecord countryRecord1 = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'B', pp);
        CountryRecord countryRecord2 = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'C', pp);
        
        List<SingleRecord> haha = GenTable.addData(countryRecord, 'A', s);
        for (int i = 0; i < haha.size(); i++) {
        	assertEquals(haha.get(i).getDate(),s);
        	assertEquals(((ConfirmedCases)haha.get(i)).getCaseNumberlong(),-1);
        }
        
        List<SingleRecord> haha1 = GenTable.addData(countryRecord1, 'B', s);
        for (int i = 0; i < haha.size(); i++) {
        	assertEquals(haha.get(i).getDate(),s);
        	assertEquals(((ConfirmedDeaths)haha1.get(i)).getDeathNumberlong(),-1);
        }
        
        List<SingleRecord> haha2 = GenTable.addData(countryRecord2, 'C', s);
        for (int i = 0; i < haha.size(); i++) {
        	assertEquals(haha.get(i).getDate(),s);
        	assertEquals(((VaccinationRate)haha2.get(i)).getVaccinatedNumberlong(),-1);
        }
        
	}
	
	
	
	@Test
	public void checkChart() {
		
 
        String location = "Hong Kong";
        
		String[] j = {location};
		
		ArrayList<String> jjj = new ArrayList<String>();
		jjj.add(location);
		LocalDate s = LocalDate.of(2021, 7, 18);
		LocalDate ss = LocalDate.of(2021, 7, 17);

		LocalDate ee = LocalDate.of(2021, 7, 21);

		LocalDate[] pp = {s, ee};

		
        CountryRecord countryRecord = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'A', pp);
        CountryRecord countryRecord1 = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'B', pp);
        CountryRecord countryRecord2 = new CountryRecord("COVID_Dataset_v1.0.csv", j, 'C', pp);
        
        XYChart.Series<String, Number> haha = new XYChart.Series<String, Number>();
        GenChart.makeASeries(3, ss, ZoneId.systemDefault(), new SimpleDateFormat("MMM d, yyyy"), countryRecord, jjj, 0, 'A', haha);
        for (int i = 0; i < haha.getData().size(); i++) {
        	assertEquals(haha.getData().get(i).getYValue(),((ConfirmedCases)countryRecord.records.get(location).get(i)).getCaseNumberPerMdouble());
        	
        }
        XYChart.Series<String, Number> haha1 = new XYChart.Series<String, Number>();
        GenChart.makeASeries(3, s, ZoneId.systemDefault(), new SimpleDateFormat("MMM d, yyyy"), countryRecord1, jjj, 0, 'B', haha1);
        for (int i = 0; i < haha1.getData().size(); i++) {
        	assertEquals(haha1.getData().get(i).getYValue(),((ConfirmedDeaths)countryRecord1.records.get(location).get(i)).getDeathNumberPerMdouble());
        	
        }
        XYChart.Series<String, Number> haha2 = new XYChart.Series<String, Number>();
        GenChart.makeASeries(3, s, ZoneId.systemDefault(), new SimpleDateFormat("MMM d, yyyy"), countryRecord2, jjj, 0, 'C', haha2);
        for (int i = 0; i < haha2.getData().size(); i++) {
        	assertEquals(haha2.getData().get(i).getYValue(),((VaccinationRate)countryRecord2.records.get(location).get(i)).getVaccinationRatedouble());
        	
        }
        XYChart.Series<String, Number> Range = new XYChart.Series<String, Number>();
        GenChart.makeASeries(3, s, ZoneId.systemDefault(), new SimpleDateFormat("MMM d, yyyy"), null, null, 0, 'R', Range);
        for (int i = 0; i < Range.getData().size(); i++) {
        	assertEquals(Range.getData().get(i).getYValue(),0);
        	
        }
       
        
	}
	
	
	@Test
	public void checkUpdateCountry() {

		String tableADataset = "1";
		String tableBDataset = "2";
		String tableCDataset = "3";
		String chartADataset = "4";
		String chartBDataset = "5";
		String chartCDataset = "6";
		String data1 = UpdateCountry.getDataSet(true, false, false, false, false,
				tableADataset, tableBDataset, tableCDataset,
				chartADataset, chartBDataset, chartCDataset);
		assertEquals(data1, "1");
		String data2 = UpdateCountry.getDataSet(false, true, false, false, false,
				tableADataset, tableBDataset, tableCDataset,
				chartADataset, chartBDataset, chartCDataset);
		assertEquals(data2, "2");
		String data3 = UpdateCountry.getDataSet(false, false, true, false, false,
				tableADataset, tableBDataset, tableCDataset,
				chartADataset, chartBDataset, chartCDataset);
		assertEquals(data3, "3");
		String data4 = UpdateCountry.getDataSet(false, false, false, true, false,
				tableADataset, tableBDataset, tableCDataset,
				chartADataset, chartBDataset, chartCDataset);
		assertEquals(data4, "4");
		String data5 = UpdateCountry.getDataSet(false, false, false, false, true,
				tableADataset, tableBDataset, tableCDataset,
				chartADataset, chartBDataset, chartCDataset);
		assertEquals(data5, "5");
		String data6 = UpdateCountry.getDataSet(false, false, false, false, false,
				tableADataset, tableBDataset, tableCDataset,
				chartADataset, chartBDataset, chartCDataset);
		assertEquals(data6, "6");
	}
	
	
	
	
	@Test
	public void sortTableViewCountry() {
		SingleRecord j = new SingleRecord(LocalDate.of(2020, 2, 2), "Hong Kong", null);
		SingleRecord jj = new SingleRecord(LocalDate.of(2020, 2, 2), "Japan", null);
		List<SingleRecord> k = new ArrayList<SingleRecord>();
		k.add(j);
		k.add(jj);
		
		GenTable.sortDataByCountry(k, false);
		assertEquals(k.get(0).getCountryName(), "Japan");
		assertEquals(k.get(1).getCountryName(), "Hong Kong");
		
		GenTable.sortDataByCountry(k, true);
		assertEquals(k.get(0).getCountryName(), "Hong Kong");
		assertEquals(k.get(1).getCountryName(), "Japan");
		
	}
	
	@Test
	public void sortTableViewCase() {
		ConfirmedCases c = new ConfirmedCases(LocalDate.of(2020, 2, 2), 1, 1.0, "Hong Kong", null);
		ConfirmedCases cc = new ConfirmedCases(LocalDate.of(2020, 2, 2), 12, 22.0, "Hong Kong", null);
		List<SingleRecord> ccc = new ArrayList<SingleRecord>();
		ccc.add(c);
		ccc.add(cc);
		
		ConfirmedDeaths d = new ConfirmedDeaths(LocalDate.of(2020, 2, 2), 1, 1.0, "Hong Kong", null);
		ConfirmedDeaths dd = new ConfirmedDeaths(LocalDate.of(2020, 2, 2), 12, 22.0, "Hong Kong", null);
		List<SingleRecord> ddd = new ArrayList<SingleRecord>();
		ddd.add(d);
		ddd.add(dd);
		
		VaccinationRate v = new VaccinationRate(LocalDate.of(2020, 2, 2), 1, 1, "Hong Kong", null);
		VaccinationRate vv = new VaccinationRate(LocalDate.of(2020, 2, 2), 12, 120, "Hong Kong", null);
		VaccinationRate vvvv = new VaccinationRate(LocalDate.of(2020, 2, 2), 0, 0, "Hong Kong", null);
		List<SingleRecord> vvv = new ArrayList<SingleRecord>();
		vvv.add(v);
		vvv.add(vv);
		vvv.add(vvvv);
		
		
		GenTable.sortDataByCase(ccc, false, 'A');
		assertEquals(((ConfirmedCases)ccc.get(0)).getCaseNumberlong(), 12);
		assertEquals(((ConfirmedCases)ccc.get(1)).getCaseNumberlong(), 1);
		
		GenTable.sortDataByCase(ccc, true, 'A');
		assertEquals(((ConfirmedCases)ccc.get(0)).getCaseNumberlong(), 1);
		assertEquals(((ConfirmedCases)ccc.get(1)).getCaseNumberlong(), 12);
		
		GenTable.sortDataByCase(ccc, false, ' ');
		assertEquals(((ConfirmedCases)ccc.get(0)).getCaseNumberlong(), 1);
		assertEquals(((ConfirmedCases)ccc.get(1)).getCaseNumberlong(), 12);
		
		GenTable.sortDataByCasePM(ccc, false, 'A');
		assertEquals(((ConfirmedCases)ccc.get(0)).getCaseNumberPerMdouble(), 22.0, 0.0);
		assertEquals(((ConfirmedCases)ccc.get(1)).getCaseNumberPerMdouble(), 1.0, 0.0);
		
		GenTable.sortDataByCasePM(ccc, true, 'A');
		assertEquals(((ConfirmedCases)ccc.get(0)).getCaseNumberPerMdouble(), 1.0, 0.0);
		assertEquals(((ConfirmedCases)ccc.get(1)).getCaseNumberPerMdouble(), 22.0, 0.0);
		
		GenTable.sortDataByCasePM(ccc, true, ' ');
		assertEquals(((ConfirmedCases)ccc.get(0)).getCaseNumberPerMdouble(), 1.0, 0.0);
		assertEquals(((ConfirmedCases)ccc.get(1)).getCaseNumberPerMdouble(), 22.0, 0.0);
		
		
		GenTable.sortDataByCase(ddd, false, 'B');
		assertEquals(((ConfirmedDeaths)ddd.get(0)).getDeathNumberlong(), 12);
		assertEquals(((ConfirmedDeaths)ddd.get(1)).getDeathNumberlong(), 1);
		
		GenTable.sortDataByCase(ddd, true, 'B');
		assertEquals(((ConfirmedDeaths)ddd.get(0)).getDeathNumberlong(), 1);
		assertEquals(((ConfirmedDeaths)ddd.get(1)).getDeathNumberlong(), 12);
		
		GenTable.sortDataByCasePM(ddd, false, 'B');
		assertEquals(((ConfirmedDeaths)ddd.get(0)).getDeathNumberPerMdouble(), 22.0, 0.0);
		assertEquals(((ConfirmedDeaths)ddd.get(1)).getDeathNumberPerMdouble(), 1.0, 0.0);
		
		GenTable.sortDataByCasePM(ddd, true, 'B');
		assertEquals(((ConfirmedDeaths)ddd.get(0)).getDeathNumberPerMdouble(), 1.0, 0.0);
		assertEquals(((ConfirmedDeaths)ddd.get(1)).getDeathNumberPerMdouble(), 22.0, 0.0);
		
		
		GenTable.sortDataByCase(vvv, false, 'C');
		assertEquals(((VaccinationRate)vvv.get(0)).getVaccinatedNumberlong(), 12);
		assertEquals(((VaccinationRate)vvv.get(1)).getVaccinatedNumberlong(), 1);
		
		GenTable.sortDataByCase(vvv, true, 'C');
		assertEquals(((VaccinationRate)vvv.get(0)).getVaccinatedNumberlong(), 0);
		assertEquals(((VaccinationRate)vvv.get(1)).getVaccinatedNumberlong(), 1);
		
		GenTable.sortDataByCasePM(vvv, false, 'C');
		assertEquals(((VaccinationRate)vvv.get(0)).getVaccinationRatedouble(), 100.0, 0.0);
		assertEquals(((VaccinationRate)vvv.get(1)).getVaccinationRatedouble(), 10.0, 0.0);
		
		GenTable.sortDataByCasePM(vvv, true, 'C');
		assertEquals(((VaccinationRate)vvv.get(0)).getVaccinationRatedouble(), -1.0, 0.0);
		assertEquals(((VaccinationRate)vvv.get(1)).getVaccinationRatedouble(), 10.0, 0.0);
		
	}
	
	
	@Test
	public void getLocationCheck() {
		Map<String, String> locationsget = DataAnalysis.getAllLocation("testing.csv");
		Map<String, String> locations = new TreeMap<String, String>();
		
		locations.put("Hong Kong", "Hong Kong");
		locations.put("Japan", "Japan");
		
		assertTrue(locationsget.containsKey("Hong Kong"));
		assertTrue(locationsget.containsKey("Japan"));
	}
	
	@Test
	public void singleRecordtesting() {
		SingleRecord j = new SingleRecord(LocalDate.of(2020, 2, 2), "Hong Kong", null);
		SingleRecord jj = new SingleRecord(LocalDate.of(2020, 2, 2), "Hong Kong", LocalDate.of(2020, 2, 1));
		SingleRecord jjj = new SingleRecord(null, "", null);
		
		assertEquals(-1, j.compareTo(null));
		
		assertEquals(0, j.compareTo(jj));
		
		assertTrue(j.isActualDate());
		assertFalse(jj.isActualDate());
		
		assertEquals(null, jjj.getCountryName());
		assertEquals(null, jjj.getDate());
	}
	
	@Test
	public void checkFilePicker() {
		
		File file = new File("HI");
		File file1 = null;
		assertEquals(FilePicker.checkIfFile(file, "HI"), "HI");
		assertEquals(FilePicker.checkIfFile(file1, "NO"), "NO");
	}
	
	

	
}



