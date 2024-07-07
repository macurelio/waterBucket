package waterBucket.waterBucket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import waterBucket.waterBucket.Model.Solution;
import waterBucket.waterBucket.Service.WaterBucketService;

@SpringBootTest
class WaterBucketApplicationTests{

	@Autowired
	private WaterBucketService waterJugService;

	@Test
	void testSolveWaterJugProblem_validSolution1() {
		List<Solution> solution = waterJugService.solveWaterJugProblem(3, 5, 4);
		assertTrue(!solution.isEmpty());
		assertEquals("Solved", solution.get(solution.size() - 1).getAction());
	}

	@Test
	void testSolveWaterJugProblem_validSolution2() {
		List<Solution> solution = waterJugService.solveWaterJugProblem(2, 10, 4);
		assertTrue(!solution.isEmpty());
		assertEquals("Solved", solution.get(solution.size() - 1).getAction());
	}


	@Test
	void testSolveWaterJugProblem_validSolution3() {
		List<Solution> solution = waterJugService.solveWaterJugProblem(6, 8, 4);
		assertTrue(!solution.isEmpty());
		assertEquals("Solved", solution.get(solution.size() - 1).getAction());
	}

	@Test
	void testSolveWaterJugProblem_validSolution4() {
		List<Solution> solution = waterJugService.solveWaterJugProblem(7, 11, 6);
		assertTrue(!solution.isEmpty());
		assertEquals("Solved", solution.get(solution.size() - 1).getAction());
	}

	@Test
	void testSolveWaterJugProblem_edgeCase_noSolution() {
		List<Solution> solution = waterJugService.solveWaterJugProblem(2, 6, 5);
		assertTrue(solution.isEmpty());
	}
}
