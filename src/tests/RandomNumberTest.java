package tests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import solution.RandomNumber;

public class RandomNumberTest {

	@Test
	public void generateRandomNumberTest() {
		int intervaloNumerosAleatorios = 15;
		
		int result = RandomNumber.generateRandomNumber(intervaloNumerosAleatorios);
		
		Assert.assertTrue(result >= 0 && result <= 15);
	}
	
	@Test
	public void generateAllPossibleNumbers()
	{
		List<Integer> listaInts = new ArrayList<Integer>();
		int intervaloMaximo = 15;
		
		for (int i = 0; i < 1000; i++) {
			listaInts.add(RandomNumber.generateRandomNumber(intervaloMaximo));
		}
		
		for (int i = 0; i < intervaloMaximo; i++) {
			if (!listaInts.contains(i + 1)) 
			{
				Assert.assertTrue(false);
			}
		}
		
		Assert.assertTrue(true);
	}
}
