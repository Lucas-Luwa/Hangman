package Hangman;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HangmanGame {
	JFrame HangmanFrame = new JFrame();
	JPanel HangmanPanel = new JPanel();

	public static void main(String[] args) {
HangmanGame HG = new HangmanGame();
HG.Create();
	}
	
	public void Create(){
	HangmanFrame.setVisible(true);	
	HangmanFrame.add(HangmanPanel);
	HangmanFrame.setSize(300, 300);

	}
}
