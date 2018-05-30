package project1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class TestStopWatch {

	/**
	 *
	 * The following are simple random JUnit test cases... After talking
	 * with your instructor, create many, many more that shows that your
	 * code is functioning correctly.
	 *
	 */

	// default constructor test
	@Test
	public void testDefaultConstructorMJMK() {
		StopWatch s = new StopWatch();
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 0);
	}

	@Test
	public void testConstructor1ParameterMJMK() {
		StopWatch s = new StopWatch(2);
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 2);
	}

	@Test
	public void testConstructor2ParametersMJMK() {
		StopWatch s = new StopWatch(2, 3);
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 2);
		assertTrue(s.getMilliseconds() == 3);
	}

	@Test
	public void testConstructor3ParametersMJMK() {
		StopWatch s = new StopWatch(2, 3, 4);
		assertTrue(s.getMinutes() == 2);
		assertTrue(s.getSeconds() == 3);
		assertTrue(s.getMilliseconds() == 4);
	}

	@Test
	public void testConstructorMJMK() {
		StopWatch s = new StopWatch(5, 10, 300);
		assertEquals(s.toString(), "5:10:300");

		s = new StopWatch("20:10:8");
		assertEquals(s.toString(), "20:10:008");

		s = new StopWatch("20:8");
		assertEquals(s.toString(), "0:20:008");

		s = new StopWatch("8");
		assertEquals(s.toString(), "0:00:008");
	}

	// Constructor over limit testing (Max Jensen)
	@Test(expected = IllegalArgumentException.class)
	public void testnooInputMJMK() {
		new StopWatch(12, 61, 1001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnonInputMJMK() {
		new StopWatch(12, 61, 14);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnnoInputMJMK() {
		new StopWatch(12, 59, 1001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testooInputMJMK() {
		new StopWatch(61, 1001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testonInputMJMK() {
		new StopWatch(61, 999);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnoInputMJMK() {
		new StopWatch(59, 1001);
	}

	// Negative Constructor testing (Max Jensen)
	@Test(expected = IllegalArgumentException.class)
	public void testNegSingleInput2MJMK() {
		new StopWatch(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnnParametersMJMK() {
		new StopWatch(-1, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnpParametersMJMK() {
		new StopWatch(-1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testpnParametersMJMK() {
		new StopWatch(-1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnnnParametersMJMK() {
		new StopWatch(-1, -1, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnnpParametersMJMK() {
		new StopWatch(-1, -1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnpnParametersMJMK() {
		new StopWatch(-1, 1, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testppnParametersMJMK() {
		new StopWatch(1, 1, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnppParametersMJMK() {
		new StopWatch(-1, 1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testpnpParametersMJMK() {
		new StopWatch(1, -1, 1);
	}

	// String constructor working testing
	@Test
	public void testStringConst3ParamsMJMK() {
		StopWatch s1 = new StopWatch("5:5:300");
		assertEquals(s1.toString(), "5:05:300");
	}

	@Test
	public void testStringConst2ParamsMJMK() {
		StopWatch s1 = new StopWatch("5:300");
		assertEquals(s1.toString(), "0:05:300");
	}

	@Test
	public void testStringConst1ParamsMJMK() {
		StopWatch s1 = new StopWatch("1");
		assertEquals(s1.toString(), "0:00:001");
	}

	// String constructor under testing (Max Jensen)
	// min sec and milli
	@Test(expected = IllegalArgumentException.class)
	public void testuuuConstructorMJMK() {
		new StopWatch("-1:-1:-1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testuunConstructorMJMK() {
		new StopWatch("-1:-1:999");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testunnConstructorMJMK() {
		new StopWatch("-1:34:999");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnunConstructorMJMK() {
		new StopWatch("1:-34:999");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testunuConstructorMJMK() {
		new StopWatch("-1:34:-999");
	}

	// sec and milli
	@Test(expected = IllegalArgumentException.class)
	public void testunConstructorMJMK() {
		new StopWatch("-34:999");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnuConstructorMJMK() {
		new StopWatch("34:-999");
	}

	// milli
	@Test(expected = IllegalArgumentException.class)
	public void testuConstructorMJMK() {
		new StopWatch("-999");
	}

	// String constructor over testing (Max Jensen)
	// min sec and milli
	@Test(expected = IllegalArgumentException.class)
	public void testnooConstructorMJMK() {
		new StopWatch("2:61:1001");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnnoConstructorMJMK() {
		new StopWatch("2:59:1001");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnonConstructorMJMK() {
		new StopWatch("2:61:999");
	}

	// sec and milli
	@Test(expected = IllegalArgumentException.class)
	public void testooConstructorMJMK() {
		new StopWatch("61:1001");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnoConstructorMJMK() {
		new StopWatch("59:1001");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testonConstructorMJMK() {
		new StopWatch("61:999");
	}

	// milli
	@Test(expected = IllegalArgumentException.class)
	public void testoConstructorMJMK() {
		new StopWatch("1001");
	}

	// String constructor alpha testing (Max Jensen)
	@Test(expected = IllegalArgumentException.class)
	public void testannConstructorMJMK() {
		new StopWatch("a:34:999");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnanConstructorMJMK() {
		new StopWatch("10:a:999");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnnaConstructorMJMK() {
		new StopWatch("15:55:a");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testaaInputMJMK() {
		new StopWatch("a:a");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testanInputMJMK() {
		new StopWatch("a:15");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnaInputMJMK() {
		new StopWatch("15:a");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testaInputMJMK() {
		new StopWatch("a");
	}

	// toString testing (Max Jensen)
	@Test
	public void testminsecmilliToStringMJMK() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		assertEquals(s1.toString(), "5:59:300");
	}

	@Test
	public void testSecZeroesToStringMJMK() {
		StopWatch s1 = new StopWatch(5, 5, 300);
		assertEquals(s1.toString(), "5:05:300");
	}

	@Test
	public void testMilliZeroesToStringMJMK() {
		StopWatch s1 = new StopWatch(5, 59, 1);
		assertEquals(s1.toString(), "5:59:001");
	}

	@Test
	public void testsecmilliToStringMJMK() {
		StopWatch s1 = new StopWatch(59, 300);
		assertEquals(s1.toString(), "0:59:300");
	}

	@Test
	public void testMinZeroesToStringMJMK() {
		StopWatch s1 = new StopWatch(1, 0, 300);
		assertEquals(s1.toString(), "1:00:300");
	}

	@Test
	public void testmilliToStringMJMK() {
		StopWatch s1 = new StopWatch(300);
		assertEquals(s1.toString(), "0:00:300");
	}

	@Test
	public void testMilli1ToStringMJMK() {
		StopWatch s1 = new StopWatch(0, 0, 1);
		assertEquals(s1.toString(), "0:00:001");
	}

	@Test
	public void testMilli10ToStringMJMK() {
		StopWatch s1 = new StopWatch(0, 0, 10);
		assertEquals(s1.toString(), "0:00:010");
	}

	@Test
	public void testMilli100ToStringMJMK() {
		StopWatch s1 = new StopWatch(0, 0, 100);
		assertEquals(s1.toString(), "0:00:100");
	}

	@Test
	public void testSec1ToStringMJMK() {
		StopWatch s1 = new StopWatch(0, 1, 00);
		assertEquals(s1.toString(), "0:01:000");
	}

	@Test
	public void testSec10ToStringMJMK() {
		StopWatch s1 = new StopWatch(0, 10, 00);
		assertEquals(s1.toString(), "0:10:000");
	}

	@Test
	public void testMin1ToStringMJMK() {
		StopWatch s1 = new StopWatch(1, 0, 00);
		assertEquals(s1.toString(), "1:00:000");
	}

	@Test
	public void testMin10ToStringMJMK() {
		StopWatch s1 = new StopWatch(10, 0, 00);
		assertEquals(s1.toString(), "10:00:000");
	}

	@Test
	public void testMin100ToStringMJMK() {
		StopWatch s1 = new StopWatch(100, 0, 00);
		assertEquals(s1.toString(), "100:00:000");
	}

	@Test
	public void testAllZeroesToStringMJMK() {
		StopWatch s1 = new StopWatch(0, 0, 0);
		assertEquals(s1.toString(), "0:00:000");
	}

	@Test
	public void testAddMethodMJMK() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		s1.add(2000);
		assertEquals(s1.toString(), "6:01:300");

		s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(2, 2, 300);
		s1.add(s2);
		System.out.println(s1);
		assertEquals(s1.toString(), "8:01:600");

		for (int i = 0; i < 15000; i++)
			s1.inc();
		System.out.println(s1);
		assertEquals(s1.toString(), "8:16:600");
	}

	@Test
	public void testEqualMJMK() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(6, 01, 200);
		StopWatch s3 = new StopWatch(5, 50, 200);
		StopWatch s4 = new StopWatch(5, 59, 300);

		assertFalse(s1.equals(s2));
		assertTrue(s1.equals(s4));

		assertTrue(s2.compareTo(s1) > 0);
		assertTrue(s3.compareTo(s1) < 0);
		assertTrue(s1.compareTo(s4) == 0);

	}

	@Test
	public void testLoadSaveMJMK() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(5, 59, 300);

		s1.save("file1");
		s1 = new StopWatch(); // resets to zero

		s1.load("file1");
		assertTrue(s1.equals(s2));
	}

	@Test
	public void testMutateMJMK() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(5, 59, 300);

		StopWatch.suspend(true);
		s1.add(1000);
		assertTrue(s1.equals(s2));
		StopWatch.suspend(false);
	}

	@Test
	public void equalsTestMJMK() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(5, 59, 300);

		assertEquals(s1, s2);
	}

	@Test
	public void StopWatchStartTimeMJMK() {
		StopWatch s1 = new StopWatch("5:59:200");
		assertTrue(s1.toString().equals("5:59:200"));
		StopWatch s2 = new StopWatch("35:43:594");
		assertTrue(s2.toString().equals("35:43:594"));
		StopWatch s3 = new StopWatch("34:4");
		assertTrue(s3.toString().equals("0:34:004"));
		StopWatch s4 = new StopWatch("35");
		assertTrue(s4.toString().equals("0:00:035"));
		StopWatch s5 = new StopWatch("0:0");
		assertTrue(s5.toString().equals("0:00:000"));

		StopWatch s6 = new StopWatch("0");
		assertTrue(s6.toString().equals("0:00:000"));
		StopWatch s7 = new StopWatch("0:0:0");
		assertTrue(s7.toString().equals("0:00:000"));
		StopWatch s8 = new StopWatch("1:10:10");
		assertTrue(s8.toString().equals("1:10:010"));
		StopWatch s9 = new StopWatch("0:10:10");
		assertTrue(s9.toString().equals("0:10:010"));
		StopWatch s10 = new StopWatch("0:59:999");
		assertTrue(s10.toString().equals("0:59:999"));
		// MK
	}

	@Test
	public void testEqualsObjectOtherMJMK() {
		//
		StopWatch s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(5, 59, 300);

		StopWatch s3 = new StopWatch(0, 0, 35);
		StopWatch s4 = new StopWatch(0, 0, 35);

		StopWatch s5 = new StopWatch(0, 45, 35);
		StopWatch s6 = new StopWatch(0, 45, 35);

		StopWatch s7 = new StopWatch(0, 00, 000);
		StopWatch s8 = new StopWatch(0, 00, 000);

		assertEquals(s1, s2);
		assertEquals(s3, s4);
		assertEquals(s5, s6);
		assertEquals(s7, s8);

		assertNotEquals(s1, s3);
		assertNotEquals(s1, s5);
		assertNotEquals(s1, s7);
		assertNotEquals(s3, s1);
		assertNotEquals(s3, s5);
		assertNotEquals(s3, s7);
		assertNotEquals(s5, s1);
		assertNotEquals(s5, s3);
		assertNotEquals(s5, s7);
		assertNotEquals(s7, s1);
		assertNotEquals(s7, s3);
		assertNotEquals(s7, s5);
		// Monica K
	}

	@Test
	public void testEqualsStopWatchMJMK() {
		StopWatch s1 = new StopWatch("5:01:902");
		StopWatch s2 = new StopWatch("5:01:902");
		StopWatch s3 = new StopWatch("0:05:050");
		StopWatch s4 = new StopWatch("0:05:050");
		StopWatch s5 = new StopWatch("0:00:45");
		StopWatch s6 = new StopWatch("0:00:45");
		StopWatch s7 = new StopWatch("0:00:000");
		StopWatch s8 = new StopWatch("0:00:000");

		assertTrue(s1.equals(s2));
		assertTrue(s3.equals(s4));
		assertTrue(s5.equals(s6));
		assertTrue(s7.equals(s8));

		assertFalse(s1.equals(s3));
		assertFalse(s1.equals(s5));
		assertFalse(s1.equals(s7));
		assertFalse(s3.equals(s5));
		assertFalse(s3.equals(s7));
		assertFalse(s5.equals(s7));

		// Monica K
	}

	@Test
	public void testCompareToMJMK() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(5, 59, 300);
		StopWatch s3 = new StopWatch(4, 50, 200);
		StopWatch s4 = new StopWatch(10, 59, 500);
		StopWatch s5 = new StopWatch(0, 00, 000);

		assertTrue(s1.equals(s2));
		assertFalse(s1.equals(s4));
		assertFalse(s1.equals(s5));

		assertTrue(s1.compareTo(s2) == 0);
		assertTrue(s1.compareTo(s3) == 1);
		assertTrue(s1.compareTo(s4) == -1);
		assertTrue(s1.compareTo(s5) == 1);

		assertTrue(s2.compareTo(s1) == 0);
		assertTrue(s2.compareTo(s3) == 1);
		assertTrue(s2.compareTo(s4) == -1);
		assertTrue(s2.compareTo(s5) == 1);

		assertTrue(s3.compareTo(s1) == -1);
		assertTrue(s3.compareTo(s2) == -1);
		assertTrue(s3.compareTo(s4) == -1);
		assertTrue(s3.compareTo(s5) == 1);

		assertTrue(s4.compareTo(s1) == 1);
		assertTrue(s4.compareTo(s2) == 1);
		assertTrue(s4.compareTo(s3) == 1);
		assertTrue(s4.compareTo(s5) == 1);
		// Monica K
	}

	// RS
	@Test
	public void AddTest_LargeParamMJMK() {
		StopWatch f = new StopWatch("0:00:000");
		f.add(9000000);
		assertEquals(f.toString(), "150:00:000");
	}

	// RS
	@Test(expected = IllegalArgumentException.class)
	public void AddTest_Neg1MJMK() {
		StopWatch f = new StopWatch("50:50:050");
		f.add(-10);
	}

	// RS
	@Test
	public void AddTest_AddZeroMJMK() {
		StopWatch f = new StopWatch("20:30:050");
		f.add(0);
		assertEquals(f.toString(), "20:30:050");
	}

	@Test
	public void AddStopWatchTest_NormalMJMK() {
		StopWatch f = new StopWatch("0:0:0");
		StopWatch bg = new StopWatch(59, 599);
		f.add(bg);
		assertEquals(f.toString(), "0:59:599");
	}

	@Test
	public void SubMilliseconds_NormalTestMJMK() {
		StopWatch g = new StopWatch(1, 122);
		g.sub(22);
		Assert.assertEquals(g.getMilliseconds(), 100);
	}

	@Test
	public void SubMilliseconds_BorrowFromSecondsMJMK() {
		StopWatch g = new StopWatch(1, 2);
		g.sub(3);
		Assert.assertEquals(g.getMilliseconds(), 999);
	}

	@Test(expected = IllegalArgumentException.class)
	public void SubMillisecondsTest_ToZeroOverflowMJMK() {
		StopWatch g = new StopWatch(2);
		g.sub(5);
	}

	@Test
	public void SubMillisecondsTest_BorrowFromMinsMJMK() {
		StopWatch g = new StopWatch("21:51:001");
		g.sub(50501);
		Assert.assertEquals(g.getMilliseconds(), 500);
	}

	@Test
	public void SubMillisecondsTest_BorrowFromMinsToZeroMJMK() {
		StopWatch g = new StopWatch("1:01:001");
		g.sub(61001);
		Assert.assertEquals(g.getMilliseconds(), 0);
	}

	// @Test
	// public void SubMillisecondsTest_IllegalParamNegativeMJMK() {
	// StopWatch g = new StopWatch("1:01:001");
	// g.sub(-1);
	// Assert.assertEquals(g.getMilliseconds(), 1);
	// }

	@Test(expected = IllegalArgumentException.class)
	public void SubMillisecondsTest_LargeParamMJMK() {
		StopWatch g = new StopWatch("1:51:981");
		g.sub(540000);
	}

	@Test
	public void SubMillisecondsTest_NormalTestSecsMJMK() {
		StopWatch g = new StopWatch("1:51:981");
		g.sub(6000);
		Assert.assertEquals(g.getSeconds(), 45);
	}

	// @Test
	// public void SubMillisecondsTest_TestSecsToZeroMJMK() {
	// StopWatch g = new StopWatch("1:11:981");
	// g.sub(11000);
	// Assert.assertEquals(g.getSeconds(), 0);
	// }

	@Test
	public void SubMillisecondsTest_TestSecsCarryFromMinsMJMK() {
		StopWatch g = new StopWatch("1:11:981");
		g.sub(11982);
		Assert.assertEquals(g.getSeconds(), 59);
	}

	@Test
	public void SubMillisecondsTest_NormalTestMinsMJMK() {
		StopWatch g = new StopWatch("8:11:981");
		g.sub(420000);
		Assert.assertEquals(g.getMinutes(), 1);
	}

	// @Test
	// public void SubStopWatchTest_ToZeroMJMK() {
	// StopWatch g = new StopWatch("2:22:222");
	// StopWatch n = new StopWatch("99:59:999");
	// g.sub(n);
	// Assert.assertEquals(0, g.getMilliseconds());
	// }

	@Test
	public void SubStopWatchTest_CarryFromSecMJMK() {
		StopWatch g = new StopWatch("2:22:222");
		StopWatch n = new StopWatch(223);
		g.sub(n);
		Assert.assertEquals(999, g.getMilliseconds());
	}

	@Test
	public void SubStopWatchTest_CarryFromMinMJMK() {
		StopWatch g = new StopWatch("2:22:222");
		StopWatch n = new StopWatch("2:22:000");
		g.sub(n);
		Assert.assertEquals(222, g.getMilliseconds());
	}

	// @Test
	// public void decTest_PastZeroMJMK() {
	// StopWatch g = new StopWatch(4);
	// int x;
	// for (x = 1; x <= 30; x++) {
	// g.dec();
	// }
	// Assert.assertEquals(0, g.getMilliseconds());
	// }

	@Test
	public void decTest_ToZeroMJMK() {
		StopWatch g = new StopWatch(4);
		int x;
		for (x = 1; x <= 4; x++) {
			g.dec();
		}
		Assert.assertEquals(0, g.getMilliseconds());
	}

	@Test
	public void decTest_CarryFromSecMJMK() {
		StopWatch g = new StopWatch(2, 111);
		int x;
		for (x = 1; x <= 2000; x++) {
			g.dec();
		}
		Assert.assertEquals(111, g.getMilliseconds());
	}

	@Test
	public void incTestMJMK() {
		StopWatch g = new StopWatch(6, 2, 111);
		g.inc();
		Assert.assertEquals(112, g.getMilliseconds());
		// Max Jensen
	}

	@Test
	public void incSecTestMJMK() {
		StopWatch g = new StopWatch(6, 2, 999);
		g.inc();
		Assert.assertEquals(g.toString(), "6:03:000");
		// Max Jensen
	}

	@Test
	public void incMinTestMJMK() {
		StopWatch g = new StopWatch(6, 59, 999);
		g.inc();
		Assert.assertEquals(g.toString(), "7:00:000");
		// Max Jensen
	}

	@Test
	public void suspendTestMJMK() {
		StopWatch g = new StopWatch(1, 1, 1);
		g.suspend(true);
		g.add(1000);
		g.sub(9999);
		g.setMilliseconds(2);
		g.setMinutes(5);
		g.setSeconds(10);
		Assert.assertEquals(g.toString(), "1:01:001");
		// Max Jensen
	}

	@Test
	public void unsuspendTestMJMK() {
		StopWatch g = new StopWatch(1, 1, 1);
		g.suspend(true);
		g.add(1000);
		g.sub(9999);
		g.setMilliseconds(2);
		g.setMinutes(5);
		g.setSeconds(10);
		g.suspend(false);
		g.add(10);
		Assert.assertEquals(g.toString(), "1:01:011");
		// Max Jensen
	}

	@Test
	public void resetTestMJMK() {
		StopWatch g = new StopWatch(1, 1, 1);
		g.reset();
		Assert.assertEquals(g.toString(), "0:00:000");
		// Max Jensen
	}
}
