package tests;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import solution.Queen;

public class QueenTest {
	
	@Test
	public void moveQueenToLeft()
	{
		Queen queen = new Queen(2, 7);
		
		queen.move(6);
		
		Assert.assertEquals(2, queen.getRowNumber());
		Assert.assertEquals(6, queen.getColumnNumber());
	}

}
