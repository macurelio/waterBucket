package waterBucket.waterBucket.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import waterBucket.waterBucket.Model.Solution;
import waterBucket.waterBucket.Service.WaterBucketService;
import java.util.List;
import java.util.Map;

    @RestController
    @RequestMapping("/api/water-jug")
    public class WaterBucketController {

        @Autowired
        private WaterBucketService waterJugService;

        @PostMapping("/solve")
        public ResponseEntity<?> solveWaterJugRiddle(@RequestBody Map<String, Integer> request) {
            int xCapacity = request.get("x_capacity");
            int yCapacity = request.get("y_capacity");
            int zAmountWanted = request.get("z_amount_wanted");

            // Validación de entradas
            if (xCapacity <= 0 || yCapacity <= 0 || zAmountWanted <= 0) {
                return ResponseEntity.badRequest().body(Map.of("error", "All capacities and the target amount must be positive integers."));
            }

            List<Solution> solution = waterJugService.solveWaterJugProblem(xCapacity, yCapacity, zAmountWanted);
            if (solution.isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("error", "No solution possible"));
            }
            return ResponseEntity.ok(Map.of("solution", solution));
        }
    }

