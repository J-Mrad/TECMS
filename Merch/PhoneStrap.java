package Merch;

import java.util.ArrayList;

import Schedules.Movies;

@SuppressWarnings("serial")
public class PhoneStrap extends PhoneAccessories
{
    private static ArrayList<PhoneStrap> phoneStrapList = new ArrayList<PhoneStrap>();

    private float length;
    private String fabricType;
    private boolean holdsSymbol;

    public PhoneStrap(String productName, String movie, float price, int quantity, boolean hasOffer, String sourceFactory, boolean usesElectricity, boolean containsCharacter, boolean containsLogo, String phoneModel, int weight, boolean detachable, int length, String fabricType, boolean holdsSymbol) {
        super(productName, movie, price, quantity, hasOffer, sourceFactory, usesElectricity, containsCharacter, containsLogo, phoneModel, weight, detachable);
        this.length = length;
        this.fabricType = fabricType;
        this.holdsSymbol = holdsSymbol;

        phoneStrapList.add(this);
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public String getFabricType() {
        return fabricType;
    }

    public void setFabricType(String fabricType) {
        this.fabricType = fabricType;
    }

    public boolean isHoldsSymbol() {
        return holdsSymbol;
    }

    public void setHoldsSymbol(boolean holdsSymbol) {
        this.holdsSymbol = holdsSymbol;
    }

    public void OfferCalculator(int percentageOff) {
        ArrayList<PhoneStrap> discountedList = phoneStrapList;

        for ( PhoneStrap i : discountedList )
        {
            i.setPrice(getPrice() * (percentageOff/100));
        }
    }

    @Override
    public String toString() {
        return "PhoneStrap{" +
                "length=" + length +
                ", fabricType='" + fabricType + '\'' +
                ", holdsSymbol=" + holdsSymbol +
                '}';
    }

    public float SuggestPrice()
    {
        float suggestedPrice;

        float lengthValue = length / 5;

        float symbolValue;
        if ( holdsSymbol == true )
            symbolValue = lengthValue * 2;
        else
            symbolValue = lengthValue;

        switch(fabricType)
        {
            case "plastic":
                suggestedPrice = (float)(symbolValue * 0.5);
                break;
            case "nylon":
                suggestedPrice = (float)(symbolValue * 0.7);
                break;
            case "aluminum":
                suggestedPrice = symbolValue;
                break;
            default:
                suggestedPrice = (float)(symbolValue * 0.6);
                break;
        }

        return suggestedPrice;
    }

    public ArrayList<PhoneStrap> MerchRelatedToMovie(Movies movie)
    {
        ArrayList<PhoneStrap> targetList = new ArrayList<PhoneStrap>();

        for ( PhoneStrap merch : phoneStrapList )
        {
            if(merch.getMovie().equals(movie))
            {
                targetList.add(merch);
            }
        }

        return targetList;
    }

    public ArrayList<PhoneStrap> FilterPrice(float lowerPrice, float upperPrice)
    {
        ArrayList<PhoneStrap> filteredList = new ArrayList<PhoneStrap>();

        for ( PhoneStrap merch : phoneStrapList )
        {
            if(merch.getPrice() >= lowerPrice && merch.getPrice() <= upperPrice)
            {
                filteredList.add(merch);
            }
        }

        return filteredList;
    }

    public ArrayList<PhoneStrap> FilterPriceAndMovie(Movies movie, float lowerPrice, float upperPrice)
    {
        ArrayList<PhoneStrap> resultList = new ArrayList<PhoneStrap>();
        ArrayList<PhoneStrap> movieFilteredList = this.MerchRelatedToMovie(movie);

        for ( PhoneStrap merch : movieFilteredList )
        {
            if(merch.getPrice() >= lowerPrice && merch.getPrice() <= upperPrice)
            {
                resultList.add(merch);
            }
        }

        return resultList;
    }

    public PhoneStrap FindPhoneStrapByID(int ID)
    {
        for ( PhoneStrap merch : phoneStrapList )
            if ( merch.getProductID() == ID )
                return merch;

        return null;
    }

    public boolean BuyPhoneStrap(PhoneStrap merch, CustomerShoppingCart cart)
    {
        if ( merch.getQuantity() <= 0 )
            return false;

        if ( cart.AddItem(merch) )
        {
            merch.setQuantity(merch.getQuantity()-1);
            return true;
        }
        else
            return false;
    }

    public boolean PhoneCompatibility(String model)
    {
        if ( this.getPhoneModel().equals(model))
            return true;
        else
            return false;
    }
}
