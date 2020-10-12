package dsa.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PivotSort {
    private class TestCase{
        int[] expectedArray;
        int[] actualArray;

        public TestCase(int[] expectedArray, int[] actualArray) {
            this.expectedArray = expectedArray;
            this.actualArray = actualArray;
        }
    }

    Map<String, TestCase> testCases = new HashMap<>();
    {
        testCases.put("baseSortedCase", new TestCase(new int[] {1,2,3},new int[] {1,2,3}));
        testCases.put("baseReverseSortedCase", new TestCase(new int[] {1,2,3},new int[] {3,2,1}));
        testCases.put("baseMediumCase", new TestCase(new int[] {1,2,3,4,5,6,7,8},new int[] {4,5,3,8,7,1,2,6}));
        testCases.put("baseLargeCase", new TestCase(
                new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15},
                new int[] {15,13,2,1,5,6,7,9,8,10,12,11,4,3,14}
        ));
        testCases.put("veryLargeCase", new TestCase(
                new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32},
                new int[] {16,19,15,13,20,2,23,1,5,27,6,7,32,31,9,8,26,10,12,11,28,4,3,14,17,18,21,22,24,25,29,30}
        ));

    }


    // Recursive
    @Test
    void baseSortedCaseRecursive(){
        validateResultsForRecursiveAlgo(testCases.get("baseSortedCase").expectedArray, testCases.get("baseSortedCase").actualArray);
    }

    @Test
    void baseReverseSortedCaseRecursive(){
        validateResultsForRecursiveAlgo(testCases.get("baseReverseSortedCase").expectedArray, testCases.get("baseReverseSortedCase").actualArray);
    }

    @Test
    void baseMediumCaseRecursive(){
        validateResultsForRecursiveAlgo(testCases.get("baseMediumCase").expectedArray, testCases.get("baseMediumCase").actualArray);
    }

    @Test
    void baseLargeCaseRecursive(){
        validateResultsForRecursiveAlgo(testCases.get("baseLargeCase").expectedArray, testCases.get("baseLargeCase").actualArray);
    }



    private void validateResultsForRecursiveAlgo(int[] expectedArray, int[] actualArray) {
        int [] recursiveInput = new int[actualArray.length];
        System.arraycopy(actualArray,0, recursiveInput,0, actualArray.length);
        recursivePivotSort(recursiveInput);
        Assertions.assertArrayEquals(expectedArray, recursiveInput);
    }


    void recursivePivotSort(int[] array){
        sort(array,0,array.length-1);
    }
    void sort(int[] array, int start, int end){ 
        // Called approximately 
        // log n times in best case 
        // n times in worst case

        // no sorting needed if start >= end
        if(start < end){
            // partition the array
            int partitionIdx = partition(array,start,end); // Over the period called n time per division

            // sort element smaller than partition
            sort(array,start,partitionIdx-1);

            // sort element larger than partition
            sort(array,partitionIdx+1,end);

        }
    }
    int partition(int[] array, int start, int end){
        int pivot=array[end]; // arbitrary pivot, I took last element

        int sortIdx=start; // Start with first element

        for (int i = start; i < end; i++) {
            if(array[i] < pivot){
                swap(array,sortIdx++,i);
            }
        }
        int partitionIndex=sortIdx; // element after the sort index is the partition
        swap(array,partitionIndex,end); // Swap so that pivot is in between the partitions.
        return partitionIndex;
    }

    private void swap(int[] array, int e1, int e2) {
        int temp = array[e2];
        array[e2] = array[e1];
        array[e1] = temp;
    }
    // Non Recursive Algo

    @Test
    void baseSortedCaseNonRecursive(){
        validateResultsForNonRecursiveAlgo(testCases.get("baseSortedCase").expectedArray, testCases.get("baseSortedCase").actualArray);
    }

    @Test
    void baseReverseSortedCaseNonRecursive(){
        validateResultsForNonRecursiveAlgo(testCases.get("baseReverseSortedCase").expectedArray, testCases.get("baseReverseSortedCase").actualArray);
    }

    @Test
    void baseMediumCaseNonRecursive(){
        validateResultsForNonRecursiveAlgo(testCases.get("baseMediumCase").expectedArray, testCases.get("baseMediumCase").actualArray);
    }
    @Test
    void baseLargeCaseNonRecursive(){
        validateResultsForNonRecursiveAlgo(testCases.get("baseLargeCase").expectedArray, testCases.get("baseLargeCase").actualArray);
    }
    @Test
    void veryLargeCaseNonRecursive(){
        validateResultsForNonRecursiveAlgo(testCases.get("veryLargeCase").expectedArray, testCases.get("veryLargeCase").actualArray);
    }


    private void validateResultsForNonRecursiveAlgo(int[] expectedArray, int[] actualArray) {
        int [] nonRecursiveInput = new int[actualArray.length];
        System.arraycopy(actualArray,0, nonRecursiveInput,0, actualArray.length);
        iterativePivotSort(nonRecursiveInput);
        Assertions.assertArrayEquals(expectedArray, nonRecursiveInput);
    }
    class Node {
        int leftIndex;
        int rightIndex;

        public Node(int leftIndex, int rightIndex) {
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }
    }

    private void iterativePivotSort (int [] array){
        int lastIndex = array.length -1;
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(new Node(0,lastIndex));
        while (!nodeStack.isEmpty()){
            Node node = nodeStack.pop();
            // Assume best case/ average case
            // n +  2 * n / 2 + 4 * n /4 + .... log (n) times = n log (n)
            // Reason: we assumed that array is always partitioned into half in each iteration.
            // Worst Case
            // n + n -1 + n -2 + ..... n times = O (n^2)
            // Reason : we assume that partition only moves 1 left in each iteration. Happens when array is sorted.
            int partitionIndex = partition(array,node.leftIndex,node.rightIndex);
            checkAndPushToStackIfValid((Stack<Node>) nodeStack, node.leftIndex, partitionIndex-1);
            checkAndPushToStackIfValid(nodeStack, partitionIndex + 1, node.rightIndex);
        }
    }

    private void checkAndPushToStackIfValid(Stack<Node> nodeStack, int left, int right) {
        if (left < right) {
            nodeStack.push(new Node(left, right));
        }
    }

}
