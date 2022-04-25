package com.bhavna.main;

import java.util.Scanner;

import com.bhavna.game.GameManager;

public class Main {
	public static void main(String[] args) {
		System.out.println("Starting Game!");
	    GameManager.generatePatternForHidder();
	    System.out.println("pattern was created");
	    System.out.println(" You have 8 chances");
	    System.out.println(" a pattern should be of 4 colors (the pattern is:blue:b,white:w,red:r,green:g)");
	    Scanner sc = new Scanner(System.in);
	   
	    boolean gameLost = true;
		for(int i= 0; i< 8; i++) {	
			System.out.println("Enter your guess...");
			String guess= sc.nextLine();
			
			if(GameManager.validateGuess(guess))
			{
				int[] output = GameManager.evaluateGuess(guess);
				if(output[0] == 4) {
					System.out.println("You won the game!");
					gameLost = false;
					break;		
					
				}
				 System.out.println("position "+output[0]+ "\tcolorOnly"+output[1]);
			   
			}
			
		}
		if(gameLost) {
			System.out.println("you lost the game!");
		}
		
		
	}
	

}
