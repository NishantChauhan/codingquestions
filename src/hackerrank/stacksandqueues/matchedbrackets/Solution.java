package hackerrank.stacksandqueues.matchedbrackets;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        HashMap<Character,Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(']','[');
        matchingBrackets.put(')','(');
        matchingBrackets.put('}','{');

        Stack<Character> bracketStack = new Stack<>();

        for(int i=0;i<s.length();i++){
            Character currentChar = s.charAt(i);
            // Left Bracket
            if(matchingBrackets.values().contains(currentChar)){
                bracketStack.push(currentChar);
            }

            //Right Bracket
            if(matchingBrackets.containsKey(currentChar)){
                if(bracketStack.isEmpty()){
                    return "NO";
                }
                Character topOfStack = bracketStack.pop();
                // If top of stack is a matchingBracket
                if(!topOfStack.equals(matchingBrackets.get(currentChar))){
                    return "NO";
                }
            }
        }

        if(!bracketStack.isEmpty()){
            return "NO";
        }

        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

//      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
