package Knapsack;

public class Item {

	int weight;
	int value;
	
	public Item(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public int getValue() {
		return this.value;
	}
}
