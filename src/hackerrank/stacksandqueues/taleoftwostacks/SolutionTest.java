package hackerrank.stacksandqueues.taleoftwostacks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolutionTest {

    @Test
    void base(){
        String input=  "3\n" +
                "1 1\n" +
                "3\n" +
                "2\n" +
                "3\n";
        List<String> output = getOutput(input);
        String expectedOutput= "1\n"+"";
        String actualOutput = output.stream().reduce("",(acc,val)->acc+val+"\n");
        Assertions.assertEquals(expectedOutput,actualOutput);

    }

    @Test
    void intermediate(){
        String input= "10\n" +
                "1 42\n" +
                "2\n" +
                "1 14\n" +
                "3\n" +
                "1 28\n" +
                "3\n" +
                "1 60\n" +
                "1 78\n" +
                "2\n" +
                "2";
        List<String> output = getOutput(input);

        String expectedOutput= "14\n" +
                "14\n";
        String actualOutput = output.stream().reduce("",(acc,val)->acc+""+val+"\n");
        Assertions.assertEquals(expectedOutput,actualOutput);



    }

    @Test
    void interimTest2(){
        String input ="8\n" +
                "1 15\n" +
                "1 17\n" +
                "3\n" +
                "1 25\n" +
                "2\n" +
                "3\n" +
                "2\n" +
                "3";

        List<String> output = getOutput(input);

        String expectedOutput= "15\n" +
                "17\n"+
                "25\n";
        String actualOutput = output.stream().reduce("",(acc,val)->acc+""+val+"\n");
        Assertions.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void complex(){

    }

    private List<String> getOutput(String input) {
        String[] inputs = input.split("\n");
        Solution.MyQueue<Integer> queue = new Solution.MyQueue<Integer>();
        List<String> output = new ArrayList<>();

        int c=0;
        int n = Integer.valueOf(inputs[c++]);

        for (int i = 0; i < n; i++) {
            String[] operationLine = inputs[c++].split(" ");
            int operation = Integer.valueOf(operationLine[0]);
            if (operation == 1) { // enqueue
                queue.enqueue(Integer.valueOf(operationLine[1]));
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                Integer peeked = queue.peek();
                System.out.println(peeked);
                output.add(String.valueOf(peeked));
            }
        }
        return output;
    }

}
