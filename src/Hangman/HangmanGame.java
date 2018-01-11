package Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangmanGame implements KeyListener {
	JFrame HangmanFrame = new JFrame();
	JPanel HangmanPanel = new JPanel();
	JLabel Title = new JLabel();
	JLabel Lives = new JLabel();
	JLabel correct = new JLabel();
	JLabel words = new JLabel();
	String underscores = "";
	int numberofwords;

	String y;
	int lives = 9;
	int WINS = 0;
	Stack<String> wordSTK = new Stack<String>();

	public static void main(String[] args) {
		HangmanGame HG = new HangmanGame();
		JOptionPane.showMessageDialog(null, "Hangman! Don't use Caps. Good Luck!");
		HG.Create();
		HG.Operation();
		HG.Run();
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
		Lives.setText("You have " + lives + " lives left.");
		HangmanPanel.add(correct);
		correct.setText("You got words correct");
		HangmanFrame.addKeyListener(this);
	}

	public void Operation() {
		String s = JOptionPane.showInputDialog("How many words would you like?");
		numberofwords = Integer.parseInt(s);
		for (int i = 0; i < numberofwords; i++) {
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader("src/dictionary.txt"));
				int random = new Random().nextInt(3000);
				for (int j = 0; j < random; j++) {
					br.readLine();
				}
				String word = br.readLine();
				if (wordSTK.contains(word)) {
					i -= 1;
				} else {
					wordSTK.push(word);
				}
				br.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(wordSTK);
	}

	public void Run() {
		lives = 9;
		Lives.setText("You have " + lives + " lives left.");
		y = wordSTK.pop();
		y.toLowerCase();
		int lengthofword = y.length();
		for (int i = 0; i < lengthofword; i++) {
			underscores += "_";
			words.setText(underscores);

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		String temp = "";
		int i;
		// TODO Auto-generated method stub
		for (i = 0; i < y.length(); i++) {

			if (e.getKeyChar() == y.charAt(i)) {
				temp += y.charAt(i);
			} else {
				// System.out.println(temp);
				temp += underscores.charAt(i);

			}
		}

		// System.out.println(temp);
		// System.out.println(underscores);
		// System.out.println(lives);
		underscores = temp;
		words.setText(underscores);
		if (underscores.contains("" + e.getKeyChar())) {

		} else {
			lives -= 1;
			Lives.setText("You have " + lives + " lives left.");
			if (lives == 0) {
				HangmanFrame.dispose();
				JOptionPane.showMessageDialog(null, "Game Over.");
				JOptionPane.showMessageDialog(null, "The word was " + y);
			}
		}
		if (underscores.equals(y)) {

			underscores = "";
			words.setText("");
			WINS += 1;

			if (WINS == numberofwords) {
				HangmanFrame.dispose();
				JOptionPane.showMessageDialog(null, "Congrats! You solved " + numberofwords + " words!");
			} else {
				Run();
				lives = 9;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}