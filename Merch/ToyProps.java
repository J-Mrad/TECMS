package Merch;

import java.io.Serializable;
import java.util.ArrayList;

import Files.Merch_Save;
import Schedules.Movies;

public class ToyProps extends Toys implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7876816916812982004L;

	public static ArrayList<ToyProps> toyPropsList = new ArrayList<ToyProps>();

    private String Depicts; //eg is it a sword? A toy gun?
    private float weight;
    private boolean isSafeForChildren;
    private String heldBy;
    private boolean isACollectable;

    public ToyProps(String productName, String movie, float price, int quantity, boolean hasOffer, int ageGroup, String type, boolean framed, boolean hasAccessories, String depicts, float weight, boolean isSafeForChildren, String heldBy, boolean isACollectable) {
        super(productName, movie, price, quantity, hasOffer, ageGroup, type, framed, hasAccessories);
        Depicts = depicts;
        this.weight = weight;
        this.isSafeForChildren = isSafeForChildren;
        this.heldBy = heldBy;
        this.isACollectable = isACollectable;

        toyPropsList.add(this);
    }

    public String getDepicts() {
        return Depicts;
    }

    public void setDepicts(String depicts) {
        Depicts = depicts;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isSafeForChildren() {
        return isSafeForChildren;
    }

    public void setSafeForChildren(boolean safeForChildren) {
        isSafeForChildren = safeForChildren;
    }

    public String getHeldBy() {
        return heldBy;
    }

    public void setHeldBy(String heldBy) {
        this.heldBy = heldBy;
    }

    public boolean isACollectable() {
        return isACollectable;
    }

    public void setACollectable(boolean ACollectable) {
        isACollectable = ACollectable;
    }

    public static ArrayList<ToyProps> getToyPropsList() {
        return toyPropsList;
    }

    public void OfferCalculator(int percentageOff) {
        ArrayList<ToyProps> discountedList = toyPropsList;

        for ( ToyProps i : discountedList )
        {
            i.setPrice(getPrice() * (percentageOff/100));
        }
    }


    public ArrayList<ToyProps> ToyPropsRelatedToMovie(Movies movie)
    {
        ArrayList<ToyProps> targetList = new ArrayList<ToyProps>();

        for ( ToyProps merch : toyPropsList )
        {
            if(merch.getMovie().equals(movie))
            {
                targetList.add(merch);
            }
        }

        return targetList;
    }

    public ArrayList<ToyProps> FilterPrice(float lowerPrice, float upperPrice)
    {
        ArrayList<ToyProps> filteredList = new ArrayList<ToyProps>();

        for ( ToyProps merch : toyPropsList )
        {
            if(merch.getPrice() >= lowerPrice && merch.getPrice() <= upperPrice)
            {
                filteredList.add(merch);
            }
        }

        return filteredList;
    }

    public ArrayList<ToyProps> FilterPriceAndMovie(Movies movie, float lowerPrice, float upperPrice)
    {
        ArrayList<ToyProps> resultList = new ArrayList<ToyProps>();
        ArrayList<ToyProps> movieFilteredList = this.ToyPropsRelatedToMovie(movie);

        for ( ToyProps merch : movieFilteredList )
        {
            if(merch.getPrice() >= lowerPrice && merch.getPrice() <= upperPrice)
            {
                resultList.add(merch);
            }
        }

        return resultList;
    }

    public ToyProps FindToyPropByID(int ID)
    {
        for ( ToyProps merch : toyPropsList )
            if ( merch.getProductID() == ID )
                return merch;

        return null;
    }

    public boolean BuyMerch(ToyProps merch, CustomerShoppingCart cart)
    {
        if ( merch.getQuantity() <= 0 )
            return false;

        if ( cart.AddItem(merch) )
        {
            merch.setQuantity(getQuantity()-1);
			Merch_Save.SaveList();
            return true;
        }
        else
            return false;
    }

    public ArrayList<Toys> SuggestToyPropsByAge(int age)
    {
        ArrayList<Toys> suggestedList = new ArrayList<Toys>();

        for ( Toys toy : toyPropsList )
            if ( age <= toy.getAgeGroup() + 3 && age >= toy.getAgeGroup() - 3 )
                suggestedList.add(toy);

        return suggestedList;
    }
}
