package org.nadeem.BowlingScorer;

import org.junit.Before;
import org.nadeem.BowlingScorer.models.BowlingGame;
import org.nadeem.BowlingScorer.utilities.ErrorResponse;

import junit.framework.TestCase;

public class BowlingGameTest  extends TestCase{
	
	@Before
	public void setUp() throws Exception {
		ErrorResponse.getInstance().setErrorExists(false);
	}


	/**
	 * Test Game Score for Sample Rolls which contains 12 rolls : 12 Strikes = 10
	 * frames * 30 points = 300
	 */
	public void testAppForAllStrikes() {

		String rolls = "XXXXXXXXXXXX";
		BowlingGame game = new BowlingGame(rolls);
		game.calculateScore();
		System.out.println("Game Score is - " + game.getScore());
		assertEquals(game.getScore(), 300);
	}

	/**
	 * Test Game Score for Sample Rolls which contains 20 rolls : 10 pairs of 9 and
	 * miss = 10 frames * 9 points = 90
	 */
	public void testAppForNineAndMiss() {

		String rolls = "9-9-9-9-9-9-9-9-9-9-";
		BowlingGame game = new BowlingGame(rolls);
		game.calculateScore();
		System.out.println("Game Score is - " + game.getScore());
		assertEquals(game.getScore(), 90);
	}

	/**
	 * Test Game Score for Sample Rolls which contains 21 rolls : 10 pairs of 5 and
	 * spare, with a final 5 = 10 frames * 15 points = 150
	 */
	public void testAppForFiveAndSpare() {

		String rolls = "5/5/5/5/5/5/5/5/5/5/5";
		BowlingGame game = new BowlingGame(rolls);
		game.calculateScore();
		System.out.println("Game Score is - " + game.getScore());
		assertEquals(game.getScore(), 150);
	}

	public void testAppForSamples() {
		String rolls = "5/5/5/5/5/5/5/5/5/6/3";
		BowlingGame game = new BowlingGame(rolls);
		game.calculateScore();
		System.out.println("Game Score is - " + game.getScore());
		assertEquals(game.getScore(), 149);

		rolls = "XXXXXXXXXX81";
		game = new BowlingGame(rolls);
		game.calculateScore();
		System.out.println("Game Score is - " + game.getScore());
		assertEquals(game.getScore(), 287);

		rolls = "X81XXXXXXXXXX";
		game = new BowlingGame(rolls);
		game.calculateScore();
		System.out.println("Game Score is - " + game.getScore());
		assertEquals(game.getScore(), 268);

		rolls = "X8/XXXXXXXXXX";
		game = new BowlingGame(rolls);
		game.calculateScore();
		System.out.println("Game Score is - " + game.getScore());
		assertEquals(game.getScore(), 280);
	}
}

