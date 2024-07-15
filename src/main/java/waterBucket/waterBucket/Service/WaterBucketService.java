package waterBucket.waterBucket.Service;
import org.springframework.stereotype.Service;
import waterBucket.waterBucket.Model.Solution;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

    @Service
    public class WaterBucketService {
      public WaterJugResponse solveWaterJug(WaterJugRequest request) {
        int x = request.getBucketX();
        int y = request.getBucketY();
        int z = request.getZAmountWanted();

        List<String> solution = new ArrayList<>();
        if (z > Math.max(x, y) || z % gcd(x, y) != 0) {
            solution.add("No solution possible.");
            return new WaterJugResponse(solution);
        }

        solve(x, y, z, solution);
        return new WaterJugResponse(solution);
    }

    private void solve(int x, int y, int z, List<String> solution) {
        int a = 0, b = 0;
        while (a != z && b != z) {
            if (a == 0) {
                a = x;
                solution.add(String.format("Fill bucket X (%d, %d)", a, b));
            } else if (b == y) {
                b = 0;
                solution.add(String.format("Empty bucket Y (%d, %d)", a, b));
            } else {
                int transfer = Math.min(a, y - b);
                a -= transfer;
                b += transfer;
                solution.add(String.format("Transfer from X to Y (%d, %d)", a, b));
            }
        }
        solution.add("Solved");
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
