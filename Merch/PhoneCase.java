package Merch;

import java.util.ArrayList;

import Schedules.Movies;

@SuppressWarnings("serial")
public class PhoneCase extends PhoneAccessories
{
    private static ArrayList<PhoneCase> phoneCaseList = new ArrayList<PhoneCase>();

    private float height;
    private float width;
    private float depth;
    private String material;
    private String characterName;

    public PhoneCase(String productName, String movie, float price, int quantity, boolean hasOffer, String sourceFactory, boolean usesElectricity, boolean containsCharacter, boolean containsLogo, String phoneModel, int weight, boolean detachable, int height, int width, int depth, String material, String characterName) {
        super(productName, movie, price, quantity, hasOffer, sourceFactory, usesElectricity, containsCharacter, containsLogo, phoneModel, weight, detachable);
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.material = material;
        this.characterName = characterName;

        phoneCaseList.add(this);
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public static ArrayList<PhoneCase> getPhoneCaseList() {
        return phoneCaseList;
    }

    public void OfferCalculator(int percentageOff) {
        ArrayList<PhoneCase> discountedList = phoneCaseList;

        for ( PhoneCase i : discountedList )
        {
            i.setPrice(getPrice() * (percentageOff/100));
        }
    }

    @Override
    public String toString() {
        return "PhoneCase{" +
                "height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                ", material='" + material + '\'' +
                ", characterName='" + characterName + '\'' +
                '}';
    }

    public boolean DimensionCompatibility(float height, float width, float depth)
    {
        if ( this.height == height && this.width == width && this.depth == depth )
            return true;
        else
            return false;
    }

    public float SuggestPrice()
    {
        float suggestedPrice;

        float dimensionValue = (height * width * depth) / 100;

        switch(material)
        {
            case "plastic":
                suggestedPrice = (float)(dimensionValue * 0.4);
                break;
            case "rubber":
                suggestedPrice = (float)(dimensionValue * 0.6);
                break;
            case "leather":
                suggestedPrice = dimensionValue;
                break;
            default:
                suggestedPrice = (float)(dimensionValue * 0.5);
                break;
        }

        return suggestedPrice;

    }

    public ArrayList<PhoneCase> MerchRelatedToMovie(Movies movie)
    {
        ArrayList<PhoneCase> targetList = new ArrayList<PhoneCase>();

        for ( PhoneCase merch : phoneCaseList )
        {
            if(merch.getMovie().equals(movie))
            {
                targetList.add(merch);
            }
        }

        return targetList;
    }

    public ArrayList<PhoneCase> FilterPrice(float lowerPrice, float upperPrice)
    {
        ArrayList<PhoneCase> filteredList = new ArrayList<PhoneCase>();

        for ( PhoneCase merch : phoneCaseList )
        {
            if(merch.getPrice() >= lowerPrice && merch.getPrice() <= upperPrice)
            {
                filteredList.add(merch);
            }
        }

        return filteredList;
    }

    public ArrayList<PhoneCase> FilterPriceAndMovie(Movies movie, float lowerPrice, float upperPrice)
    {
        ArrayList<PhoneCase> resultList = new ArrayList<PhoneCase>();
        ArrayList<PhoneCase> movieFilteredList = this.MerchRelatedToMovie(movie);

        for ( PhoneCase merch : movieFilteredList )
        {
            if(merch.getPrice() >= lowerPrice && merch.getPrice() <= upperPrice)
            {
                resultList.add(merch);
            }
        }

        return resultList;
    }

    public PhoneCase FindPhoneCaseByID(int ID)
    {
        for ( PhoneCase merch : phoneCaseList )
            if ( merch.getProductID() == ID )
                return merch;

        return null;
    }

    public boolean BuyPhoneCase(PhoneCase merch, CustomerShoppingCart cart)
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
