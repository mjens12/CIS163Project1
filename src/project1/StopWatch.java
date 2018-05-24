package project1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**********************************************************************
 * Representation of a stopwatch
 * 
 * @author Max Jensen and Monica Klosin
 * @version 1.0
 **********************************************************************/

public class StopWatch {
	/** current second value of stopwatch */
	private int seconds;

	/** current minute value of stopwatch */
	private int minutes;

	/** current millisecond value of stopwatch */
	private int milliseconds;

	/**
	 * static variable that managed whether mutators are suspended or
	 * not
	 */
	public static boolean suspend = false;

	/******************************************************************
	 * Getter for seconds. Returns the number of seconds on the
	 * stopwatch
	 * 
	 * @return int seconds
	 *****************************************************************/
	public int getSeconds() {
		return seconds;
	}

	/******************************************************************
	 * Setter for seconds. Sets the number of seconds on the stopwatch
	 * 
	 * @param seconds
	 *            the number of seconds to set the StopWatch to
	 *****************************************************************/
	public void setSeconds(int seconds) {
		if (!suspend)
			this.seconds = seconds;
	}

	/******************************************************************
	 * Getter for minutes. Returns the number of minutes on the
	 * stopwatch
	 * 
	 * @return int minutes
	 *****************************************************************/
	public int getMinutes() {
		return minutes;
	}

	/******************************************************************
	 * Setter for minutes. Sets the number of minutes on the stopwatch
	 * 
	 * @param minutes
	 *            the number of minutes to set the StopWatch to
	 *****************************************************************/
	public void setMinutes(int minutes) {
		if (!suspend)
			this.minutes = minutes;
	}

	/******************************************************************
	 * Getter for milliseconds. Returns the number of milliseconds on
	 * the stopwatch
	 * 
	 * @return int milliseconds
	 *****************************************************************/
	public int getMilliseconds() {
		return milliseconds;
	}

	/******************************************************************
	 * Setter for milliseconds. Sets the number of milliseconds on the
	 * stopwatch
	 * 
	 * @param milliseconds
	 *            the number of miliseconds to set the StopWatch to
	 *****************************************************************/
	public void setMilliseconds(int milliseconds) {
		if (!suspend)
			this.milliseconds = milliseconds;
	}

	/******************************************************************
	 * Default constructor. Initializes the StopWatch with default
	 * object constructor
	 *****************************************************************/
	public StopWatch() {
		super();
	}

	/******************************************************************
	 * Constructor that accepts 3 ints. Sets the new StopWatch to have
	 * minutes, seconds, and milliseconds in accordance with the passed
	 * parameters. Throws an IllegalArguementException if the parameters
	 * passed are alpha, negative, or otherwise outside the 0-60 and
	 * 0-999 bounds of seconds and milliseconds respectively.
	 * 
	 * @param minutes
	 *            the number of minutes to set the StopWatch to
	 * @param seconds
	 *            the number of seconds to set the StopWatch to
	 * @param milliseconds
	 *            the number of miliseconds to set the StopWatch to
	 * 
	 * @throws IllegalArgumentException
	 *             if the parameters passed are alpha, negative, or
	 *             otherwise outside the 0-60 and 0-999 bounds of
	 *             seconds and milliseconds respectively.
	 *****************************************************************/
	public StopWatch(int minutes, int seconds, int milliseconds) {
		super();
		if (seconds > 59 || milliseconds > 999 || minutes < 0
				|| seconds < 0 || milliseconds < 0) {
			throw new IllegalArgumentException();
		} else {
			this.seconds = seconds;
			this.minutes = minutes;
			this.milliseconds = milliseconds;
		}
	}

	/******************************************************************
	 * Constructor that accepts 2 ints. Sets the new StopWatch to have
	 * seconds and milliseconds in accordance with the passed
	 * parameters.
	 * 
	 * @param seconds
	 *            the number of seconds to set the StopWatch to
	 * @param milliseconds
	 *            the number of miliseconds to set the StopWatch to
	 * 
	 * @throws IllegalArgumentException
	 *             if the parameters passed are alpha, negative, or
	 *             otherwise outside the 0-60 and 0-999 bounds of
	 *             seconds and milliseconds respectively.
	 *****************************************************************/
	public StopWatch(int seconds, int milliseconds) {
		super();
		if (seconds > 59 || milliseconds > 999 || seconds < 0
				|| milliseconds < 0) {
			throw new IllegalArgumentException();
		} else {
			this.seconds = seconds;
			this.milliseconds = milliseconds;
		}
	}

	/******************************************************************
	 * Constructor that accepts 1 int. Sets the new StopWatch to have
	 * milliseconds in accordance with the passed parameters. Throws an
	 * IllegalArguementException if the parameters passed are alpha,
	 * negative, or otherwise outside the 0-999 bounds of milliseconds
	 * 
	 * @param milliseconds
	 *            the number of miliseconds to set the StopWatch to
	 * 
	 * @throws IllegalArgumentException
	 *             if the parameters passed are alpha, negative, or
	 *             otherwise outside the 0-999 bounds of milliseconds.
	 *****************************************************************/
	public StopWatch(int milliseconds) {
		super();
		if (milliseconds > 999 || milliseconds < 0) {
			throw new IllegalArgumentException();
		} else {
			this.milliseconds = milliseconds;
		}
	}

