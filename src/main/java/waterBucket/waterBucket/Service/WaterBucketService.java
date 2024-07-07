package waterBucket.waterBucket.Service;
import org.springframework.stereotype.Service;
import waterBucket.waterBucket.Model.Solution;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

    @Service
    public class WaterBucketService {
        public List<Solution> solveWaterJugProblem(int xCapacity, int yCapacity, int zAmountWanted) {
            List<Solution> solutionSteps = new ArrayList<>();
            Set<String> visitedStates = new HashSet<>();

            if (zAmountWanted > xCapacity && zAmountWanted > yCapacity) {
                return solutionSteps; // No solution if the target is greater than both jug capacities
            }

            int bucketX = 0, bucketY = 0;
            int step = 1;

            while (bucketX != zAmountWanted) {
                String state = bucketX + "," + bucketY;
                if (visitedStates.contains(state)) {
                    return new ArrayList<>(); // No solution, detected cycle
                }
                visitedStates.add(state);

                if (bucketX == 0) {
                    bucketX = xCapacity;
                    solutionSteps.add(new Solution(step++, bucketX, bucketY, "Fill bucket X"));
                } else if (bucketY == yCapacity) {
                    bucketY = 0;
                    solutionSteps.add(new Solution(step++, bucketX, bucketY, "Empty bucket Y"));
                } else {
                    int transfer = Math.min(bucketX, yCapacity - bucketY);
                    bucketX -= transfer;
                    bucketY += transfer;
                    solutionSteps.add(new Solution(step++, bucketX, bucketY, "Transfer from bucket X to Y"));
                }

                if (bucketX == zAmountWanted || bucketY == zAmountWanted) {
                    solutionSteps.add(new Solution(step++, bucketX, bucketY, "Solved"));
                    break;
                }
            }
            return solutionSteps;
        }
    }

