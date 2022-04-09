package comp3111.covid;

import java.io.File;
import java.nio.file.Paths;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * a class to get the file name of user's choice
 * 
 *
 */
public class FilePicker {
	
	/**
	 * a method to get the name of the file chosen
	 * @param oldName the String that was in the textfield
	 * @return file name in string
	 */
	public static String filePickingName(String oldName) {
		FileChooser fc = new FileChooser();
    	fc.setTitle("File Chooser");
    	fc.getExtensionFilters().add(new ExtensionFilter("CSV Files", "*.csv"));
    	fc.setInitialDirectory(Paths.get("").toAbsolutePath().toFile());
    	File file = fc.showOpenDialog(null);
    	return checkIfFile(file, oldName);
	}
	
	/**
	 * to check if the user has selected a file
	 * @param file the file selected
	 * @param oldName the String that was in the textfield
	 * @return name of the file 
	 */
	public static String checkIfFile(File file, String oldName) {
		if (file != null)
    		return file.getName();
    	else
    		return oldName;
	}
}
