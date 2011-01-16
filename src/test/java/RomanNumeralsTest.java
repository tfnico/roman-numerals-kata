import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;


public class RomanNumeralsTest {

    public static class RomanNumerals {

    	enum Numeral{
    		M(1000),
    		D(500),
    		C(100),
    		L(50),
    		X(10),
    		V(5),
    		I(1);
    		
    		private int arab;
    		
    		private Numeral(int arab) {
    		    this.arab = arab;
    		}
    	}
    	// number = 5
    	// numeral = X
    	// arab = 10
    	// if(5 >= 10) return X + convert(5 - 10)
    	// nextNumeral = V
    	// if (5 >= 10 - 5) return V + X
    	//  
    	//
        public static String convert(int number) {
            if(number == 0) return "";
        	for(Numeral numeral:Numeral.values()){
        		int arab = numeral.arab;
                if(number >= arab)
        		    return numeral.toString() + convert(number - arab);
                Numeral nextNumeral = nextNumeral(numeral);
                if (nextNumeral != null && number >= arab - nextNumeral.arab)
                    return nextNumeral.toString() + numeral.toString();
                
        	}
        	throw new IllegalStateException("Should not be able to get this far.");
        }

        // TODO: Should be private.
        static Numeral nextNumeral(Numeral numeral) {
        	if(Numeral.I.equals(numeral)) return null;
        	return Numeral.values()[numeral.ordinal() + 1];
        }
    }

    @Test
    public void nextNumeralAfterIShouldReturnNull() {
        assertNull(RomanNumerals.nextNumeral(RomanNumerals.Numeral.I));
    }

    @Test
    public void nextNumeralAfterVShouldBeI() {
        assertThat(RomanNumerals.Numeral.I, is(RomanNumerals.nextNumeral(RomanNumerals.Numeral.V)));
    }

    @Test
    public void nextNumeralAfterMShouldBeD() {
        assertThat(RomanNumerals.Numeral.D, is(RomanNumerals.nextNumeral(RomanNumerals.Numeral.M)));
    }

    @Test
    public void threeThousandNineHundredAndNinetyNine() {
        assertRomanNumeralEquals("MMMCMXCIX", 3999);
    }

    @Test
    public void oneThousand() {
        assertRomanNumeralEquals("M", 1000);
    }

    @Test
    public void nineHundred() {
        assertRomanNumeralEquals("CM", 900);
    }

    @Test
    public void fiveHundred() {
        assertRomanNumeralEquals("D", 500);
    }

    @Test
    public void fourHundred() {
        assertRomanNumeralEquals("CD", 400);
    }

    @Test
    public void threeHundredAndNinetyNine() {
        assertRomanNumeralEquals("CCCXCIX", 399);
    }

    @Test
    public void ninety() {
        assertRomanNumeralEquals("XC", 90);
    }

    @Test
    public void eightyNine() {
        assertRomanNumeralEquals("LXXXIX", 89);
    }

    @Test
    public void sixty() {
        assertRomanNumeralEquals("LX", 60);
    }

	@Test
	public void fifty() {
		assertRomanNumeralEquals("L", 50);
	}
	
	@Test
	public void forty() {
		assertRomanNumeralEquals("XL", 40);
	}
	
	@Test
	public void fourtyOne() {
		assertRomanNumeralEquals("XLI", 41);
	}
	
	@Test
	public void one() {
		assertRomanNumeralEquals("I", 1);
	}
	
	@Test
	public void two() throws Exception {
		assertRomanNumeralEquals("II", 2);
	}
	
	@Test
	public void five() {
		assertRomanNumeralEquals("V", 5);
	}
	
	@Test
	public void four() {
		assertRomanNumeralEquals("IV", 4);
	}
	
	@Test
	public void six() {
		assertRomanNumeralEquals("VI", 6);
	}
	
	@Test
	public void nine() {
		assertRomanNumeralEquals("IX", 9);
	}
	
	@Test
	public void ten() {
		assertRomanNumeralEquals("X", 10);
	}
	
	@Test
	public void fourteen() {
		assertRomanNumeralEquals("XIV", 14);
	}
	
	@Test
	public void thirtyNine() {
		assertRomanNumeralEquals("XXXIX", 39);
	}

    private static void assertRomanNumeralEquals(String roman, int arab) {
        assertThat(roman, is(RomanNumerals.convert(arab)));
    }
	
}
