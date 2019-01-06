package Merch;

import java.io.Serializable;
import java.util.ArrayList;

import Schedules.Movies;

@SuppressWarnings("serial")
public class Posters extends Merchandise implements Serializable
{
	public static ArrayList<Posters> postersList = new ArrayList<Posters>();

    private String characterDisplayed;
    private int height;
    private int width;
    private String fabricType;
    private int resolution_height;
    private int resolution_width;
    private int pixelDensity;

    public Posters(String productName, String movie, float price, int quantity, boolean hasOffer, String characterDisplayed, int height, int width, String fabricType, int resolution_height, int resolution_width, int pixelDensity) {
        super(productName, movie, price, quantity, hasOffer);
        this.characterDisplayed = characterDisplayed;
        this.height = height;
        this.width = width;
        this.fabricType = fabricType;
        this.resolution_height = resolution_height;
        this.resolution_width = resolution_width;
        this.pixelDensity = pixelDensity;

        postersList.add(this);
    }

    public String getCharacterDisplayed() {
        return characterDisplayed;
    }

    public void setCharacterDisplayed(String characterDisplayed) {
        this.characterDisplayed = characterDisplayed;
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

    public String getFabricType() {
        return fabricType;
    }

    public void setFabricType(String fabricType) {
        this.fabricType = fabricType;
    }

    public int getResolution_height() {
        return resolution_height;
    }

    public void setResolution_height(int resolution_height) {
        this.resolution_height = resolution_height;
    }

    public int getResolution_width() {
        return resolution_width;
    }

    public void setResolution_width(int resolution_width) {
        this.resolution_width = resolution_width;
    }

    public int getPixelDensity() {
        return pixelDensity;
    }

    public void setPixelDensity(int pixelDensity) {
        this.pixelDensity = pixelDensity;
    }

    public static ArrayList<Posters> getPostersList() {
        return postersList;
    }

    public void OfferCalculator(int percentageOff) {
        ArrayList<Posters> discountedList = postersList;

        for ( Posters i : discountedList )
        {
            i.setPrice(getPrice() * (percentageOff/100));
        }
    }

    @Override
    public String toString() {
        return "Posters{" +
                "characterDisplayed='" + characterDisplayed + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", fabricType='" + fabricType + '\'' +
                ", resolution_height=" + resolution_height +
                ", resolution_width=" + resolution_width +
                ", pixelDensity=" + pixelDensity +
                '}';
    }

    public float SuggestPrice()
    {
        float suggestedPrice;

        float area = this.height * this.width;
        float areaValue = area / 1000;

        float pixelArea = this.resolution_height * this.resolution_width;
        float pixelValue = pixelArea / 8000000;

        float sizeValue = areaValue * ( pixelValue * this.pixelDensity );

        switch(this.fabricType)
        {
            case "paper":
                suggestedPrice = (float)(sizeValue * 0.2);
                break;
            case "linen":
                suggestedPrice = (float)(sizeValue * 0.5);
                break;
            case "carbon fiber":
                suggestedPrice = (float)(sizeValue * 0.7);
                break;
            case "leather":
                suggestedPrice = (float)(sizeValue);
                break;
            default:
                suggestedPrice = (float)(sizeValue * 0.5);
                break;
        }

        return suggestedPrice;
    }

    public ArrayList<Posters> posterRelatedToMovie(Movies movie)
    {
        ArrayList<Posters> targetList = new ArrayList<Posters>();

        for ( Posters poster : postersList )
        {
            if(poster.getMovie().equals(movie))
            {
                targetList.add(poster);
            }
        }

        return targetList;
    }

    public ArrayList<Posters> FilterPrice(float lowerPrice, float upperPrice)
    {
        ArrayList<Posters> filteredList = new ArrayList<Posters>();

        for ( Posters poster : postersList )
        {
            if(poster.getPrice() >= lowerPrice && poster.getPrice() <= upperPrice)
            {
                filteredList.add(poster);
            }
        }

        return filteredList;
    }

    public ArrayList<Posters> FilterPriceAndMovie(Movies movie, float lowerPrice, float upperPrice)
    {
        ArrayList<Posters> resultList = new ArrayList<Posters>();
        ArrayList<Posters> movieFilteredList = this.posterRelatedToMovie(movie);

        for ( Posters poster : movieFilteredList )
        {
            if(poster.getPrice() >= lowerPrice && poster.getPrice() <= upperPrice)
            {
                resultList.add(poster);
            }
        }

        return resultList;
    }

    public Posters FindPosterByID(int ID)
    {
        for ( Posters poster : postersList )
            if ( poster.getProductID() == ID )
                return poster;

        return null;
    }

    public boolean BuyPoster(Posters poster, CustomerShoppingCart cart)
    {
        if ( poster.getQuantity() <= 0 )
            return false;

        if ( cart.AddItem(poster) )
        {
            poster.setQuantity(poster.getQuantity()-1);
            return true;
        }
        else
            return false;
    }

}
