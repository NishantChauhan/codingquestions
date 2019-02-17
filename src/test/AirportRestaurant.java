package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class User{
	boolean citizen;
	List<Product> order = new ArrayList<>();
	double totalBill;
	public User(String nationality){
		this.citizen= nationality.equals("CANADIAN");
	}
	void addToOrder(Product product, int quantity) {
		product.setQuantity(quantity);
		product.setCitizen(citizen);
		product.askTotalPrice();
		order.add(product);
	}
	
	void printOrder() {
		for(Product item: order) {
			System.out.println(item.getItemString());
		}
	}
	
	public double getTotalBill(){
		double totalBill = 0;
		for(Product item: order) {
			totalBill+=item.askTotalPrice();
		}
		return totalBill;
	}
}
class Menu{
	Map<Integer,Product> items = new HashMap<>();
	
	public void addProduct(Product product){
		items.put(product.getProductId(), product);
	}
	public Product getItem(Integer productId) {
		return items.get(productId);
	}
	void printMenu(){
		System.out.println("======================= Sneha Halwai Menu ===========================");
		for(Entry<Integer,Product> item: items.entrySet()) {
			System.out.println(item.getValue());
		}
		System.out.println("======================= Sneha Halwai Menu ===========================");

	}
}
class Product{
	double TAX_RATE = 0.13;
	private int productId;
	private String name;
	private double price;
	private int quantity;
	private boolean citizen;
	private double totalPrice;	
	
	public Product(int productId, String name, double price){
		this.productId=productId;
		this.name=name;
		this.price=price;
	}

	public double askTotalPrice(){
		totalPrice = this.quantity * this.price;
		totalPrice = totalPrice + ( this.citizen ? totalPrice * TAX_RATE :  0);
		return totalPrice;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		return 
				string
				.append("Product Id: ").append(productId)
				.append("\tProduct Name: ").append(name)
				.append("\tPrice : $").append(price)
//				.append(" Citizen: ").append(citizen?"Citizen":"Foreigner")
//				.append(" Quantity: ").append(quantity)
//				.append(" Total Price: $").append(totalPrice)
				.toString();
	}

	public String getItemString() {
		StringBuilder string = new StringBuilder();
		return 
				string
				.append("Product Id: ").append(productId)
				.append("\tProduct Name: ").append(name)
				.append("\tPrice : $").append(price)
				.append(" Citizen: ").append(citizen?"Citizen":"Foreigner")
				.append(" Quantity: ").append(quantity)
				.append(" Total Price: $").append(totalPrice)
				.toString();
	}



	public int getProductId() {
		return productId;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public void setCitizen(boolean citizen) {
		this.citizen = citizen;
	}
	
}

public class AirportRestaurant {
	public static void main(String[] args) {
		
		// Build Menu
		Menu menu = new Menu();
		menu.addProduct(new Product(1,"Jalebi",5));
		menu.addProduct(new Product(2,"Samosa",3));
		menu.addProduct(new Product(3,"Dosa",6));
		menu.addProduct(new Product(4,"Wada",2));
		menu.addProduct(new Product(5,"Pasta",2));

		menu.printMenu();
		
		System.out.println("===========================Toronto Pearson===========================");

		System.out.println("=========================== Justin Order ===========================");
		User justin = new User("CANADIAN");
		justin.addToOrder(menu.getItem(5),1);
		justin.printOrder();
		System.out.println("=========================== Justin Order ===========================");
		System.out.println("=========================== Narendra Order ===========================");
		User narendra = new User("INDIAN");
		narendra.addToOrder(menu.getItem(3),1);
		narendra.addToOrder(menu.getItem(4),2);
		narendra.printOrder();
		System.out.println("=========================== Narendra Order ===========================");
		System.out.println("===========================Toronto Pearson===========================");

	}
}
