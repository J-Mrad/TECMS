package Food;

import java.util.LinkedList;

public class FoodOperations {
	public static Food addFood(String foodName, double cost, int quantity, boolean[] sizes) {
		return new Food(foodName, cost, quantity, sizes);
	}

	public static LinkedList<Food> listFood() {
		LinkedList<Food> foods = new LinkedList<Food>();
		for (Food food : Food.FoodList) {
			foods.add(food);
		}
		return foods;
	}

	private static Food getFood(String Name) {
		for (Food food : Food.FoodList)
			if (food.foodName.equalsIgnoreCase(Name))
				return food;
		return null;
	}

	public static class CheckOut {
		public String Name;
		public String size;
		public double cost;

		public CheckOut(String Name, String size, double cost) {
			this.Name = Name;
			this.size = size;
			this.cost = cost;
		}
	}

	public static CheckOut BuyFood(Food food, String size) {

		switch (size) {
		case Utils.SIZE_SMALL:

			if (food.quantity > 1) {
				food.quantity -= 1;
				Food.inCome += food.cost;
				return new CheckOut(food.foodName,Utils.SIZE_SMALL,food.cost);
			}
			else return null;
			
		case Utils.SIZE_MEDIUM:

			if (food.quantity > 2) {
				food.quantity -= 2;
				Food.inCome += food.cost;
				return new CheckOut(food.foodName,Utils.SIZE_MEDIUM,food.cost);
			}

			else return null;
			
		case Utils.SIZE_LARGE:

			if (food.quantity > 3) {
				food.quantity -= 3;
				Food.inCome += food.cost;
				return new CheckOut(food.foodName,Utils.SIZE_LARGE,food.cost);
			}

			else return null;

		}
		
		return null;
		
	}
	
	public static boolean addQuantity(String Name,int Quantity) {
		Food food;
		if((food = getFood(Name))==null) {
			return false;
		}
		food.quantity+=Quantity;
		return true;
	}
	
	public static boolean ChangePrices(String Name,double Cost) {
		Food food;
		if((food = getFood(Name))==null) {
			return false;
		}
		food.cost=Cost;
		return true;
	}
	
	public static String getName(Food f) {
		return f.foodName;
	}
	
	public static boolean[] getSizes( Food f) {
		
		return f.sizes;
		
	}
	
}
