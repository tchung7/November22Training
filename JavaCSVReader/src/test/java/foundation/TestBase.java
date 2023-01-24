package foundation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.BeforeSuite;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public abstract class TestBase {
	protected CSVReader reader;
	protected HashMap<String, String> map = new HashMap<String, String>();

	@BeforeSuite
	public void setup() throws FileNotFoundException {
		File csv = new File("src\\test\\resources\\9_basses.csv");
		String[] line;

		if (csv.exists()) {
			this.reader = new CSVReader(new FileReader(csv));
		}
		try {
			while ((line = reader.readNext()) != null) {
				map.put(line[1], line[0]);
			}
		} catch (IOException | CsvValidationException e) {
			e.printStackTrace();
		}
	}

	public void makeCSV() {
		String[] line;
		try {
			while ((line = reader.readNext()) != null) {
				map.put(line[1], line[2]);
			}
		} catch (IOException | CsvValidationException e) {
			e.printStackTrace();
		}
	}
}
