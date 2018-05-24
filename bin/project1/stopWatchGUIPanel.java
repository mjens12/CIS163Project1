package project1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

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

		ButtonListener buttonListen = new ButtonListener();

		timer = new TimerListener();
		javaTimer = new Timer(100, timer);

		time = new JLabel();
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

		setLayout(new GridLayout(6, 2));

		load.addActionListener(buttonListen);
		save.addActionListener(buttonListen);
		start.addActionListener(buttonListen);
		stop.addActionListener(buttonListen);
		sub.addActionListener(buttonListen);
		add.addActionListener(buttonListen);
		inc.addActionListener(buttonListen);
		dec.addActionListener(buttonListen);
		reset.addActionListener(buttonListen);

		add(load);
		add(save);
		add(start);
		add(stop);
		add(sub);
		add(add);
		add(inc);
		add(dec);
		add(reset);

		add(min);
		add(sec);
		add(milli);

		add(minLabel);
		add(secLabel);
		add(milliLabel);

		add(time);
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

			// TODO make sure this works
			if (event.getSource() == load) {
				JFileChooser chooser = new JFileChooser();
				JTextArea ta = new JTextArea(20, 30);

				int status = chooser.showOpenDialog(null);

				if (status != JFileChooser.APPROVE_OPTION)
					ta.setText("No File Chosen");

				else {
					File file = chooser.getSelectedFile();
					Scanner scan = new Scanner(file);
					String info = "";
					while (scan.hasNext())
						info += scan.nextLine() + "\n";
					ta.setText(info);
					stopWatchTimer.load(file.getAbsolutePath());
				}
			}

			// // TODO add this section from the book
			// if (event.getSource() == save) {
			// stopWatchTimer.save(FILENAMEHERE);
			// }

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
					JOptionPane.showMessageDialog(null, "Illegal Argument Exception");
				}
			}

			if (event.getSource() == add) {
				try {
					StopWatch temp = new StopWatch("" + min.getText() + ":" + sec.getText() + ":" + milli.getText());
					stopWatchTimer.add(temp);
					time.setText(stopWatchTimer.toString());
				} catch (IllegalArgumentException e) {
					JOptionPane.showMessageDialog(null, "Illegal Argument Exception");
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
					JOptionPane.showMessageDialog(null, "Illegal Argument Exception");
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
			stopWatchTimer.inc();
			time.setText(stopWatchTimer.toString());
		}
	}
}
