package hackerrank.greedy.greedyflorist;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        IntStream costStream = IntStream.of(c);
        if (k >= c.length) {
            return costStream.sum();
        }
        int flowersBought = 0;
        int multiplier= 1;
        Integer totalCost = 0;
        Iterator<Integer> costIterator = costStream.boxed().sorted(Comparator.reverseOrder()).iterator();

        while(costIterator.hasNext()){
            Integer cost = costIterator.next();
            totalCost+= (cost * multiplier);
            flowersBought++;
            if(flowersBought%k==0){
                multiplier++;
            }
        }
        return totalCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

