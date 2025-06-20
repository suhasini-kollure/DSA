package coderpad;

/*You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps.
This is the Fibonacci sequence problem: ways(n) = ways(n-1) + ways(n-2)
Because from step n, you could have come from:
n-1 (1 step) OR
n-2 (2 steps) */

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 2) return n;

        int oneStepBefore = 2;
        int twoStepsBefore = 1;
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = result;
        }

        return result;
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        int n = 5;
        System.out.println("Ways to climb " + n + " stairs: " + cs.climbStairs(n));
    }
}

