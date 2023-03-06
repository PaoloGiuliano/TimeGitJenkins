package time;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	@Test
	void testGetTotalSecondsGood() {
		int seconds = 
		Time.getTotalSeconds("05:05:05");
	
		assertTrue(seconds==18305, "The seconds were not calculated properly");
		
	}
	
	@Test
	void testGetTotalSecondsBad() {
		assertThrows(
		StringIndexOutOfBoundsException.class,
		()->{Time.getTotalSeconds("10:00");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "00:00:00",
	"23:59:59" })
	void testGetTotalSecondsBoundary() {
		
		
	}

	@Test
	void testGetSecondsGood() {
		int seconds = Time.getSeconds("10:09:08");
		assertTrue(seconds==8, "The seconds were not calculated correctly");
	}
	
	@Test
	void testGetSecondsBad() {
		assertThrows(
		NumberFormatException.class,
		()->{Time.getSeconds("10:09:ss");});
		
	}

	@Test
	void testGetTotalMinutesGood() {
		double minutes = Time.getTotalMinutes("10:15:11");
		assertTrue(minutes==15, "The minutes were not calculated correctly");
	}
	
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(
		StringIndexOutOfBoundsException.class,
		()->{Time.getTotalMinutes("10");});
	}
	
	

	@Test
	void testGetTotalHoursGood() {
		//fail("Not yet implemented");
	}
	
	@Test
	void testGetMilliseconds() {
		double milliseconds = Time.getMilliseconds("10:15:11:877");
		assertTrue(milliseconds==877, "The Milliseconds were not calculated correctly");
	}
	
	@Test
	void testGetTotalMilliseconds() {
		int totalMilliseconds = Time.getTotalMilliseconds("05:05:05:005");
		assertTrue(totalMilliseconds==18305005, "The total milliseconds were not calculated properly.");
	}

}
