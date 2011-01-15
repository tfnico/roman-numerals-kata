import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;


public class RomanNumeralsTest {
	
	@Test
	public void forty() {
		assertThat("XL", is(RomanNumerals.convert(40)));
	}

	@Test
	public void one() {
		assertThat("I", is(RomanNumerals.convert(1)));
	}
	
	@Test
	public void two() throws Exception {
		assertThat("II", is(RomanNumerals.convert(2)));
	}
	
	@Test
	public void five() {
		assertThat("V", is(RomanNumerals.convert(5)));
	}
	
	@Test
	public void four() {
		assertThat("IV", is(RomanNumerals.convert(4)));
	}
	
	@Test
	public void six() {
		assertThat("VI", is(RomanNumerals.convert(6)));
	}
	
	@Test
	public void nine() {
		assertThat("IX", is(RomanNumerals.convert(9)));
	}
	
	@Test
	public void ten() {
		assertThat("X", is(RomanNumerals.convert(10)));
	}
	
	@Test
	public void fourteen() {
		assertThat("XIV", is(RomanNumerals.convert(14)));
	}
	
	@Test
	public void thirtyNine() {
		assertThat("XXXIX", is(RomanNumerals.convert(39)));
	}
	
	
}
