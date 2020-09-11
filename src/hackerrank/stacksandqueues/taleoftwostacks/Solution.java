package hackerrank.stacksandqueues.taleoftwostacks;

import java.util.Optional;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.Supplier;

public class Solution {
    static class  MyQueue<T>{
        Stack<T> popStack = new Stack();
        Stack<T> pushStack = new Stack();

        public void enqueue(T element){
            pushStack.push(element);
        }
        public T dequeue(){
            return performOperationOnHead(()->popStack.pop()).orElse(null);
        }
        T peek(){
            return performOperationOnHead(()->popStack.peek()).orElse(null);
        }
        Optional<T> performOperationOnHead(Supplier<T> operation){
            if(pushStack.isEmpty() && popStack.isEmpty()){
                return Optional.empty();
            }
            if(!popStack.isEmpty()){
                return Optional.of(operation.get());
            }
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
            return popStack.isEmpty() ? Optional.empty(): Optional.of(operation.get());
         }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}