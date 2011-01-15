import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;


public class RomanNumeralsTest {
	
	public static class RomanNumerals {

		public static String convert(int number) {
			
			if(number == 4) return "IV";
			
			if(number >= 10) {
				int rest = number - 10;
				return "X" + convert(rest);
			}
			
			if(number >= 5){
				int rest = number - 5;
				return (rest > 3 ) ? "IX" : "V" + convert(rest);
			}
			
			StringBuilder builder = new StringBuilder();
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
}
