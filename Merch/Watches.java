package Merch;

import java.util.ArrayList;

import Schedules.Movies;

@SuppressWarnings("serial")
public class Watches extends Electronics
{
    private static ArrayList<Watches> watchesList = new ArrayList<Watches>();

    private boolean isDigitalWatch;
    private boolean isSmartWatch;
    private boolean isWaterProof;
    private int batteryLife;
    private String madeIn;
    private String character;
    private int size;

    public Watches(String productName, String movie, float price, int quantity, boolean hasOffer, String sourceFactory, boolean usesElectricity, boolean containsCharacter, boolean containsLogo, boolean isDigitalWatch, boolean isSmartWatch, boolean isWaterProof, int batteryLife, String madeIn, String character) {
        super(productName, movie, price, quantity, hasOffer, sourceFactory, usesElectricity, containsCharacter, containsLogo);
        this.isDigitalWatch = isDigitalWatch;
        this.isSmartWatch = isSmartWatch;
        this.isWaterProof = isWaterProof;
        this.batteryLife = batteryLife;
        this.madeIn = madeIn;
        this.character = character;

        watchesList.add(this);
    }

    public boolean isDigitalWatch() {
        return isDigitalWatch;
    }

    public void setDigitalWatch(boolean digitalWatch) {
        isDigitalWatch = digitalWatch;
    }

    public boolean isSmartWatch() {
        return isSmartWatch;
    }

    public void setSmartWatch(boolean smartWatch) {
        isSmartWatch = smartWatch;
    }

    public boolean isWaterProof() {
        return isWaterProof;
    }

    public void setWaterProof(boolean waterProof) {
        isWaterProof = waterProof;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public static ArrayList<Watches> getWatchesList() {
        return watchesList;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void OfferCalculator(int percentageOff) {
        ArrayList<Watches> discountedList = watchesList;

        for ( Watches i : discountedList )
        {
            i.setPrice(getPrice() * (percentageOff/100));
        }
    }

    @Override
    public String toString() {
        return "Watches{" +
                "isDigitalWatch=" + isDigitalWatch +
                ", isSmartWatch=" + isSmartWatch +
                ", isWaterProof=" + isWaterProof +
                ", batteryLife=" + batteryLife +
                ", madeIn='" + madeIn + '\'' +
                ", character='" + character + '\'' +
                '}';
    }

    public boolean SizeCompatibility(int size)
    {
        if ( this.size == size )
            return true;
        else
            return false;
    }

    public ArrayList<Watches> FilterCompatible(int size)
    {
        ArrayList<Watches> resultList = new ArrayList<Watches>();

        for ( Watches watch : watchesList )
            if ( watch.SizeCompatibility(size) == true)
                resultList.add(watch);

        return resultList;
    }

    public ArrayList<Watches> FilterPriceAndCompatibility(int size, float lowerPrice, float upperPrice)
    {
        ArrayList<Watches> compatibleList = FilterCompatible(size);
        ArrayList<Watches> resultList = new ArrayList<Watches>();

        for ( Watches watch : compatibleList )
            if ( watch.getPrice() >= lowerPrice && watch.getPrice() <= upperPrice )
                resultList.add(watch);

        return resultList;
    }

    public ArrayList<Watches> MerchRelatedToMovie(Movies movie)
    {
        ArrayList<Watches> targetList = new ArrayList<Watches>();

        for ( Watches merch : watchesList )
        {
            if(merch.getMovie().equals(movie))
            {
                targetList.add(merch);
            }
        }

        return targetList;
    }

    public ArrayList<Watches> FilterPrice(float lowerPrice, float upperPrice)
    {
        ArrayList<Watches> filteredList = new ArrayList<Watches>();

        for ( Watches merch : watchesList )
        {
            if(merch.getPrice() >= lowerPrice && merch.getPrice() <= upperPrice)
            {
                filteredList.add(merch);
            }
        }

        return filteredList;
    }

    public ArrayList<Watches> FilterPriceAndMovie(Movies movie, float lowerPrice, float upperPrice)
    {
        ArrayList<Watches> resultList = new ArrayList<Watches>();
        ArrayList<Watches> movieFilteredList = this.MerchRelatedToMovie(movie);

        for ( Watches merch : movieFilteredList )
        {
            if(merch.getPrice() >= lowerPrice && merch.getPrice() <= upperPrice)
            {
                resultList.add(merch);
            }
        }

        return resultList;
    }

    public Watches FindWatchByID(int ID)
    {
        for ( Watches merch : watchesList )
            if ( merch.getProductID() == ID )
                return merch;

        return null;
    }

    public boolean BuyWatch(Watches merch, CustomerShoppingCart cart)
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
}
