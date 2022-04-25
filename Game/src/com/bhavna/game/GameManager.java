package com.bhavna.game;

import java.util.Random;


public class GameManager {
	private static final char Yellow = 'Y';
	private static final char Blue = 'B';
	private static final char White = 'W';
	private static final char Green = 'G';
	private static Character[] colors = { Yellow, Blue, White, Green };
	

	static String hiddenPattern;

	public static boolean validateGuess(String s) {
		if (s.length() != 4) {
			System.out.println("Guess should be of length 4");
			return false;
		}
		if (!s.matches("^[YBWG]+$")) {
			System.out.println("Please enter correct guess");
			return false;
		}

		return true;

	}

	public static int[] evaluateGuess(String guess) {
		int position = 0, color = 0;
		for (int i = 0; i < 4; i++) {
		   if (hiddenPattern.charAt(i) == guess.charAt(i)) position++;
 		}
		
		StringBuffer guessbf = new StringBuffer(guess);
 		for (int i = 0; i < 4; i++) {
			for (int j = 0 ; j < 4; j++) {
				if (hiddenPattern.charAt(i) == guessbf.charAt(j)) {
					color++;	
					guessbf.setCharAt(j, '-');
					break;
			    }
			}
			//System.out.println(guessbf + " "+color);
		}
		return new int[] { position, color-position };

	}

	public static void generatePatternForHidder() {
		String pattern = "";
		for (int i = 0; i < 4; i++) {
			pattern += colors[new Random().nextInt(colors.length)];
		}
		hiddenPattern = pattern;
		//System.out.println("HiddenPattern " +pattern);

	}

}
