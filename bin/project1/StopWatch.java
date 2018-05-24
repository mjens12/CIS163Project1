package project1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class StopWatch {
	private int seconds;
	private int minutes;
	private int milliseconds;

	public static boolean suspend = false;

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		if (!suspend)
			this.seconds = seconds;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		if (!suspend)
			this.minutes = minutes;
	}

	public int getMilliseconds() {
		return milliseconds;
	}

	public void setMilliseconds(int milliseconds) {
		if (!suspend)
			this.milliseconds = milliseconds;
	}

	public StopWatch() {
		super();
	}

	public StopWatch(int minutes, int seconds, int milliseconds) {
		super();
		if (seconds > 59 || milliseconds > 999 || minutes < 0 || seconds < 0 || milliseconds < 0) {
			throw new IllegalArgumentException();
		} else {
			this.seconds = seconds;
			this.minutes = minutes;
			this.milliseconds = milliseconds;
		}
	}

	public StopWatch(int seconds, int milliseconds) {
		super();
		if (seconds > 59 || milliseconds > 999 || seconds < 0 || milliseconds < 0) {
			throw new IllegalArgumentException();
		} else {
			this.seconds = seconds;
			this.milliseconds = milliseconds;
		}
	}

	public StopWatch(int milliseconds) {
		super();
		if (milliseconds > 999 || milliseconds < 0) {
			throw new IllegalArgumentException();
		} else {
			this.milliseconds = milliseconds;
		}
	}

	@Override
	public String toString() {
		String temp = "";

		temp += minutes + ":";

		if (seconds < 10)
			temp += "0";
		temp += seconds + ":";

		if (milliseconds == 0)
			temp += "00";
		if (milliseconds > 0 && milliseconds < 10)
			temp += "00";
		if (milliseconds > 9 && milliseconds < 100)
			temp += "0";
		temp += milliseconds;

		return temp;
	}

	public StopWatch(String startTime) {
		int count = 0;

		minutes = 0;
		seconds = 0;
		milliseconds = 0;

		for (int i = 0; i < startTime.length(); i++) {
			if (startTime.charAt(i) == ':')
				count++;
		}

		if (count == 2) {
			int min = 0;
			int milli = 0;
			int sec = 0;

			min = Integer.parseInt(startTime.substring(0, startTime.indexOf(':')));
			sec = Integer.parseInt(startTime.substring((startTime.indexOf(':') + 1), startTime.lastIndexOf(':')));
			milli = Integer.parseInt(startTime.substring((startTime.lastIndexOf(':') + 1), startTime.length()));

			if (sec > 59 || milli > 999 || min < 0 || sec < 0 || milli < 0) {
				throw new IllegalArgumentException();
			}

			else {
				minutes = min;
				seconds = sec;
				milliseconds = milli;
			}
		}

		if (count == 1) {
			minutes = 0;

			int sec = 0;
			int milli = 0;

			sec = Integer.parseInt(startTime.substring(0, startTime.indexOf(':')));
			milli = Integer.parseInt(startTime.substring((startTime.indexOf(':') + 1), startTime.length()));

			if (sec > 59 || milli > 999 || sec < 0 || milli < 0) {
				throw new IllegalArgumentException();
			}

			else {
				seconds = sec;
				milliseconds = milli;
			}
		}
		if (count == 0) {
			int milli = 0;

			minutes = 0;
			seconds = 0;

			milli = Integer.parseInt(startTime);

			if (milli > 999 || milli < 0) {
				throw new IllegalArgumentException();
			} else
				milliseconds = milli;
		}

	}

	// public boolean equals (StopWatch other) {
	// if (other.minutes == this.minutes && other.seconds == this.seconds &&
	// other.milliseconds == this.milliseconds)
	// return true;
	// else
	// return false;
	// }

	public boolean equals(Object other) {
		if (other != null) {
			if (other instanceof StopWatch) {
				StopWatch temp = (StopWatch) other;
				if (temp.minutes == this.minutes && temp.seconds == this.seconds
						&& temp.milliseconds == this.milliseconds)
					return true;
			}
		}
		return false;
	}

	public static boolean equals(StopWatch s1, StopWatch s2) {
		if (s1.equals(s2))
			return true;
		else
			return false;
	}

	public int compareTo(StopWatch other) {
		if (toMilli(this) > toMilli(other)) {
			return 1;
		}

		if (this.equals(other)) {
			return 0;
		}

		else
			return -1;
	}

	// TODO figure out if rollover should be here or in the inc method
	public void add(int milliseconds) {
		if (!suspend) {
			if (milliseconds < 0)
				throw new IllegalArgumentException();
			else {
				for (int i = milliseconds; i > 0; i--) {
					this.inc();
				}
			}
		}
	}

	public void add(StopWatch other) {
		if (!suspend) {
			this.add(toMilli(other));
		}
	}

	public void inc() {
		if (!suspend) {
			this.milliseconds = this.milliseconds + 1;

			if (this.milliseconds == 1000) {
				this.seconds++;
				this.milliseconds = 0;
			}
			if (this.seconds == 60) {
				this.minutes++;
				this.seconds = 0;
			}

		}
	}

	public void sub(int milliseconds) {
		if (!suspend) {
			if (milliseconds < 0) {
				throw new IllegalArgumentException();
			} else {
				if (milliseconds > toMilli(this)) {
					throw new IllegalArgumentException();
				} else {
					for (int i = milliseconds; i > 0; i--)
						this.dec();
				}
			}
		}
	}

	public void sub(StopWatch other) {
		if (!suspend) {
			if (toMilli(other) < 0) {
				throw new IllegalArgumentException();
			} else {
				if (toMilli(other) > toMilli(this)) {
					throw new IllegalArgumentException();
				} else {
					this.sub(toMilli(other));
				}
			}
		}
	}

	public void dec() {
		if (!suspend) {
			if (toMilli(this) == 0)
				throw new IllegalArgumentException();
			else {
				this.milliseconds = this.milliseconds - 1;
				if (this.seconds > 0 && this.milliseconds == 0) {
					this.seconds--;
					this.milliseconds = 1000;
				}
				if (this.minutes > 0 && this.seconds == 0) {
					this.minutes--;
					this.seconds = 60;
				}
			}
		}
	}

	public void save(String fileName) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println(minutes);
		out.println(seconds);
		out.println(milliseconds);
		out.close();
	}

	public void load(String fileName) {
		if (!suspend) {
			try {
				// open the data file
				// use absolutepath here
				// https://stackoverflow.com/questions/1099300/whats-the-difference-between-getpath-getabsolutepath-and-getcanonicalpath
				Scanner fileReader = new Scanner(new File(fileName));

				// read one int
				minutes = fileReader.nextInt();
				seconds = fileReader.nextInt();
				milliseconds = fileReader.nextInt();
				System.out.println("" + minutes + seconds + milliseconds);
				fileReader.close();
			}

			// problem reading the file
			catch (Exception error) {
				System.out.println("Oops! Reading the file went wrong");
			}
		}
	}

	public static void suspend(boolean flag) {
		if (flag == true) {
			suspend = true;
		} else
			suspend = false;
	}

	private int toMilli(StopWatch input) {
		return ((input.minutes * 60000) + (input.seconds * 1000) + input.milliseconds);
	}

	private StopWatch toSW(int input) {
		int temp = 0;
		int minutes = 0;
		int seconds = 0;
		int milliseconds = 0;

		minutes = input / 60000;
		temp = input % 60000;
		seconds = temp / 1000;
		temp = temp % 1000;
		milliseconds = temp;

		return new StopWatch(minutes, seconds, milliseconds);
	}

	public void reset() {
		if (!suspend) {
			this.setMinutes(0);
			this.setSeconds(0);
			this.setMilliseconds(0);
		}
	}
}
