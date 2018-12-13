package org.nadeem.BowlingScorer;

import org.nadeem.scorer.models.Frame;

import junit.framework.TestCase;

public class FrameTest extends TestCase{

	/**
	 * Test addRoll Method of Frame
	 */
	public void testAddRoll() {

		Frame frame = new Frame();

		//When adding roll for the first time in frame, it will return false as frame is not complete
		assertEquals(frame.addRoll('5'), false);
		
		//When adding roll for Second time in frame, it will return true as frame is not complete
		assertEquals(frame.addRoll('6'), true);
		
		//Create new Frame
		frame = new Frame();
		
		//Add Strike Roll to Frame
		frame.addRoll('X');
		assertEquals(frame.isFrameStrike(), true);
		
		//Create new Frame
		frame = new Frame();
		//Add  Roll to Frame
		frame.addRoll('4');
		
		//Add Spare to Frame
		frame.addRoll('/');
		assertEquals(frame.isFrameSpare(), true);

	}

}