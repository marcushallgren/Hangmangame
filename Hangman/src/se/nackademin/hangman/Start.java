package se.nackademin.hangman;

public class Start {

	public static void main(String[] args) {
		Hangman hangman = new Hangman();

		if (hangman.guessLoop()) {
			System.out.println("congratulations");
		} else {
			System.out.println("NOOOB");
		}
	}

}
