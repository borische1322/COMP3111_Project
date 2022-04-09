package comp3111.covid;

import java.io.File;

/**
 * A class to check the given data file name exist or not to update the list of countries for users to select
 * @author User
 *
 */
public class UpdateCountry {
	
	/**
	 * to get the filename of the dataset
	 * @param tabReport1 boolean value of whether tab 1 is selected
	 * @param tabReport2 boolean value of whether tab 2 is selected
	 * @param tabReport3 boolean value of whether tab 3 is selected
	 * @param tabApp1 boolean value of whether tab 4 is selected
	 * @param tabApp2 boolean value of whether tab 5 is selected
	 * @param tableADataset dataset file name in tab 1
	 * @param tableBDataset dataset file name in tab 2
	 * @param tableCDataset dataset file name in tab 3
	 * @param chartADataset dataset file name in tab 4
	 * @param chartBDataset dataset file name in tab 5
	 * @param chartCDataset dataset file name in tab 6
	 * @return String of the file name
	 */
	public static String getDataSet(Boolean tabReport1, Boolean tabReport2, Boolean tabReport3, Boolean tabApp1, Boolean tabApp2,
									String tableADataset, String tableBDataset, String tableCDataset,
									String chartADataset, String chartBDataset, String chartCDataset) {
		if (tabReport1) {
    		return tableADataset;
    	}
    	else if (tabReport2) {
    		return tableBDataset;
    	}
    	else if (tabReport3) {
    		return tableCDataset;
    	}
    	else if (tabApp1) {
    		return chartADataset;
    	}
    	else if (tabApp2) {
    		return chartBDataset;
    	}
    	else {
    		return chartCDataset;
    	}
	}
	
	/**
	 * This function check if the dataset input exists
	 * @param dataset the path (with name) of the csv file to be checked
	 * @return a boolean showing true if the file exists, and false if not
	 */
	public static boolean checkFileExist(String dataset) {
		File tempFile = new File(dataset);
		return tempFile.exists();
	}
}
