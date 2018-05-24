package project1;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class stopWatchGUIPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private StopWatch stopWatchTimer;
	private Timer javaTimer;
	private TimerListener timer;

	private JButton load;
	private JButton save;
	private JButton start;
	private JButton stop;
	private JButton sub;
	private JButton add;
	private JButton inc;
	private JButton dec;
	private JButton reset;

	private JTextField min;
	private JTextField sec;
	private JTextField milli;

	private JLabel minLabel;
	private JLabel secLabel;
	private JLabel milliLabel;

	private JLabel time;

	final JFileChooser fc = new JFileChooser();

	public stopWatchGUIPanel() {
		stopWatchTimer = new StopWatch(0, 0, 0);

		setLayout(new GridBagLayout());
		GridBagConstraints position = new GridBagConstraints();

		ButtonListener buttonListen = new ButtonListener();

		timer = new TimerListener();
		javaTimer = new Timer(100, timer);

		time = new JLabel();
		time.setFont(new Font("Serif", Font.BOLD, 18));
		time.setText(stopWatchTimer.toString());

		load = new JButton("load");
		save = new JButton("save");
		start = new JButton("start");
		stop = new JButton("stop");
		sub = new JButton("sub");
		add = new JButton("add");
		inc = new JButton("inc");
		dec = new JButton("dec");
		reset = new JButton("reset");

		min = new JTextField("0");
		sec = new JTextField("0");
		milli = new JTextField("0");

		minLabel = new JLabel();
		minLabel.setText("Minutes");
		secLabel = new JLabel();
		secLabel.setText("Seconds");
		milliLabel = new JLabel();
		milliLabel.setText("Milliseconds");

		load.addActionListener(buttonListen);
		save.addActionListener(buttonListen);
		start.addActionListener(buttonListen);
		stop.addActionListener(buttonListen);
		sub.addActionListener(buttonListen);
		add.addActionListener(buttonListen);
		inc.addActionListener(buttonListen);
		dec.addActionListener(buttonListen);
		reset.addActionListener(buttonListen);

		position.ipady = 10;
		position.ipadx = 10;
		position.gridx = 4;
		position.gridy = 0;
		add(load, position);

		position.gridx = 0;
		position.gridy = 0;
		add(save, position);

		position.insets = new Insets(10, 10, 10, 10);
		position.gridx = 1;
		position.gridy = 3;
		position.ipady = 30;
		position.ipadx = 30;
		start.setBackground(Color.GREEN);
		add(start, position);

		position.gridx = 3;
		position.gridy = 3;
		position.ipady = 30;
		position.ipadx = 30;
		stop.setBackground(Color.RED);
		add(stop, position);

		position.insets = new Insets(0, 0, 0, 0);
		position.ipady = 10;
		position.ipadx = 10;
		position.gridx = 4;
		position.gridy = 2;
		add(sub, position);

		position.gridx = 0;
		position.gridy = 2;
		add(add, position);

		position.gridx = 0;
		position.gridy = 3;
		add(inc, position);

		position.gridx = 4;
		position.gridy = 3;
		add(dec, position);

		position.insets = new Insets(0, 0, 20, 0);
		position.gridx = 4;
		position.gridy = 1;
		reset.setBackground(Color.GRAY);
		add(reset, position);

		position.ipady = 10;
		position.ipadx = 50;
		position.gridx = 1;
		position.gridy = 1;
		add(min, position);

		position.gridx = 2;
		position.gridy = 1;
		add(sec, position);

		position.gridx = 3;
		position.gridy = 1;
		add(milli, position);

		position.insets = new Insets(0, 50, 0, 0);
		position.gridx = 1;
		position.gridy = 2;
		add(minLabel, position);

		position.gridx = 2;
		position.gridy = 2;
		add(secLabel, position);

		position.gridx = 3;
		position.gridy = 2;
		add(milliLabel, position);

		position.gridx = 1;
		position.gridy = 0;
		position.ipady = 40;
		position.gridwidth = 3;
		add(time, position);
	}

	public void disableButtons(boolean disable) {
		if (disable) {
			start.setEnabled(false);
			stop.setEnabled(false);
			sub.setEnabled(false);
			add.setEnabled(false);
			inc.setEnabled(false);
			dec.setEnabled(false);
			reset.setEnabled(false);
			load.setEnabled(false);
		} else {
			start.setEnabled(true);
			stop.setEnabled(true);
			sub.setEnabled(true);
			add.setEnabled(true);
			inc.setEnabled(true);
			dec.setEnabled(true);
			reset.setEnabled(true);
			load.setEnabled(true);
		}
	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == load) {
				JFileChooser chooser = new JFileChooser();
				JTextArea ta = new JTextArea(20, 30);

				int status = chooser.showOpenDialog(null);

				if (status != JFileChooser.APPROVE_OPTION)
					ta.setText("No File Chosen");

				else {
					File file = chooser.getSelectedFile();
					stopWatchTimer.load(file.getAbsolutePath());
					time.setText(stopWatchTimer.toString());
				}
			}

			if (event.getSource() == save) {
				JFileChooser chooser = new JFileChooser();
				JTextArea ta = new JTextArea(20, 30);

				int status = chooser.showOpenDialog(null);

				if (status != JFileChooser.APPROVE_OPTION)
					ta.setText("No File Chosen");

				else {
					File file = chooser.getSelectedFile();
					stopWatchTimer.save(file.getAbsolutePath());
				}
			}

			if (event.getSource() == start) {
				javaTimer.start();
			}

			if (event.getSource() == stop)
				javaTimer.stop();

			if (event.getSource() == sub) {
				try {
					StopWatch temp = new StopWatch("" + min.getText() + ":" + sec.getText() + ":" + milli.getText());

					stopWatchTimer.sub(temp);
					time.setText(stopWatchTimer.toString());
				}

				catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null,
							"Please enter a valid number to proceed. Negative, alpha values, "
									+ "second numbers above 59, milliseconds numbers above 999, "
									+ "and numbers that would reduce the time on the stopwatch "
									+ "below zero are invalid.");
				}
			}

			if (event.getSource() == add) {
				try {
					StopWatch temp = new StopWatch("" + min.getText() + ":" + sec.getText() + ":" + milli.getText());
					stopWatchTimer.add(temp);
					time.setText(stopWatchTimer.toString());
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null,
							"Please enter a valid number to proceed. Negative, alpha values, "
									+ "second numbers above 59, milliseconds numbers above 999, "
									+ "and numbers that would reduce the time on the stopwatch "
									+ "below zero are invalid.");
				}
			}

			if (event.getSource() == inc) {
				stopWatchTimer.inc();
				time.setText(stopWatchTimer.toString());
			}

			if (event.getSource() == dec) {
				try {
					stopWatchTimer.dec();
					time.setText(stopWatchTimer.toString());
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null, "You can't decrease the timer below zero!");
				}
			}

			if (event.getSource() == reset) {
				stopWatchTimer.reset();
				time.setText(stopWatchTimer.toString());
			}
		}
	}

	private class TimerListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			stopWatchTimer.add(100);
			time.setText(stopWatchTimer.toString());
		}
	}
}
