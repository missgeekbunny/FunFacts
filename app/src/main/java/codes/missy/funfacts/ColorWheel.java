package codes.missy.funfacts;

import android.graphics.Color;

import java.util.Random;

public class ColorWheel {
	private String[] mColors = {
			"#0B82C3",
			"#072E44",
			"#770108",
			"#AA3C12",
			"#8E0652",
			"#800584",
			"#8E2C32",
			"#C33C44",
			"#01771E",
			"#770108",
			"#370004",
			"#333333",
			"#222222"
	};
	// Methods - Actions the object can take.
	public int getColor() {
		String color;
		// Randomly select a color
		Random randomGenerator = new Random();
		int randomNumber = randomGenerator.nextInt(mColors.length);
		color = mColors[randomNumber];
		int colorAsInt = Color.parseColor(color);
		return colorAsInt;
	}
}
