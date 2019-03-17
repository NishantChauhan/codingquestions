package test;

import java.util.ArrayList;
import java.util.Collections;

class List {
	static int count;
	public int value;
	public List rest;
	List(int value, List rest){
		this.value = value;
		this.rest=rest;
		count++;
//		System.out.println(count);
	}
	
	@Override
	public String toString() {
		StringBuilder addressString = new StringBuilder();
//		addressString.append("Instance Count [").append(count).append("] ->  { Value: ").append(this.value).append(", Rest: ").append(this.rest).append(" }");
		addressString.append("{ Value: ").append(this.value).append(", Rest: ").append(this.rest).append(" }");
		return addressString.toString();
	}
	
	static List arrayToList(int [] array) {
		List list = null;
		for(int i=array.length -1 ; i >=0 ; i-- ) {
			list = new List(array[i],list);
		}
		return list;
	}
}

public class Test {
	public static void main(String[] args) {
		java.util.List <Integer> impContestLuckBalanceList = new ArrayList<>();
		impContestLuckBalanceList.add(1);
		impContestLuckBalanceList.add(2);
		impContestLuckBalanceList.add(3);
		Collections.sort(impContestLuckBalanceList,(x, y)-> x > y ? -1 : (x < y ? 1 : 0 ));
		System.out.println(impContestLuckBalanceList);
		//printList("List", List.arrayToList(new int[] {1,2,3,4,5}));
	}

	private static void printList(String name, List value) {
		System.out.println(name +": " + value);
	}
}



//		address = new Address(4,new Address( 3,new Address( 3,new Address( 1,null))));
//		System.out.println(address);
