package dsa.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MergeSort {
    private class TestCase{
        int[] expectedArray;
        int[] actualArray;

        public TestCase(int[] expectedArray, int[] actualArray) {
            this.expectedArray = expectedArray;
            this.actualArray = actualArray;
        }
    }

    Map<String,TestCase> testCases = new HashMap<>();
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

    private void recursiveMergeSort(int[] integers) { // O(n log n)
        sort(integers,0,integers.length-1);
    }


    private void validateResultsForRecursiveAlgo(int[] expectedArray, int[] actualArray) {
        int [] recursiveInput = new int[actualArray.length];
        System.arraycopy(actualArray,0, recursiveInput,0, actualArray.length);
        recursiveMergeSort(recursiveInput);
        Assertions.assertArrayEquals(expectedArray, recursiveInput);
    }



    private void sort(int[] integers, int start, int end){ // Called O (log n) times
        // Only if the current sort 2 or more elements and
        if( start < end) {
            // Find midpoint
            int mid = (start + end)/2;
            // Sort left Half
            sort(integers,start,mid);
            // Sort right Half
            sort(integers,mid+1,end);
            // Merge both Halves
            merge(integers,start,mid,end); // Over sub sequent merges this evaluates to O(n) per level of division
            // As sort is called log(n) times. Overall complexity is O (n log n);
        }
    }

    private void merge(int[] integers, int start, int mid, int end) { // O(k) , k = slice of the array.

        int[] left = new int[mid-start+1];    // + 1 because mid element is part of left
        int[] right = new int[end-mid];

        // Copy elements to left half
        for (int i = 0; i < left.length; i++) { // O(n)
            left[i]=integers[start+i];
        }

        // Copy element to right half
        for (int i = 0; i < right.length; i++) { // O(n)
            right[i]=integers[mid+1+i]; // + 1 because mid element is part of left
        }

        int leftIdx = 0;
        int rightIdx = 0;
        int arrayIdx = start;

        // Copy elements to main array by using shortest first logic
        while (leftIdx < left.length && rightIdx < right.length){ // O(n)
            // shorter element of the currently pointed left or right array should be inserted first.
            if(left[leftIdx] < right[rightIdx]){
                integers[arrayIdx]=left[leftIdx];
                arrayIdx++;
                leftIdx++;
            }
            else {
                integers[arrayIdx]=right[rightIdx];
                arrayIdx++;
                rightIdx++;
            }
        }

        // If any of the array is not fully copied in to main array. There can be only one

        while (leftIdx < left.length){ // O(n)
            integers[arrayIdx]=left[leftIdx];
            arrayIdx++;
            leftIdx++;
        }
        while (rightIdx < right.length){ // O(n)
            integers[arrayIdx]=right[rightIdx];
            arrayIdx++;
            rightIdx++;
        }
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
        nonRecursiveMergeSort(nonRecursiveInput);
        Assertions.assertArrayEquals(expectedArray, nonRecursiveInput);
    }

    void nonRecursiveMergeSort(int [] array){
        // Start with array size of 1
        // Merge Sort array of size 1 to form array of size 2
        // Merge Sort array of size 2 to form array of size 4 and so on till index [n-1]
        int arrayLastIndex = array.length -1;
        // Loop should iterate in multiples of 2


        for (int currentSplitSize = 1; currentSplitSize <= arrayLastIndex; currentSplitSize *= 2) {
            // Run Time = 2 * 2 * .... x times till n is reached
            // 2 ^ x = n
            // = n. Hence, Overall complexity for loop is  O(n)

            for (int leftIndex = 0; leftIndex < arrayLastIndex; leftIndex += 2 * currentSplitSize) {
                System.out.print(array[leftIndex]+" ");
                // Run Time =  n / 2 + n / 4 + n/ 8 .... log (n) times due to outer loop.
                // Geometric progression sum => n / (1-1/2) times = 2n times
                // Hence, Overall complexity including outer loop is O(n)

                int midIndex = Math.min(leftIndex + currentSplitSize - 1,arrayLastIndex);
                int rightIndex = Math.min(leftIndex + 2 * currentSplitSize - 1, arrayLastIndex);

                // Run time =  1 * n + 2 * n/2 + 4 * n / 4 + .... log (n) times due to outer loop.
                // which comes to n + n + n ... log (n) times
                merge(array,leftIndex,midIndex,rightIndex);
                // Hence, Overall complexity including merge  loop is O(n log (n))
            }
            System.out.println();
        }
    }

}
