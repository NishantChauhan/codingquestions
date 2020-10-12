package hackerrank.search.gridlandmetro;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gridlandMetro function below.
    static int gridlandMetro(int n, int m, int k, int[][] track) {
        // iterate over the track and mark rail occupied boxes in the map
        // O (k*m)
        int emptyCells = 0;
        for(int i=0; i< k ;i ++){
            for(int j=i+1; j<k ;j++){
                if(track[i][0]>track[j][0]){
                    int [] temp = track[j];
                    track[j]=track[i];
                    track[i]=temp;
                }
            }
        }
        int trackNo=0;
        int rowId = 1;
        while (rowId <=m){
            int trackRow= track[trackNo][0];
            while(rowId!=trackRow){
               emptyCells+=m;
               rowId++;
            }
            int row[]= new int[m+1];
            while(trackRow==rowId){
                int trackStart = track[trackNo][1];
                int trackEnd = track[trackNo][2];
                for(int i=trackStart;i<=trackEnd;i++){
                    row[i]=1;
                }
                trackNo++;
            }
            for(int i=1;i<=m;i++){
                if(row[i]!=1){
                    emptyCells++;
                }
            }
            rowId++;
        }
        return emptyCells;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nmk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nmk[0]);

        int m = Integer.parseInt(nmk[1]);

        int k = Integer.parseInt(nmk[2]);

        int[][] track = new int[k][3];

        for (int i = 0; i < k; i++) {
            String[] trackRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int trackItem = Integer.parseInt(trackRowItems[j]);
                track[i][j] = trackItem;
            }
        }

        int result = gridlandMetro(n, m, k, track);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
