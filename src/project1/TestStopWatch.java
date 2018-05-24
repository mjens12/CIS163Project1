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
	public void testDefaultConstructor() {
		StopWatch s = new StopWatch();
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 0);
	}

	@Test
	public void testConstructor1Parameter() {
		StopWatch s = new StopWatch(2);
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 0);
		assertTrue(s.getMilliseconds() == 2);
	}

	@Test
	public void testConstructor2Parameters() {
		StopWatch s = new StopWatch(2, 3);
		assertTrue(s.getMinutes() == 0);
		assertTrue(s.getSeconds() == 2);
		assertTrue(s.getMilliseconds() == 3);
	}

	@Test
	public void testConstructor3Parameters() {
		StopWatch s = new StopWatch(2, 3, 4);
		assertTrue(s.getMinutes() == 2);
		assertTrue(s.getSeconds() == 3);
		assertTrue(s.getMilliseconds() == 4);
	}

	@Test
	public void testConstructor() {
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
	public void testnooInput() {
		new StopWatch(12, 61, 1001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnonInput() {
		new StopWatch(12, 61, 14);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnnoInput() {
		new StopWatch(12, 59, 1001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testooInput() {
		new StopWatch(61, 1001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testonInput() {
		new StopWatch(61, 999);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnoInput() {
		new StopWatch(59, 1001);
	}

	// Negative Constructor testing (Max Jensen)
	@Test(expected = IllegalArgumentException.class)
	public void testNegSingleInput2() {
		new StopWatch(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnnParameters() {
		new StopWatch(-1, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnpParameters() {
		new StopWatch(-1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testpnParameters() {
		new StopWatch(-1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnnnParameters() {
		new StopWatch(-1, -1, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnnpParameters() {
		new StopWatch(-1, -1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnpnParameters() {
		new StopWatch(-1, 1, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testppnParameters() {
		new StopWatch(1, 1, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnppParameters() {
		new StopWatch(-1, 1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testpnpParameters() {
		new StopWatch(1, -1, 1);
	}

	// String constructor working testing
	@Test
	public void testStringConst3Params() {
		StopWatch s1 = new StopWatch("5:5:300");
		assertEquals(s1.toString(), "5:05:300");
	}

	@Test
	public void testStringConst2Params() {
		StopWatch s1 = new StopWatch("5:300");
		assertEquals(s1.toString(), "0:05:300");
	}

	@Test
	public void testStringConst1Params() {
		StopWatch s1 = new StopWatch("1");
		assertEquals(s1.toString(), "0:00:001");
	}

	// String constructor under testing (Max Jensen)
	// min sec and milli
	@Test(expected = IllegalArgumentException.class)
	public void testuuuConstructor() {
		new StopWatch("-1:-1:-1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testuunConstructor() {
		new StopWatch("-1:-1:999");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testunnConstructor() {
		new StopWatch("-1:34:999");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnunConstructor() {
		new StopWatch("1:-34:999");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testunuConstructor() {
		new StopWatch("-1:34:-999");
	}

	// sec and milli
	@Test(expected = IllegalArgumentException.class)
	public void testunConstructor() {
		new StopWatch("-34:999");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnuConstructor() {
		new StopWatch("34:-999");
	}

	// milli
	@Test(expected = IllegalArgumentException.class)
	public void testuConstructor() {
		new StopWatch("-999");
	}

	// String constructor over testing (Max Jensen)
	// min sec and milli
	@Test(expected = IllegalArgumentException.class)
	public void testnooConstructor() {
		new StopWatch("2:61:1001");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnnoConstructor() {
		new StopWatch("2:59:1001");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnonConstructor() {
		new StopWatch("2:61:999");
	}

	// sec and milli
	@Test(expected = IllegalArgumentException.class)
	public void testooConstructor() {
		new StopWatch("61:1001");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnoConstructor() {
		new StopWatch("59:1001");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testonConstructor() {
		new StopWatch("61:999");
	}

	// milli
	@Test(expected = IllegalArgumentException.class)
	public void testoConstructor() {
		new StopWatch("1001");
	}

	// String constructor alpha testing (Max Jensen)
	@Test(expected = IllegalArgumentException.class)
	public void testannConstructor() {
		new StopWatch("a:34:999");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnanConstructor() {
		new StopWatch("10:a:999");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnnaConstructor() {
		new StopWatch("15:55:a");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testaaInput() {
		new StopWatch("a:a");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testanInput() {
		new StopWatch("a:15");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testnaInput() {
		new StopWatch("15:a");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testaInput() {
		new StopWatch("a");
	}

	// toString testing (Max Jensen)
	@Test
	public void testminsecmilliToString() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		assertEquals(s1.toString(), "5:59:300");
	}

	@Test
	public void testSecZeroesToString() {
		StopWatch s1 = new StopWatch(5, 5, 300);
		assertEquals(s1.toString(), "5:05:300");
	}

	@Test
	public void testMilliZeroesToString() {
		StopWatch s1 = new StopWatch(5, 59, 1);
		assertEquals(s1.toString(), "5:59:001");
	}

	@Test
	public void testsecmilliToString() {
		StopWatch s1 = new StopWatch(59, 300);
		assertEquals(s1.toString(), "0:59:300");
	}

	@Test
	public void testMinZeroesToString() {
		StopWatch s1 = new StopWatch(1, 0, 300);
		assertEquals(s1.toString(), "1:00:300");
	}

	@Test
	public void testmilliToString() {
		StopWatch s1 = new StopWatch(300);
		assertEquals(s1.toString(), "0:00:300");
	}

	@Test
	public void testMilli1ToString() {
		StopWatch s1 = new StopWatch(0, 0, 1);
		assertEquals(s1.toString(), "0:00:001");
	}

	@Test
	public void testMilli10ToString() {
		StopWatch s1 = new StopWatch(0, 0, 10);
		assertEquals(s1.toString(), "0:00:010");
	}

	@Test
	public void testMilli100ToString() {
		StopWatch s1 = new StopWatch(0, 0, 100);
		assertEquals(s1.toString(), "0:00:100");
	}

	@Test
	public void testSec1ToString() {
		StopWatch s1 = new StopWatch(0, 1, 00);
		assertEquals(s1.toString(), "0:01:000");
	}

	@Test
	public void testSec10ToString() {
		StopWatch s1 = new StopWatch(0, 10, 00);
		assertEquals(s1.toString(), "0:10:000");
	}

	@Test
	public void testMin1ToString() {
		StopWatch s1 = new StopWatch(1, 0, 00);
		assertEquals(s1.toString(), "1:00:000");
	}

	@Test
	public void testMin10ToString() {
		StopWatch s1 = new StopWatch(10, 0, 00);
		assertEquals(s1.toString(), "10:00:000");
	}

	@Test
	public void testMin100ToString() {
		StopWatch s1 = new StopWatch(100, 0, 00);
		assertEquals(s1.toString(), "100:00:000");
	}

	@Test
	public void testAllZeroesToString() {
		StopWatch s1 = new StopWatch(0, 0, 0);
		assertEquals(s1.toString(), "0:00:000");
	}

	@Test
	public void testAddMethod() {
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
	public void testEqual() {
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
	public void testLoadSave() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(5, 59, 300);

		s1.save("file1");
		s1 = new StopWatch(); // resets to zero

		s1.load("file1");
		assertTrue(s1.equals(s2));
	}

	@Test
	public void testMutate() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(5, 59, 300);

		StopWatch.suspend(true);
		s1.add(1000);
		assertTrue(s1.equals(s2));
		StopWatch.suspend(false);
	}

	@Test
	public void equalsTest() {
		StopWatch s1 = new StopWatch(5, 59, 300);
		StopWatch s2 = new StopWatch(5, 59, 300);

		assertEquals(s1, s2);
	}

	@Test
	public void StopWatchStartTime() {
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
	public void testEqualsObjectOther() {
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
	public void testEqualsStopWatch() {
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
	public void testCompareTo() {
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
	public void AddTest_LargeParam() {
		StopWatch f = new StopWatch("0:00:000");
		f.add(9000000);
		assertEquals(f.toString(), "150:00:000");
	}

	// RS
	@Test(expected = IllegalArgumentException.class)
	public void AddTest_Neg1() {
		StopWatch f = new StopWatch("50:50:050");
		f.add(-10);
	}

	// RS
	@Test
	public void AddTest_AddZero() {
		StopWatch f = new StopWatch("20:30:050");
		f.add(0);
		assertEquals(f.toString(), "20:30:050");
	}

	@Test
	public void AddStopWatchTest_Normal() {
		StopWatch f = new StopWatch("0:0:0");
		StopWatch bg = new StopWatch(59, 599);
		f.add(bg);
		assertEquals(f.toString(), "0:59:599");
	}

	@Test
	public void SubMilliseconds_NormalTest() {
		StopWatch g = new StopWatch(1, 122);
		g.sub(22);
		Assert.assertEquals(g.getMilliseconds(), 100);
	}

	@Test
	public void SubMilliseconds_BorrowFromSeconds() {
		StopWatch g = new StopWatch(1, 2);
		g.sub(3);
		Assert.assertEquals(g.getMilliseconds(), 999);
	}

	@Test(expected = IllegalArgumentException.class)
	public void SubMillisecondsTest_ToZeroOverflow() {
		StopWatch g = new StopWatch(2);
		g.sub(5);
	}

	@Test
	public void SubMillisecondsTest_BorrowFromMins() {
		StopWatch g = new StopWatch("21:51:001");
		g.sub(50501);
		Assert.assertEquals(g.getMilliseconds(), 500);
	}

	@Test
	public void SubMillisecondsTest_BorrowFromMinsToZero() {
		StopWatch g = new StopWatch("1:01:001");
		g.sub(61001);
		Assert.assertEquals(g.getMilliseconds(), 0);
	}

	// @Test
	// public void SubMillisecondsTest_IllegalParamNegative() {
	// StopWatch g = new StopWatch("1:01:001");
	// g.sub(-1);
	// Assert.assertEquals(g.getMilliseconds(), 1);
	// }

	@Test(expected = IllegalArgumentException.class)
	public void SubMillisecondsTest_LargeParam() {
		StopWatch g = new StopWatch("1:51:981");
		g.sub(540000);
	}

	@Test
	public void SubMillisecondsTest_NormalTestSecs() {
		StopWatch g = new StopWatch("1:51:981");
		g.sub(6000);
		Assert.assertEquals(g.getSeconds(), 45);
	}

	// @Test
	// public void SubMillisecondsTest_TestSecsToZero() {
	// StopWatch g = new StopWatch("1:11:981");
	// g.sub(11000);
	// Assert.assertEquals(g.getSeconds(), 0);
	// }

	@Test
	public void SubMillisecondsTest_TestSecsCarryFromMins() {
		StopWatch g = new StopWatch("1:11:981");
		g.sub(11982);
		Assert.assertEquals(g.getSeconds(), 59);
	}

	@Test
	public void SubMillisecondsTest_NormalTestMins() {
		StopWatch g = new StopWatch("8:11:981");
		g.sub(420000);
		Assert.assertEquals(g.getMinutes(), 1);
	}

	// @Test
	// public void SubStopWatchTest_ToZero() {
	// StopWatch g = new StopWatch("2:22:222");
	// StopWatch n = new StopWatch("99:59:999");
	// g.sub(n);
	// Assert.assertEquals(0, g.getMilliseconds());
	// }

	@Test
	public void SubStopWatchTest_CarryFromSec() {
		StopWatch g = new StopWatch("2:22:222");
		StopWatch n = new StopWatch(223);
		g.sub(n);
		Assert.assertEquals(999, g.getMilliseconds());
	}

	@Test
	public void SubStopWatchTest_CarryFromMin() {
		StopWatch g = new StopWatch("2:22:222");
		StopWatch n = new StopWatch("2:22:000");
		g.sub(n);
		Assert.assertEquals(222, g.getMilliseconds());
	}

	// @Test
	// public void decTest_PastZero() {
	// StopWatch g = new StopWatch(4);
	// int x;
	// for (x = 1; x <= 30; x++) {
	// g.dec();
	// }
	// Assert.assertEquals(0, g.getMilliseconds());
	// }

	@Test
	public void decTest_Normal() {
		StopWatch g = new StopWatch(14);
		g.dec();
		Assert.assertEquals(13, g.getMilliseconds());
	}

	@Test
	public void decTest_ToZero() {
		StopWatch g = new StopWatch(4);
		int x;
		for (x = 1; x <= 4; x++) {
			g.dec();
		}
		Assert.assertEquals(0, g.getMilliseconds());
	}

	@Test
	public void decTest_CarryFromSec() {
		StopWatch g = new StopWatch(2, 111);
		int x;
		for (x = 1; x <= 2000; x++) {
			g.dec();
		}
		Assert.assertEquals(111, g.getMilliseconds());
	}

	@Test
	public void incTest() {
		StopWatch g = new StopWatch(6, 2, 111);
		g.inc();
		Assert.assertEquals(112, g.getMilliseconds());
		// Max Jensen
	}

	@Test
	public void incSecTest() {
		StopWatch g = new StopWatch(6, 2, 999);
		g.inc();
		Assert.assertEquals(g.toString(), "6:03:000");
		// Max Jensen
	}

	@Test
	public void incMinTest() {
		StopWatch g = new StopWatch(6, 59, 999);
		g.inc();
		Assert.assertEquals(g.toString(), "7:00:000");
		// Max Jensen
	}

	@Test
	public void suspendTest() {
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
	public void unsuspendTest() {
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
	public void resetTest() {
		StopWatch g = new StopWatch(1, 1, 1);
		g.reset();
		Assert.assertEquals(g.toString(), "0:00:000");
		// Max Jensen
	}
}