	/******************************************************************
	 * toString Method that converts a StopWatch to a string with the
	 * following format: “1:06:010”. Displays the minutes as is; if
	 * seconds < 10 then displays with a leading “0”, and always
	 * displays milliseconds with 3 digits.
	 * 
	 * @return String temp
	 *****************************************************************/
	@Override
	public String toString() {
		String temp = "";

		temp += minutes + ":";

		// formats the seconds section of the string
		if (seconds < 10)
			temp += "0";
		temp += seconds + ":";

		// formats the milliseconds section of the string
		if (milliseconds == 0)
			temp += "00";
		if (milliseconds > 0 && milliseconds < 10)
			temp += "00";
		if (milliseconds > 9 && milliseconds < 100)
			temp += "0";
		temp += milliseconds;

		return temp;
	}

	/******************************************************************
	 * Constructor that accepts a string as input. Sets the new
	 * StopWatch to have minutes, seconds, and milliseconds in
	 * accordance with the passed string. Can accept a string in the
	 * format "0:0:0", "0:0", or "0"
	 * 
	 * @param startTime
	 *            the string to be converted to a StopWatch
	 * 
	 * @throws IllegalArgumentException
	 *             if the parameters passed are alpha, negative, or
	 *             otherwise outside the 0-60 and 0-999 bounds of
	 *             seconds and milliseconds respectively.
	 *****************************************************************/
	public StopWatch(String startTime) {
		int count = 0;

		minutes = 0;
		seconds = 0;
		milliseconds = 0;

		// counts the number of semicolons in the passed string
		for (int i = 0; i < startTime.length(); i++) {
			if (startTime.charAt(i) == ':')
				count++;
		}

		// if there are 2 semicolons, breaks the string into ints and
		// constructs the StopWatch accordingly
		if (count == 2) {
			int min = 0;
			int milli = 0;
			int sec = 0;

			min = Integer.parseInt(
					startTime.substring(0, startTime.indexOf(':')));
			sec = Integer.parseInt(
					startTime.substring((startTime.indexOf(':') + 1),
							startTime.lastIndexOf(':')));
			milli = Integer.parseInt(startTime.substring(
					(startTime.lastIndexOf(':') + 1),
					startTime.length()));

			if (sec > 59 || milli > 999 || min < 0 || sec < 0
					|| milli < 0) {
				throw new IllegalArgumentException();
			}

			else {
				minutes = min;
				seconds = sec;
				milliseconds = milli;
			}
		}

		// if there is 1 semicolon breaks the string into ints
		// and constructs the StopWatch accordingly
		if (count == 1) {
			minutes = 0;

			int sec = 0;
			int milli = 0;

			sec = Integer.parseInt(
					startTime.substring(0, startTime.indexOf(':')));
			milli = Integer.parseInt(startTime.substring(
					(startTime.indexOf(':') + 1), startTime.length()));

			if (sec > 59 || milli > 999 || sec < 0 || milli < 0) {
				throw new IllegalArgumentException();
			}

			else {
				seconds = sec;
				milliseconds = milli;
			}
		}
		// if there are no semicolons constructs the stopwatch
		// accordingly
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

	/******************************************************************
	 * Compares two StopWatch objects. Not used
	 *****************************************************************/
	// public boolean equals (StopWatch other) {
	// if (other.minutes == this.minutes && other.seconds ==
	// this.seconds &&
	// other.milliseconds == this.milliseconds)
	// return true;
	// else
	// return false;
	// }

	/******************************************************************
	 * Compares two objects. Checks if the passed object is a StopWatch
	 * before comparing. Returns true if objects are exactly the same,
	 * false if not
	 * 
	 * @param other
	 *            the other Object to be compared
	 * @return boolean
	 *****************************************************************/
	public boolean equals(Object other) {
		if (other != null) {
			if (other instanceof StopWatch) {
				StopWatch temp = (StopWatch) other;
				if (temp.minutes == this.minutes
						&& temp.seconds == this.seconds
						&& temp.milliseconds == this.milliseconds)
					return true;
			}
		}
		return false;
	}

	/******************************************************************
	 * Compares two StopWatch objects. Returns true if objects are
	 * exactly the same, false if not.
	 * 
	 * @param s1
	 *            first StopWatch to be compared
	 * @param s2
	 *            second StopWatch to be compared
	 * @return boolean
	 *****************************************************************/
	public static boolean equals(StopWatch s1, StopWatch s2) {
		if (s1.equals(s2))
			return true;
		else
			return false;
	}

	/******************************************************************
	 * Compares two StopWatch objects. Returns 1 if the first StopWatch
	 * has more time than the second, 0 if the two StopWatches are
	 * equal, and -1 if the first StopWatch has less time than the
	 * second
	 * 
	 * @param s1
	 *            first StopWatch to be compared
	 * @param s2
	 *            second StopWatch to be compared
	 * @return boolean
	 *****************************************************************/
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

	/******************************************************************
	 * Adds the passed int parameter number of milliseconds to the
	 * StopWatch by calling the inc() method in a loop
	 * 
	 * @param milliseconds
	 *            number of milliseconds to add
	 * @throws IllegalArgumentException
	 *             if milliseconds is a negative number
	 *****************************************************************/
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

	/******************************************************************
	 * Adds time from passed StopWatch to the original StopWatch by
	 * converting passed stopwatch to milliseconds and calling the
	 * previous add() method
	 * 
	 * @param other
	 *            the StopWatch to add to the original StopWatch
	 *****************************************************************/
	public void add(StopWatch other) {
		if (!suspend) {
			this.add(toMilli(other));
		}
	}

	/******************************************************************
	 * Increments the stopwatch by 1 millisecond and handles rollover
	 * for minutes, seconds, and milliseconds when adding.
	 *****************************************************************/
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

	/******************************************************************
	 * Subtracts the parameter number of milliseconds from the StopWatch
	 * by calling the dec() method in a loop
	 * 
	 * @param milliseconds
	 *            number of milliseconds to subtract
	 * @throws IllegalArgumentException
	 *             if milliseconds is a negative number
	 * @throws IllegalArgumentException
	 *             if the parameter milliseconds is greater than the
	 *             total number of milliseconds on the stopwatch you are
	 *             subtracting from
	 *****************************************************************/
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

	/******************************************************************
	 * Subtracts time on passed StopWatch from the original StopWatch by
	 * converting passed stopwatch to milliseconds and calling the
	 * previous sub() method
	 * 
	 * @param other
	 *            the StopWatch to subtract from the original StopWatch
	 * @throws IllegalArgumentException
	 *             if milliseconds is a negative number
	 * @throws IllegalArgumentException
	 *             if the parameter milliseconds is greater than the
	 *             total number of milliseconds on the stopwatch you are
	 *             subtracting from
	 *****************************************************************/
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

	/******************************************************************
	 * Decrements the stopwatch by 1 millisecond and handles rollover
	 * for minutes, seconds, and milliseconds when subtracting.
	 *****************************************************************/
	public void dec() {
		if (!suspend) {
			if (toMilli(this) == 0)
				throw new IllegalArgumentException();
			else {
				if (this.milliseconds > 0) {
					this.milliseconds--;
				} else if (this.seconds == 1
						&& this.milliseconds == 0) {
					this.seconds = 0;
					this.milliseconds = 999;
				} else if (this.seconds > 0 && this.milliseconds == 0) { //
					this.seconds--;
					this.milliseconds = 999;
				} else if (this.minutes == 1 && this.seconds == 0
						&& this.milliseconds == 0) {
					this.minutes = 0;
					this.seconds = 59;
					this.milliseconds = 999;
				} else if (this.minutes > 0 && this.seconds == 0) {
					this.minutes--;
					this.seconds = 59;
					this.milliseconds = 999;
				}

			}
		}
	}

	/*****************************************************************
	 * Method that saves a StopWatch time in a file
	 * 
	 * @param fileName
	 *            file which will save StopWatch time
	 *****************************************************************/

	public void save(String fileName) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(
					new BufferedWriter(new FileWriter(fileName)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println(minutes);
		out.println(seconds);
		out.println(milliseconds);
		out.close();
	}

	/*****************************************************************
	 * Method that loads a StopWatch from a file
	 * 
	 * @param filName
	 *            file which has StopWatch time saved to it
	 * 
	 *****************************************************************/

	public void load(String fileName) {
		if (!suspend) {
			try {
				Scanner fileReader = new Scanner(new File(fileName));

				// read one int
				minutes = fileReader.nextInt();
				seconds = fileReader.nextInt();
				milliseconds = fileReader.nextInt();
				System.out
						.println("" + minutes + seconds + milliseconds);
				fileReader.close();
			}

			// problem reading the file
			catch (Exception error) {
				System.out.println("Oops! Reading the file went wrong");
			}
		}
	}

	/*****************************************************************
	 * Method which suspends all functions (add, subtract, inc, dec)
	 * when @param flag is true functions are unsuspended when @param
	 * flag is false
	 * 
	 * @param flag
	 *            suspend button
	 *****************************************************************/

	public static void suspend(boolean flag) {
		if (flag == true) {
			suspend = true;
		} else
			suspend = false;
	}

	/*****************************************************************
	 * Converts input into milliseconds
	 * 
	 * @param input
	 *            StopWatch time that will be converted
	 * @return time in milliseconds
	 *****************************************************************/

	private int toMilli(StopWatch input) {
		return ((input.minutes * 60000) + (input.seconds * 1000)
				+ input.milliseconds);
	}

	/*****************************************************************
	 * Resets StopWatch, sets minutes, seconds, and milliseconds to zero
	 * if suspend button is not held
	 *****************************************************************/

	public void reset() {
		if (!suspend) {
			this.setMinutes(0);
			this.setSeconds(0);
			this.setMilliseconds(0);
		}
	}
}
