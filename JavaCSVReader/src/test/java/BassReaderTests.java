import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import CSVExtension.Bass;
import foundation.TestBase;

public class BassReaderTests extends TestBase {
	ArrayList<Bass> basses = new ArrayList<Bass>();

	@Test
	public void ensureCorvetteIsReadCorrectly() {
		Bass Corvette = new Bass();
		Corvette.setMake(map.get("Corvette"));

		var expected = "Warwick";
		var actual = Corvette.getMake();

		assertEquals(actual, expected, "Warwick should be returned");

		basses.add(Corvette);
	}

	@Test
	public void ensureThumbIsReadCorrectly() {
		Bass Thumb = new Bass();
		Thumb.setMake(map.get("Thumb"));

		var expected = "Warwick";
		var actual = Thumb.getMake();

		assertEquals(actual, expected, "Warwick should be returned");

		basses.add(Thumb);
	}

	@Test
	public void ensureStreamerIsReadCorrectly() {
		Bass Streamer = new Bass();
		Streamer.setMake(map.get("Streamer"));

		var expected = "Warwick";
		var actual = Streamer.getMake();

		assertEquals(actual, expected, "Warwick should be returned");

		basses.add(Streamer);
	}

	@Test
	public void ensurePrecisionIsReadCorrectly() {
		Bass Precision = new Bass();
		Precision.setMake(map.get("Precision"));

		var expected = "Fender";
		var actual = Precision.getMake();

		assertEquals(actual, expected, "Fender should be returned");

		basses.add(Precision);
	}

	@Test
	public void ensureJazzIsReadCorrectly() {
		Bass Jazz = new Bass();
		Jazz.setMake(map.get("Jazz"));

		var expected = "Fender";
		var actual = Jazz.getMake();

		assertEquals(actual, expected, "Fender should be returned");

		basses.add(Jazz);
	}

	@Test
	public void ensureBB500IsReadCorrectly() {
		Bass BB500 = new Bass();
		BB500.setMake(map.get("BB500"));

		var expected = "Yamaha";
		var actual = BB500.getMake();

		assertEquals(actual, expected, "Yamaha should be returned");

		basses.add(BB500);
	}
}
