package Food;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;

public class FoodSavingLoading {

	public static void Save() {
		try {

			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("./src/Food/Food.txt")));

			bufferedWriter.write(Food.inCome + "");
			bufferedWriter.newLine();

			Iterator<Food> iterator = Food.FoodList.listIterator();
			while (iterator.hasNext()) {
				Food food = iterator.next();

				bufferedWriter.write(food.foodName);
				bufferedWriter.newLine();
				bufferedWriter.write(food.cost + "");
				bufferedWriter.newLine();
				bufferedWriter.write(food.quantity + "");
				bufferedWriter.newLine();
				bufferedWriter.write(food.sizes[0] + " " + food.sizes[1] + " " + food.sizes[2]);
				bufferedWriter.newLine();

			}

			bufferedWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Load() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("./src/Food/Food.txt")));

			Food.inCome = Double.parseDouble(bufferedReader.readLine());
			String FoodName;
			while ((FoodName = bufferedReader.readLine()) != null) {
				double cost = Double.parseDouble(bufferedReader.readLine());
				int quantity = Integer.parseInt(bufferedReader.readLine());
				boolean size[] = new boolean[3];
				String sizes[] = bufferedReader.readLine().split(" ");
				size[0] = Boolean.parseBoolean(sizes[0]);
				size[1] = Boolean.parseBoolean(sizes[1]);
				size[2] = Boolean.parseBoolean(sizes[2]);
				FoodOperations.addFood(FoodName, cost, quantity, size);
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
