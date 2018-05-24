package project1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class mainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private stopWatchGUIPanel p1;
	private stopWatchGUIPanel p2;
	private stopWatchGUIPanel p3;

	private JButton suspend;

	ButtonListener buttonListen = new ButtonListener();

	public mainPanel() {

		p1 = new stopWatchGUIPanel();
		p2 = new stopWatchGUIPanel();
		p3 = new stopWatchGUIPanel();
		suspend = new JButton("SUSPEND");

		suspend.addActionListener(buttonListen);

		add(p1);
		add(p2);
		add(p3);
		add(suspend);
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
