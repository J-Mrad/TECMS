package Food;

import java.util.ArrayList;

public class Food {
	
	public static double inCome;
	
	protected String foodName;
	public double cost;
	public int quantity;
	protected boolean sizes[] = new boolean[3];
	
	protected static ArrayList<Food> FoodList;
	
	protected Food(String foodName,double cost,int quantity,boolean[] sizes) {
		if(FoodList==null)
			FoodList = new ArrayList<Food>();
		
		this.foodName = foodName;
		this.cost = cost;
		this.quantity = quantity;
		this.sizes = sizes;
		if(!FoodList.contains(this) && ContainsName()) 
			FoodList.add(this);
	}

	private boolean ContainsName() {
		for(Food food : FoodList) {
			if(food.foodName.equalsIgnoreCase(this.foodName))
				return false;			
		}
		return true;
	}
}
