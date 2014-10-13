package se.nackademin.hangman;

import java.util.Scanner;

public class Hangman {
	public enum GuessResult {
		COMPLETE_DOMINATION, ONE_CHAR_SUCCESS, INCORRECT_SUPERNOOB
	}

	private final Scanner input = new Scanner(System.in);
	private String secret;
	private char[] result;
	private final String[] words = new String[5];
	{
		words[0] = "java";
		words[1] = "nackademin";
		words[2] = "programmering";
		words[3] = "hacker";
		words[4] = "nerd";
	}

	public String secretWord() {
		return words[(int) (Math.random() * words.length)];

	}

	public char[] wordToChars(String word) {
		char[] y = word.toCharArray();
		return y;
	}

	public char[] copyChars() {
		char[] blankWord = new char[secret.length()];
		for (int i = 0; i < blankWord.length; i++) {
			blankWord[i] = '_';
		}
		return blankWord;
	}

	public boolean guessLoop() {
		secret = secretWord();
		result = copyChars();
		int errorCount = 0;
		while (errorCount < 3) {
			switch (userGuess()) {
			case ONE_CHAR_SUCCESS:
				continue;
			case INCORRECT_SUPERNOOB:
				errorCount++;
				if (errorCount < 3)
					System.out.format("FAIL! you only have %d lives left%n",
							3 - errorCount);
				break;
			case COMPLETE_DOMINATION:
				return true;

			}
		}
		return false;
	}

	private char readChar() {
		while (true) {
			System.out.println("Guess a tecken");
			String guess = input.next();

			if (guess.length() == 1) {
				return guess.charAt(0);
			}
			System.out.println("Please enter 1 character only");
		}
	}

	private GuessResult userGuess() {
		char guess = readChar();
		int len = secret.length();
		for (int i = 0; i < len; i++) {
			if (guess == secret.charAt(i)) {
				result[i] = guess;
				System.out.println(result);
				for (int b = 0; b < len; b++) {
					if (result[b] == '_')
						return GuessResult.ONE_CHAR_SUCCESS;
				}
				return GuessResult.COMPLETE_DOMINATION;
			}
		}

		return GuessResult.INCORRECT_SUPERNOOB;
	}

}
