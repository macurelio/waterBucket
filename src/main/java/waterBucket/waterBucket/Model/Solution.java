package waterBucket.waterBucket.Model;
import lombok.AllArgsConstructor;
import lombok.Data;

    @Data
    @AllArgsConstructor
    public class Solution {
        private int step;
        private int bucketX;
        private int bucketY;
        private int zAmountWanted;
        private String action;
    }

