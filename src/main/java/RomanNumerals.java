
public class RomanNumerals {

	public static String convert(int number) {
		
		if(number == 4) return "IV";
		
		if(number >= 40) {
			int rest = number - 40;
			return "XL" + convert(rest);
		}
		
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