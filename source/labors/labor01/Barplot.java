package labors.labor01;

/**
 * @author LeeKrane
 */

public class Barplot {
	static String repeat (char c, int n) {
		StringBuilder repeatedCharacter = new StringBuilder();
		for (int i = 0; i < n; i++)
			repeatedCharacter.append(c);
		return repeatedCharacter.toString();
	}
	
	static String drawLabel (String label, int length) {
		if (label.length() > length)
			return label.substring(0, length);
		return label + repeat(' ', length - label.length());
	}
	
	static String drawBar (String label, int value) {
		if (value < 0 || value > 30)
			return null;
		String output = drawLabel(label, 8) + '|' + repeat('#', value);
		if (output.length() < 39)
			output += repeat(' ', 39 - output.length());
		return output + '|';
	}
	
	static String drawBar (String label, double value) {
		if (value < 0.0 || value > 1.0)
			return null;
		return drawBar(label, (int) Math.round(value * 30.0));
	}
}
