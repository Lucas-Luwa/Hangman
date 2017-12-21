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
	String actualvalues = new String();
	String underscores = "_ _ _ _ _ _ _ _ _ _ _ _ _ _ _";
	int numberofwords;
	Stack<String> wordSTK = new Stack<String>();

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
		HangmanFrame.addKeyListener(this);
	}

	public void Operation() {
		String s = JOptionPane.showInputDialog("Give a number");
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

	// use char c = e.getkeychar();
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

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