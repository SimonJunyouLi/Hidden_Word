import java.util.*;
import javax.swing.*;

public class CQ_8 {
	private static Scanner sc;

	public static void getHint(String answer, String user) {
		String hint = "";
		boolean temp = true;
		
		if(answer.equals(user)) {
			JOptionPane.showMessageDialog(null, "You win!");
		}
		else {
			for(int i = 0; i < answer.length(); i++) {
				temp = true;
				if(answer.charAt(i) == user.charAt(i)) {
					hint += answer.charAt(i);
				}
				else {
					for(int k = 0; k < answer.length(); k++) {
						if(user.charAt(i) == answer.charAt(k)) {
							hint += "+";
							temp = false;
							break;
						}
					}
					if(temp) {
						hint += "*";
					}
				}
			}
			JOptionPane.showMessageDialog(null, hint);
		}
	}
	
	public static void main(String [] args) {
		setSc(new Scanner(System.in));
		
		JOptionPane.showMessageDialog(null, "If the letter in the guess is also in the same position in the hidden word,"
				+ " the corresponding character in the hint is the matching letter.");
		JOptionPane.showMessageDialog(null, "If the letter in the guess is also in the hidden word, but in a different position,"
				+ " the corresponding character in the hint is '+'.");
		JOptionPane.showMessageDialog(null, "If the letter in the guess is not in the hidden word,"
				+ " the corresponding character in the hint is '*'.");
		
		String base, guess;
		boolean gamestate = true;
		
		base = JOptionPane.showInputDialog("What's the hidden word?");
		guess = JOptionPane.showInputDialog("What's your guess?");
		while(guess != null && guess.length() != base.length()) {
			guess = JOptionPane.showInputDialog("What's your guess?");
		}
		
		while(gamestate) {
			getHint(base,guess);
			if(base.equals(guess)) {
				System.exit(0);
			}
			guess = JOptionPane.showInputDialog("What's your guess?");
		}
	}

	public static Scanner getSc() {
		return sc;
	}

	public static void setSc(Scanner sc) {
		CQ_8.sc = sc;
	}
}
