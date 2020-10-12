package hackerrank.greedy.reverseshufflemerge;

import javax.xml.stream.events.Characters;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the reverseShuffleMerge function below.
    static String reverseShuffleMerge(String s) {
        String[] chars = s.split("");
        ArrayList<Character> uniqueChars = new ArrayList<>();
        ArrayList<ArrayList<Integer>> positions = new ArrayList<>();

        // create list in descending alpha order
        for(Integer i=0; i < chars.length; i++){

        }
        //match substring, else move last character by 1 space
        for(Integer j=0; j < uniqueChars.size(); j++){
            //if (s.charAt(j)==uniqueChars.keySet().)
        }
        return null;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = reverseShuffleMerge(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
