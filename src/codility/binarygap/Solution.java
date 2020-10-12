package codility.binarygap;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.stream.IntStream;

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        String binaryRep = Integer.toBinaryString(N);
        char [] binaryNum = binaryRep.toCharArray();

        int maxBGap = 0;
        for (int i = 0, currentGap=0; i < binaryNum.length; i++) {
             if(binaryNum[i]=='1'){
                 if(currentGap > maxBGap){
                     maxBGap = currentGap;
                 }
                 currentGap=0;
             }
             if(binaryNum[i]=='0'){
                 currentGap++;
             }
        }

        return maxBGap;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(Integer.MAX_VALUE));
        System.out.println(s.solution(1047));
        System.out.println(s.solution(32));
        System.out.println(s.solution(9));
    }
}

