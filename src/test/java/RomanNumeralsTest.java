import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;


public class RomanNumeralsTest {
	
	public static class RomanNumerals {

		public static String convert(int number) {
			StringBuilder builder = new StringBuilder();
//			if(number > 3) 
			if(number % 5 == 0) return "V";
			for (int i = 0; i < number; i++) builder.append("I");
			return builder.toString();
		}
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
	public void four() throws Exception {
		assertThat("IV", is(RomanNumerals.convert(4)));
	}
}
