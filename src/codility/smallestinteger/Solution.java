package codility.smallestinteger;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int n = A.length;
        int max=0 ;
        // find max positive integer.
        for (int i = 0; i < n ; i++) {
            if(max < A[i]){
                max = A[i];
            }
        }
        // if none found return 1.
        if (max == 0){
            return 1;
        }
        boolean[] numbers = new boolean [max+1];
// find from 1 to max -- List
// iterate over array and mark true is number exists
        for (int i = 0; i < n; i++) {
            if(A[i] > 0){
                numbers[A[i]]=true;
            }
        }
// loop over the list and find smallest false index.
        for (int i = 1; i < max+1; i++) {
            if(!numbers[i]){
                return i;
            }
        }
        return max+1;
// if none is true then return max + 1;

    }

    @Test
    public void test () {
        Solution s = new Solution();
        Assertions.assertEquals(5, s.solution( new int [] {1, 3, 6, 4, 1, 2}));
    }
}
