package rbctest.frogJump;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'jumpingFrog' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER jumpLength
     *  2. INTEGER riverLength
     *  3. INTEGER_ARRAY leaves
     */
	static boolean logs = false;

    public static int jumpingFrog(int jumpLength, int riverLength, List<Integer> leaves) {
    	int currentPosition =0;
    	int previousPosition =0;
    	boolean[] hasLeaf = new boolean[riverLength];
    	
    	for(int t=0;currentPosition + jumpLength < riverLength ;t++) {
    		previousPosition = currentPosition;
    		if( t<leaves.size()) {
    			hasLeaf[leaves.get(t)] = true;
   			}
   			if(logs) {
   				System.out.println("Current position "+ currentPosition);
   				System.out.println("Leaf Dropped on position "+ leaves.get(t) +" at " + (t+1) + " seconds" );
   			}			
    		for(int i=jumpLength; i >=1; i--) {
    			if (hasLeaf[i+currentPosition]) {
    				currentPosition += i ;
    				if(logs) {
    					System.out.println("Jumped to position: "+ currentPosition);
    				}
    				break;
    			} 
    		}
    		if(logs) {
    			System.out.println("======================================================"); 
    		}
			if(currentPosition + jumpLength >= riverLength ) {
				if(logs) {
					System.out.println("Jumped to position: "+ riverLength);
					System.out.println("Reached Bank at "+ (t+1) + " seconds");
				}
				return t+1;
			}
			else if( t >= leaves.size() && previousPosition == currentPosition) {
				return -1;
			}
    	}
    	return -1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

//        int jumpLength = 1;
//
//        int riverLength = 5;
//
//        int leavesCount = 5;

//        List<Integer> leaves = IntStream.range(0, leavesCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine().replaceAll("\\s+$", "");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//            .map(String::trim)
//            .map(Integer::parseInt)
//            .collect(toList());
        
        int jumpLength = 1;

        int riverLength = 5;

        List<Integer> leaves;
        int result;
        leaves = Arrays.asList(new Integer[]{1,3,1,4,2,3,4});
        result = Result.jumpingFrog(jumpLength, riverLength, leaves);
        System.out.print("Input: ");
        leaves.forEach(x -> {System.out.print(x+" ");});
        System.out.println();
        System.out.println("Result: "+ result);
        System.out.println("======================================================"); 
        
        leaves = Arrays.asList(new Integer[]{1,2,3,4});
        result = Result.jumpingFrog(jumpLength, riverLength, leaves);
        System.out.print("Input: ");
        leaves.forEach(x -> {System.out.print(x+" ");});
        System.out.println();
        System.out.println("Result: "+ result);
        System.out.println("======================================================"); 

        leaves = Arrays.asList(new Integer[]{4,2,3,1});
        result = Result.jumpingFrog(jumpLength, riverLength, leaves);
        System.out.print("Input: ");
        leaves.forEach(x -> {System.out.print(x+" ");});
        System.out.println();
        System.out.println("Result: "+ result);
        System.out.println("======================================================"); 
        
        leaves = Arrays.asList(new Integer[]{4,1,2,3});
        result = Result.jumpingFrog(jumpLength, riverLength, leaves);
        System.out.print("Input: ");
        leaves.forEach(x -> {System.out.print(x+" ");});
        System.out.println();
        System.out.println("Result: "+ result);
        System.out.println("======================================================"); 
        
        leaves = Arrays.asList(new Integer[]{1,2,3,1,2,3,1,2,3,4});
        result = Result.jumpingFrog(jumpLength, riverLength, leaves);
        System.out.print("Input: ");
        leaves.forEach(x -> {System.out.print(x+" ");});
        System.out.println();
        System.out.println("Result: "+ result);
        System.out.println("======================================================");  
        

        leaves = Arrays.asList(new Integer[]{4,2,1,4,2,1,4,2,1});
        result = Result.jumpingFrog(jumpLength, riverLength, leaves);
        System.out.print("Input: ");
        leaves.forEach(x -> {System.out.print(x+" ");});
        System.out.println();
        System.out.println("Result: "+ result);
        System.out.println("======================================================");          
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
	
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

