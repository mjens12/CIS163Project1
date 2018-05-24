package project1;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class mainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private stopWatchGUIPanel p1;
	private stopWatchGUIPanel p2;
	private stopWatchGUIPanel p3;

	private JButton suspend;

	ButtonListener buttonListen = new ButtonListener();

	public static void main(String[] args) {
		JFrame frame = new JFrame("Stopwatches!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel panel = new mainPanel();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	public mainPanel() {

		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

		TitledBorder border1 = BorderFactory.createTitledBorder(loweredetched, "Stopwatch 1");
		TitledBorder border2 = BorderFactory.createTitledBorder(loweredetched, "Stopwatch 2");
		TitledBorder border3 = BorderFactory.createTitledBorder(loweredetched, "Stopwatch 3");

		p1 = new stopWatchGUIPanel();
		p2 = new stopWatchGUIPanel();
		p3 = new stopWatchGUIPanel();
		suspend = new JButton("SUSPEND");

		p1.setBorder(border1);
		p2.setBorder(border2);
		p3.setBorder(border3);

		setLayout(new GridBagLayout());
		GridBagConstraints position = new GridBagConstraints();

		suspend.addActionListener(buttonListen);
		position.gridx = 0;
		position.gridy = 0;
		position.insets = new Insets(10, 2, 2, 10);
		add(p1, position);

		position.gridx = 1;
		position.gridy = 0;
		add(p2, position);

		position.gridx = 2;
		position.gridy = 0;
		add(p3, position);

		position.gridx = 0;
		position.gridy = 1;
		position.ipady = 40;
		position.gridwidth = 3;
		position.fill = GridBagConstraints.HORIZONTAL;
		suspend.setBackground(Color.WHITE);
		add(suspend, position);
	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == suspend) {
				if (StopWatch.suspend == false) {
					StopWatch.suspend(true);
					p1.disableButtons(true);
					p2.disableButtons(true);
					p3.disableButtons(true);
				}

				else {
					StopWatch.suspend(false);
					p1.disableButtons(false);
					p2.disableButtons(false);
					p3.disableButtons(false);
				}
			}
		}
	}
}
