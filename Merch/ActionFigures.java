package Merch;

import java.io.Serializable;
import java.util.ArrayList;

import Files.Merch_Save;
import Schedules.Movies;

public class ActionFigures extends Toys implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8898233596804424461L;

	public static ArrayList<ActionFigures> actionFiguresList = new ArrayList<ActionFigures>();

    private int height;
    private int grade; //1, 2, or 3. The higher the better
    private String material;
    private String character;
    private boolean isReformable;

    public ActionFigures(String productName, String movie, float price, int quantity, boolean hasOffer,
                         int ageGroup, String type, boolean framed, boolean hasAccessories,
                         int height, int grade, String material, String character, boolean isReformable)  throws GradeException
    {
        super(productName, movie, price, quantity, hasOffer, ageGroup, type, framed, hasAccessories);

        if(grade != 1 && grade != 2 && grade != 3)
        {
            throw new GradeException("Grade must be either 1, 2, or 3");
        }
        else
        {
            this.height = height;
            this.grade = grade;
            this.material = material;
            this.character = character;
            this.isReformable = isReformable;

            actionFiguresList.add(this);
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public boolean isReformable() {
        return isReformable;
    }

    public void setReformable(boolean reformable) {
        isReformable = reformable;
    }

    public static ArrayList<ActionFigures> getActionFiguresList() {
        return actionFiguresList;
    }

    public void OfferCalculator(int percentageOff) {
        ArrayList<ActionFigures> discountedList = actionFiguresList;

        for ( ActionFigures i : discountedList )
        {
            i.setPrice(getPrice() * (percentageOff/100));
        }
    }

    @Override
    public String toString() {
        return "ActionFigures{" +
                "height=" + height +
                ", grade=" + grade +
                ", material='" + material + '\'' +
                ", character='" + character + '\'' +
                ", isReformable=" + isReformable +
                '}';
    }

    public float SuggestPrice()
    {
        float suggestedPrice;

        float heightValue = height / 10;
        float sizeAndGradeValue = heightValue * grade;

        float intermediateValue;
        if(this.isReformable == true)
            intermediateValue = (float)(sizeAndGradeValue * 1.5);
        else
            intermediateValue = sizeAndGradeValue;

        switch(this.material)
        {
            case "plastic":
                suggestedPrice = (float)(intermediateValue * 1.2);
                break;
            case "carbon fiber":
                suggestedPrice = (float)(intermediateValue * 1.7);
                break;
            case "glass":
                suggestedPrice = (float)(intermediateValue * 2);
                break;
            default:
                suggestedPrice = intermediateValue;
                break;
        }

        return suggestedPrice;
    }

    public ArrayList<ActionFigures> ActionFiguresRelatedToMovie(Movies movie)
    {
        ArrayList<ActionFigures> targetList = new ArrayList<ActionFigures>();

        for ( ActionFigures merch : actionFiguresList )
        {
            if(merch.getMovie().equals(movie))
            {
                targetList.add(merch);
            }
        }

        return targetList;
    }

    public ArrayList<ActionFigures> FilterPrice(float lowerPrice, float upperPrice)
    {
        ArrayList<ActionFigures> filteredList = new ArrayList<ActionFigures>();

        for ( ActionFigures merch : actionFiguresList )
        {
            if(merch.getPrice() >= lowerPrice && merch.getPrice() <= upperPrice)
            {
                filteredList.add(merch);
            }
        }

        return filteredList;
    }

    public ArrayList<ActionFigures> FilterPriceAndMovie(Movies movie, float lowerPrice, float upperPrice)
    {
        ArrayList<ActionFigures> resultList = new ArrayList<ActionFigures>();
        ArrayList<ActionFigures> movieFilteredList = this.ActionFiguresRelatedToMovie(movie);

        for ( ActionFigures merch : movieFilteredList )
        {
            if(merch.getPrice() >= lowerPrice && merch.getPrice() <= upperPrice)
            {
                resultList.add(merch);
            }
        }

        return resultList;
    }

    public ActionFigures FindActionFigureByID(int ID)
    {
        for ( ActionFigures merch : actionFiguresList )
            if ( merch.getProductID() == ID )
                return merch;

        return null;
    }

    public boolean BuyActionFigure(ActionFigures merch, CustomerShoppingCart cart)
    {
        if ( merch.getQuantity() <= 0 )
            return false;

        if ( cart.AddItem(merch) )
        {
            merch.setQuantity(merch.getQuantity()-1);
			Merch_Save.SaveList();

            return true;
        }
        else
            return false;
    }

    public ArrayList<Toys> SuggestActionFigureByAge(int age)
    {
        ArrayList<Toys> suggestedList = new ArrayList<Toys>();

        for ( Toys toy : actionFiguresList )
            if ( age <= toy.getAgeGroup() + 3 && age >= toy.getAgeGroup() - 3 )
                suggestedList.add(toy);

        return suggestedList;
    }
}
