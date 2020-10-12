package codility.maxCounter;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {

    public int[] solution(int N, int[] A) { // 3,4,4,6,1,4,4
        // write your code in Java SE 8
        int [] result = new int[N];
        int maxValue=0;
        int minValue=0;

        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            if (value == N + 1) {
                minValue=maxValue;
            } else {
                int index = value - 1;
                if(result[index] < minValue) {
                    result[index] = minValue ;
                }
                result[index]++;
                if (result[index] > maxValue) {
                    maxValue = result[index];
                }
            }
        }
        for (int j = 0; j < result.length; j++) {
            if(result[j]<minValue){
                result[j] = minValue;
            }
        }
        return  result;
    }

    @Test
    public void test1 () {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new int[]{3, 2, 2, 4, 2},s.solution(5, new int[] {3,4,4,6,1,4,4}));
    }
}

/* Brute Force - Working
    public int[] solution(int N, int[] A) { // 3,4,4,6,1,4,4
        // write your code in Java SE 8
        int [] result = new int[N];
        int maxValue=0;

        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            if (value == N + 1) {
                for (int j = 0; j < result.length; j++) {
                    result[j] = maxValue;
                }
            } else {
                int index = value - 1;
                result[index]++;
                if (result[index] > maxValue) {
                    maxValue = result[index];
                }
            }
        }
        return  result;
    }

*/

