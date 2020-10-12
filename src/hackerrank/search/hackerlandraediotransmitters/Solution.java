package hackerrank.search.hackerlandraediotransmitters;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hackerlandRadioTransmitters function below.
    static int hackerlandRadioTransmitters(int[] x, int k) {
        int n=x.length;
        Arrays.sort(x);
        int numOfTransmitters = 0;
        int i = 0;
        while (i < n) {
            numOfTransmitters++;
            int loc = x[i] + k;
            while (i < n && x[i] <= loc) i++;
            loc = x[--i] + k;
            while (i < n && x[i] <= loc) i++;
        }
        System.out.println(numOfTransmitters);
        return numOfTransmitters;

    }
    static int hackerlandRadioTransmitters1(int[] x, int k) {
        class Transmitter {
            public int location;
            public boolean hopped;

            public int getLocation() {
                return location;
            }

            public void setLocation(int location) {
                this.location = location;
            }

            public boolean isHopped() {
                return hopped;
            }

            public void setHopped(boolean hopped) {
                this.hopped = hopped;
            }

            Transmitter(int location, boolean hopped){
                this.location=location;
                this.hopped=hopped;
            }
        }
        List <Transmitter> transmitters = new ArrayList();
        int range = k;

        // 1. Sort the houses
        for (int i=0; i< x.length; i ++){
            for (int j=i+1; j< x.length;j++){
                if(x[i]>x[j]){
                    int temp = x[j];
                    x[j]=x[i];
                    x[i]=temp;
                }
            }
        }

        int i=0;
        transmitters.add(new Transmitter(x[0],false));
        // 2. Keep transmitter at first house
        for (int houseNo=0; houseNo < x.length; houseNo++ ){
            Transmitter lastTransmitterHouse = transmitters.get(i);
            if(lastTransmitterHouse.getLocation() + range < x[houseNo]){
                if (!lastTransmitterHouse.isHopped()) { // if not hopped then move
                    lastTransmitterHouse.setLocation(x[houseNo-1]);
                    lastTransmitterHouse.setHopped(true);
                    transmitters.set(i,lastTransmitterHouse);
                }
                else{
                    lastTransmitterHouse.setLocation(x[houseNo]);
                    lastTransmitterHouse.setHopped(false);
                    transmitters.add(lastTransmitterHouse);
                    i++;
                }
            }
        }
        // 3. Then move it to house + range say t1

        // 4. Check the nearest house out of t1 range place t2.

        // 5. Repeat  3 and 4 till last house is in range.


        return transmitters.size();

    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] x = new int[n];

        String[] xItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int xItem = Integer.parseInt(xItems[i]);
            x[i] = xItem;
        }

        int result = hackerlandRadioTransmitters(x, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
