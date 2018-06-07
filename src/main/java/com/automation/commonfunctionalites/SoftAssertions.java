package com.automation.commonfunctionalites;

import org.testng.Assert;
import org.testng.Reporter;

import com.mchange.util.AssertException;

public class SoftAssertions {
	public static int isAnyAssertFail = 0;
	public static Throwable exp;

	// Verifying the results
	public static void verifyEqualsApi(Object actual, Object expected, String successMessage, String failureMessage) {
		try {
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			Assert.assertEquals(actual, expected);
			printLogs("<font color = \"#006400\">PASS : " + successMessage + "</font>");
		} catch (Throwable e) {
			isAnyAssertFail++;
			System.out.println(
					"FAIL : " + failureMessage + " Expected Result : " + expected + " Actual Result : " + actual);
			printLogs("<font color = \"ff0000\">FAIL : " + failureMessage + " Expected Result : " + expected
					+ " Actual Result : " + actual + "</font>");
			e.printStackTrace();
			printLogs("Detailed:" + e);
			if (isAnyAssertFail == 1)
				exp = e;
		}
	}

	public static void throwAsserationOnFailure() {
		if (isAnyAssertFail > 0) {
			isAnyAssertFail = 0;
			exp.printStackTrace();
			throw new AssertException(exp.toString());
		}
	}

	public static void printInfoMSG(String msg) {
		printLogs("<font color = \"#FF892E\">PASS : " + msg + "</font>");
	}

	public static void printLogs(String msg) {
		Reporter.log(msg);
	}

	public static void drawLine() {
		printLogs("------------------------------------------");
	}

}
