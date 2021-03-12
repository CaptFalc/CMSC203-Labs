import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class GradeBookTest {
	private GradeBook grade1;
	private GradeBook grade2;
	@BeforeEach
	void setUp() throws Exception {
			grade1 = new GradeBook(5);
			grade2 = new GradeBook(5);
			
			grade1.addScore(45);
			grade1.addScore(95);
			grade1.addScore(31);
			grade1.addScore(36);
			grade1.addScore(38);
			
			grade2.addScore(43);
			grade2.addScore(14);
			grade2.addScore(9);
			grade1.addScore(21);
			grade1.addScore(11);
	}

	@AfterEach
	void tearDown() throws Exception {
		grade1 = null;
		grade2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(grade1.toString().equals("45.0 95.0 31.0 36.0 38.0"));
		assertTrue(grade2.toString().equals("43.0 14.0 9.0 21.0 11.0"));

	}

	@Test
	void testSum() {
		assertEquals(245, grade1.sum(), .0001);
		assertEquals(98, grade1.sum(), .0001);
		
	}

	@Test
	void testMinimum() {
		assertEquals(31, grade1.minimum(), .001);
		assertEquals(9, grade2.minimum(), .001);

	}

	@Test
	void testFinalScore() {
		assertEquals(214, grade1.finalScore(), .001);
		assertEquals(89, grade2.finalScore(), .001);
	}

	@Test
	void testGetScoreSize() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}