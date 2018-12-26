package rbctest.linkedListDuplicate;

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

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}



class Result {

    /*
     * Complete the 'distinct' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts INTEGER_SINGLY_LINKED_LIST head as parameter.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static SinglyLinkedListNode distinct(SinglyLinkedListNode head) {
    	Set<Integer> distinctData = new TreeSet<>();

    	SinglyLinkedListNode currentNode = head;
    	SinglyLinkedListNode previousNode = head;
    	distinctData.add(head.data);

    	while(currentNode.next !=null) {
    		currentNode = currentNode.next;
    		if(!distinctData.contains(currentNode.data)) {
    			previousNode = currentNode;
    			distinctData.add(currentNode.data);
    		}
    		else {
    			previousNode.next=currentNode.next;    			
    		}
    	}
		return head;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        SinglyLinkedList head = new SinglyLinkedList();

//        int headCount = Integer.parseInt(bufferedReader.readLine().trim());

        int [] list = {1,1,1,1,1,2,3,4,3,3,5,3,4,5,3,6,6,6,6,6,6};

        IntStream.range(0, list.length).forEach(i -> {
//            try {
                int headItem = list[i];

                head.insertNode(headItem);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
        });

        SinglyLinkedListNode result = Result.distinct(head.head);

        SinglyLinkedListPrintHelper.printList(result, "\n", bufferedWriter);
//        bufferedWriter.newLine();

//        bufferedReader.close();
        bufferedWriter.close();
    }
}