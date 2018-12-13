package org.nadeem.BowlingScorer;

import org.junit.Before;
import org.nadeem.scorer.utilities.ErrorResponse;
import org.nadeem.scorer.utilities.Validator;

import junit.framework.TestCase;

import org.junit.Assert;

/**
 * Unit test for American Ten Pin Bowling Application
 */
public class AppTest extends TestCase {

	@Before
	public void setUp() throws Exception {
		ErrorResponse.getInstance().setErrorExists(false);
	}

	/**
	 * Test Case for Validating App Arguments)
	 */
	public void testValidAppArguments() {

		try {
			// Pass Score as App Argument
			String[] args = { "5/5/5/5/5/5/5/5/5/6/5" };

			// Validate App Arguments
			Validator.getInstance().validateAppArguments(args);

			// As argument provided is valid, errorExists should be false
			assertEquals(ErrorResponse.getInstance().getErrorExists(), false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}

	}

	/**
	 * Test Case for Validating App Arguments)
	 */
	public void testInvalidAppArguments() {
		try {

			// Pass Score as App Argument
			String[] args = {};

			// Validate App Arguments
			Validator.getInstance().validateAppArguments(args);

			// As argument provided is invalid, errorExists should be true
			assertEquals(ErrorResponse.getInstance().getErrorExists(), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}

	}

	/**
	 * Test Case for Invalid Character "0" in rolls
	 */
	public void testInvalidCharZeroInRolls() {

		try {
			// Initialize rolls with values containing invalid character 0
			String rolls = "XXXXX0XXXXXX";
			// Validate App Arguments
			Validator.getInstance().validateRolls(rolls);

			// As rolls contain invalid character, errorExists should be true
			assertEquals(ErrorResponse.getInstance().getErrorExists(), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}

	}

}