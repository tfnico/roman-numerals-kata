import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;


public class RomanNumeralsTest {

    public static class RomanNumerals {

    	enum Numeral{
    		C(100),
    		XC(90),
    		L(50),
    		XL(40),
    		X(10),
    		IX(9),
    		V(5),
    		IV(4),
    		I(1);
    		
    		private int arab;
    		
    		private Numeral(int arab) {
    		    this.arab = arab;
    		}
    	}
    	
        public static String convert(int number) {
            if(number == 0) return "";
        	for(Numeral numeral:Numeral.values()){
        		int arab = numeral.arab;
                if(number >= arab)
        		    return numeral.toString() + convert(number - arab);
        	}
        	throw new IllegalStateException("Should not be able to get this far.");
        }
    }

    @Test
    public void threeHundredAndNinetyNine() {
        assertThat("CCCXCIX", is(RomanNumerals.convert(399)));
    }

    @Test
    public void ninety() {
        assertThat("XC", is(RomanNumerals.convert(90)));
    }

    @Test
    public void eightyNine() {
        assertThat("LXXXIX", is(RomanNumerals.convert(89)));
    }

    @Test
    public void sixty() {
        assertThat("LX", is(RomanNumerals.convert(60)));
    }

	@Test
	public void fifty() {
		assertThat("L", is(RomanNumerals.convert(50)));
	}
	
	@Test
	public void forty() {
		assertThat("XL", is(RomanNumerals.convert(40)));
	}
	
	@Test
	public void fourtyOne() {
		assertThat("XLI", is(RomanNumerals.convert(41)));
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
