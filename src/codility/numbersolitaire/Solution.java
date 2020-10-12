package codility.numbersolitaire;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class Solution {
    public int solution(int[] A) {
        int dp[] = new int [A.length];
        dp[0]=A[0];
        for (int i=1; i < A.length; i++){

            int max = Integer.MIN_VALUE;

            for (int die = 1; die <=6 ; die++) {
                if(i-die>=0){
                    max = Math.max(dp[i-die]+A[i],max);
                }
            }
            dp[i]=max;
        }
        return dp[A.length-1];
    }

    public int solutionBruteForce(int[] A) {
        // write your code in Java SE 8

        int hop=0,currentHop=0;
        int n = A.length;
        int maximalSum = A[0];

        do {
            int maxInt = Integer.MIN_VALUE;
            currentHop = hop;
            for (int i = currentHop + 1; i <= currentHop + 6; i++) {
                if (i == n - 1 || A[i] > 0) {
                    hop = i;
                    break;
                } else if (maxInt < A[i]) {
                    hop = i;
                    maxInt = A[i];
                }
            }
            //System.out.println(A[hop]);
            maximalSum += A[hop];
        } while (hop!=n-1);

        return  maximalSum ;
    }

    @Test
    public void test1 () {
        Solution s = new Solution();
        Assertions.assertEquals(-12,s.solution(new int[] {0, -4, -5, -2, -7, -9, -3, -10}));
    }
}
