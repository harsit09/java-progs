public class EggDropping {
    public static int eggDrop(int eggs, int floors) {
        int[][] dp = new int[eggs + 1][floors + 1];

        // Fill for one egg
        for (int i = 1; i <= floors; i++) dp[1][i] = i;

        // Fill for all eggs
        for (int e = 2; e <= eggs; e++) {
            for (int f = 1; f <= floors; f++) {
                dp[e][f] = Integer.MAX_VALUE;
                for (int x = 1; x <= f; x++) {
                    int attempts = 1 + Math.max(dp[e - 1][x - 1], dp[e][f - x]);
                    dp[e][f] = Math.min(dp[e][f], attempts);
                }
            }
        }
        return dp[eggs][floors];
    }

    public static void main(String[] args) {
        int eggs = 2, floors = 10;
        System.out.println("Minimum attempts: " + eggDrop(eggs, floors));
    }
}
