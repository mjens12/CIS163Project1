package project1;

import javax.swing.JFrame;

public class stopWatchGUI {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Stopwatches!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel panel = new mainPanel();
		frame.getContentPane().add(panel);
		frame.setSize(700, 350);
		frame.pack();
		frame.setVisible(true);
	}
}
