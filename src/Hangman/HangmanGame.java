package Hangman;

import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HangmanGame {
	JFrame HangmanFrame = new JFrame();
	JPanel HangmanPanel = new JPanel();
	JLabel Title = new JLabel();
	JLabel Lives = new JLabel();
	JLabel correct = new JLabel();
	JLabel words = new JLabel();
	String actualvalues = new String();
	String underscores = "_ _ _ _ _ _ _ _ _ _ _ _ _ _ _";
	int numberofwords;

	public static void main(String[] args) {
		HangmanGame HG = new HangmanGame();
		HG.Create();
		HG.Operation();
	}

	public void Create() {
		HangmanFrame.setVisible(true);
		HangmanFrame.add(HangmanPanel);
		HangmanFrame.setSize(200, 130);
		HangmanPanel.add(Title);
		Title.setText("Guess a letter.");
		HangmanPanel.add(words);
		words.setText(underscores);
		HangmanPanel.add(Lives);
		Lives.setText("You have lives left.");
		HangmanPanel.add(correct);
		correct.setText("You got words correct");
	}

	public void Operation() {
		String s = JOptionPane.showInputDialog("Give a number");
		numberofwords = Integer.parseInt(s);
		FileReader fr = new FileReader(src/Hangman/dictionary.txt); 
	}
}
