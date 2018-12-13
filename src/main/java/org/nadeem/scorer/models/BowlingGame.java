package org.nadeem.scorer.models;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

	private List<Frame> frames = new ArrayList<Frame>();
	private List<Character> bonusRolls = new ArrayList<Character>();

	private int score;

	/**
	 * BowlingGame: Initialize Game with Frame and also check is Bonus Rolls exist
	 * 
	 * @param rolls
	 */
	public BowlingGame(String rolls) {
		initializeFrames(rolls);
		checkBonusRolls(rolls);
	}

	public BowlingGame() {
		// TODO Auto-generated constructor stub
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Frame> getFrames() {
		return frames;
	}

	/**
	 * Calculate Score of the game
	 */
	public void calculateScore() {

		try {
			// Calculate Score for the 10 frames
			for (int i = 0; i < 10; i++) {

				Frame frame = frames.get(i);
				for (Character roll : frame.getRolls()) {
					score += pointForScore(roll);
				}

				// If the Frame contains a Spare then add the score of the next roll (i.e 1st
				// Roll of Next Frame)
				// Do not Add score if the frame is the 10th Frame as that would be added as
				// part of bonus rolls
				if (frame.isFrameSpare() && i != 9) {
					score += pointForScore(frames.get(i + 1).getRolls().get(0));
				}

				// If the Frame contains a Strike then add the score of the next 2 roll
				// Do not add score if the frame is the 10th Frame as that would be added as
				// part of bonus rolls
				if (frame.isFrameStrike() && i < 9) {

					Frame nextFrame = frames.get(i + 1);

					// Check if the next frame contains a Strike
					if (nextFrame.isFrameStrike()) {

						// If it contains a Strike then We have to add score of 1st rolls of next 2
						// frames
						for (Character roll : nextFrame.getRolls()) {
							score += pointForScore(roll);
						}

						// Check if this is not the 9th Frame then add rolls of the nextToNext Frame
						if (i < 8) {
							Frame nextToNextFrame = frames.get(i + 2);
							score += pointForScore(nextToNextFrame.getRolls().get(0));
						} else
							// If this is the 9th Frame then nextToNext Frame does not exist and so add the
							// 1st Bonus Roll Score
							score += pointForScore(bonusRolls.get(0));

					} else {
						// If the Next Frame is not having a Strike then add score of the 2 rolls
						for (Character roll : nextFrame.getRolls()) {
							score += pointForScore(roll);
						}
					}
				}
			}

			// Add Score of bonus balls awarded after the final frame.
			for (Character roll : bonusRolls) {
				score += pointForScore(roll);
			}

		} catch (Exception e) {
			System.err.println("Error in calculateScore - Error = " + e);
			e.printStackTrace();
		}

	}
	/**
	 * pointForScore : Returns the integer Score for given Roll. Return 10 for X, 0 for - and Corresponding Integer for 1-9
	 * @param roll
	 * @return
	 * @throws Exception
	 */
	private int pointForScore(char roll) throws Exception {
		if (roll == 'X')
			return 10;
		if (roll == '-')
			return 0;
		else
			return Integer.parseInt(roll + "");
	}

	/***
	 * initializeFrames: Iterate through all the rolls and create frames of the game
	 * @param rolls: Takes input as rolls of the game
	 */
	private void initializeFrames(String rolls) {
		try {
			int rollsLength = rolls.length();
			Frame frame = new Frame();
			
			// Iterate though all the rolls
			for (int i = 0; i < rollsLength; i++) {

				//Add roll to the frame
				if (frame.addRoll(rolls.charAt(i))) {
					
					//if Add Roll returns true then Frame is complete. Add Frame to the game and create new Frame
					frames.add(frame);
					if (frames.size() < 10)
						frame = new Frame();
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Check if there are Bonus Rolls
	private void checkBonusRolls(String rolls) {
		if (rolls.charAt(rolls.length() - 2) == '/')
			bonusRolls.add(rolls.charAt(rolls.length() - 1));

		if (rolls.charAt(rolls.length() - 3) == 'X') {
			bonusRolls.add(rolls.charAt(rolls.length() - 2));
			bonusRolls.add(rolls.charAt(rolls.length() - 1));
		}

	}

}
