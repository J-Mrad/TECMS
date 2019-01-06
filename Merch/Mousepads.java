package Merch;

import java.util.ArrayList;

import Schedules.Movies;

@SuppressWarnings("serial")
public class Mousepads extends Electronics
{
    private static ArrayList<Mousepads> mousepadsList = new ArrayList<Mousepads>();

    private int height;
    private int width;
    private String material;
    private String shape;
    private boolean imageInsertable;
    private boolean forGaming;
    private String characterPictureOf;

    public Mousepads(String productName, String movie, float price, int quantity, boolean hasOffer, String sourceFactory, boolean usesElectricity, boolean containsCharacter, boolean containsLogo, int height, int width, String material, String shape, boolean imageInsertable, boolean forGaming, String characterPictureOf) {
        super(productName, movie, price, quantity, hasOffer, sourceFactory, usesElectricity, containsCharacter, containsLogo);
        this.height = height;
        this.width = width;
        this.material = material;
        this.shape = shape;
        this.imageInsertable = imageInsertable;
        this.forGaming = forGaming;
        this.characterPictureOf = characterPictureOf;

        mousepadsList.add(this);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public boolean isImageInsertable() {
        return imageInsertable;
    }

    public void setImageInsertable(boolean imageInsertable) {
        this.imageInsertable = imageInsertable;
    }

    public boolean isForGaming() {
        return forGaming;
    }

    public void setForGaming(boolean forGaming) {
        this.forGaming = forGaming;
    }

    public String getCharacterPictureOf() {
        return characterPictureOf;
    }

    public void setCharacterPictureOf(String characterPictureOf) {
        this.characterPictureOf = characterPictureOf;
    }

    public static ArrayList<Mousepads> getMousepadsList() {
        return mousepadsList;
    }

    public void OfferCalculator(int percentageOff) {
        ArrayList<Mousepads> discountedList = mousepadsList;

        for ( Mousepads i : discountedList )
        {
            i.setPrice(getPrice() * (percentageOff/100));
        }
    }

    @Override
    public String toString() {
        return "Mousepads{" +
                "height=" + height +
                ", width=" + width +
                ", material='" + material + '\'' +
                ", shape='" + shape + '\'' +
                ", imageInsertable=" + imageInsertable +
                ", forGaming=" + forGaming +
                ", characterPictureOf='" + characterPictureOf + '\'' +
                '}';
    }

    public float SuggestPrice()
    {
        float suggestedPrice;

        float sizeValue = (height * width) / 100;

        float qualitiesValue = 1;
        if ( forGaming == true ) qualitiesValue = (float)1.5;
        if ( imageInsertable == true ) qualitiesValue *= 1.2;

        float intermediateValue = sizeValue * qualitiesValue;

        switch(material)
        {
            case "plastic":
                suggestedPrice = (float)(intermediateValue * 0.5);
                break;
            case "wool":
                suggestedPrice = (float)(intermediateValue * 0.7);
                break;
            case "leather":
                suggestedPrice = intermediateValue;
                break;
            default:
                suggestedPrice = (float)(intermediateValue * 0.5);
                break;
        }

        return suggestedPrice;
    }

    public ArrayList<Mousepads> MerchRelatedToMovie(Movies movie)
    {
        ArrayList<Mousepads> targetList = new ArrayList<Mousepads>();

        for ( Mousepads merch : mousepadsList )
        {
            if(merch.getMovie().equals(movie))
            {
                targetList.add(merch);
            }
        }

        return targetList;
    }

    public ArrayList<Mousepads> FilterPrice(float lowerPrice, float upperPrice)
    {
        ArrayList<Mousepads> filteredList = new ArrayList<Mousepads>();

        for ( Mousepads merch : mousepadsList )
        {
            if(merch.getPrice() >= lowerPrice && merch.getPrice() <= upperPrice)
            {
                filteredList.add(merch);
            }
        }

        return filteredList;
    }

    public ArrayList<Mousepads> FilterPriceAndMovie(Movies movie, float lowerPrice, float upperPrice)
    {
        ArrayList<Mousepads> resultList = new ArrayList<Mousepads>();
        ArrayList<Mousepads> movieFilteredList = this.MerchRelatedToMovie(movie);

        for ( Mousepads merch : movieFilteredList )
        {
            if(merch.getPrice() >= lowerPrice && merch.getPrice() <= upperPrice)
            {
                resultList.add(merch);
            }
        }

        return resultList;
    }

    public Mousepads FindMousepadByID(int ID)
    {
        for ( Mousepads merch : mousepadsList )
            if ( merch.getProductID() == ID )
                return merch;

        return null;
    }

    public boolean BuyMousepad(Mousepads merch, CustomerShoppingCart cart)
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
