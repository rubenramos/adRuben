package org.institutoserpis.ad;

import static org.junit.Assert.*;

import org.junit.Test;

public class VectorTest {

	@Test
	public void testMin() {
		int[] vector = new int [] {11, 24, 89, 25, 19};
		int numMenor = Vector.min(vector);
		
		assertEquals(1, Vector.min(new int[] {11, 24, 1, 25, 19}));
		assertEquals(16, Vector.min(new int[] {16, 24, 89, 25, 19}));
		assertEquals(4, Vector.min(new int[] {11, 24, 89, 25, 4}));
	}
	
	@Test
	public void testMinEmpty() {
		Vector.min(new int[]{});
	}

}
