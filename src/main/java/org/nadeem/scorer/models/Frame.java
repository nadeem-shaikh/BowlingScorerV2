package org.nadeem.scorer.models;

import java.util.ArrayList;
import java.util.List;

public class Frame {

	private List<Character> rolls = new ArrayList<Character>();
	private boolean isFrameFilled;
	private boolean isFrameSpare;
	private boolean isFrameStrike;
	
	
	public List<Character> getRolls() {
		return rolls;
	}


	public boolean isFrameFilled() {
		return isFrameFilled;
	}


	public boolean isFrameSpare() {
		return isFrameSpare;
	}


	public boolean isFrameStrike() {
		return isFrameStrike;
	}




	/***
	 * addRoll: Adds roll to the frame. Checks if Frame contains Spare or Strike and
	 * if Frame is filled.
	 * 
	 * @param roll: Take roll as input parameter
	 * @return True if the frame is filled so as to indicate no more rolls can be
	 *         added to the frame
	 */
	public boolean addRoll(char roll) {
		// Add Roll to the frame only if Frame is not filled
		if (!isFrameFilled) {
			// if Rolls contains a Spare then set isFrameSpare to true and set the roll
			if (Character.toString(roll).equals("/")) {
				isFrameSpare = true;
				int intRoll = (10 - Integer.parseInt(rolls.get(0).toString()));
				rolls.add(Integer.toString(intRoll).charAt(0));
			}

			// if rolls contains Strike then set isFrameStrike to true and add - roll to the
			// frame
			else if (Character.toString(roll).equals("X")) {
				isFrameStrike = true;
				rolls.add(roll);
				rolls.add(("-").charAt((0)));
			} else {
				rolls.add(roll);
			}

			// if the frame contains 2 rolls then set isFrameFilled to true
			if (rolls.size() > 1) {
				this.isFrameFilled = true;
			}
		}

		return isFrameFilled;
	}

}
