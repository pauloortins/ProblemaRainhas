package tests;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import solution.Board;
import solution.Challenge;

public class ChallengeTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
		Challenge challenge = new Challenge(new Board(Board.createBoard()));
		
		challenge.solveChallenge();
		
		Assert.assertEquals(0,challenge.getBoard().countNumberOfAttacks());
	}

}
