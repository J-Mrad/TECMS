package Merch;

import java.io.Serializable;
import java.util.ArrayList;

import Files.Merch_Save;


public class Tshirts extends Merchandise implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1539604914805590513L;

	public static ArrayList<Tshirts> tshirtsList = new ArrayList<Tshirts>();

    private char size; // L: large - M: medium - S: small
    private String fabricType;
    private String madeIn;
    private String color;
    private String type;

    public Tshirts(String productName, String movie, float price, int quantity, boolean hasOffer,
                   char size, String fabricType, String madeIn, String color, String type) throws SizeException
    {
        super(productName, movie, price, quantity, hasOffer);

        if(size != 'L' && size != 'M' && size != 'S')
        {
            throw new SizeException("Size must be either L, M, or S");
        }
        else
        {
            this.size = size;
            this.fabricType = fabricType;
            this.madeIn = madeIn;
            this.color = color;
            this.type = type;

            tshirtsList.add(this);
        }
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public String getFabricType() {
        return fabricType;
    }

    public void setFabricType(String fabricType) {
        this.fabricType = fabricType;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<Tshirts> getTshirtsList() {
        return tshirtsList;
    }


    public void OfferCalculator(int percentageOff) {
        ArrayList<Tshirts> discountedList = tshirtsList;

        for ( Tshirts i : discountedList )
        {
            i.setPrice(getPrice() * (percentageOff/100));
        }
    }


    public float SuggestPrice()
    {
        float suggestedPrice;

        float sizeValue;
        switch(size)
        {
            case 'S':
                sizeValue = 1;
                break;
            case 'M':
                sizeValue = (float)1.2;
                break;
            case 'L':
                sizeValue = (float)1.4;
                break;
            default:
                sizeValue = (float)1.5;
                break;
        }

        float typeValue;
        switch(type)
        {
            case "short sleeves":
                typeValue = 1;
                break;
            case "long sleeves":
                typeValue = (float)1.25;
                break;
            default:
                typeValue = (float)1.1;
                break;
        }

        float intermediateValue = sizeValue * typeValue * 10;

        switch(fabricType)
        {
            case "wool":
                suggestedPrice = (float)(intermediateValue * 1.2);
                break;
            case "cotton":
                suggestedPrice = (float)(intermediateValue * 1.4);
                break;
            case "leather":
                suggestedPrice = (float)(intermediateValue * 1.6);
                break;
            default:
                suggestedPrice = (float)(intermediateValue * 1.5);
                break;
        }

        return suggestedPrice;
    }

  /*  public ArrayList<Tshirts> TshirtsRelatedToMovie(Movies movie)
    {
        ArrayList<Tshirts> targetList = new ArrayList<Tshirts>();

        for ( Tshirts merch : tshirtsList )
        {
            if(merch.getMovie().equals(movie))
            {
                targetList.add(merch);
            }
        }

        return targetList;
    }
*/
    public ArrayList<Tshirts> FilterPrice(float lowerPrice, float upperPrice)
    {
        ArrayList<Tshirts> filteredList = new ArrayList<Tshirts>();

        for ( Tshirts merch : tshirtsList )
        {
            if(merch.getPrice() >= lowerPrice && merch.getPrice() <= upperPrice)
            {
                filteredList.add(merch);
            }
        }

        return filteredList;
    }

 /*   public ArrayList<Tshirts> FilterPriceAndMovie(Movies movie, float lowerPrice, float upperPrice)
    {
        ArrayList<Tshirts> resultList = new ArrayList<Tshirts>();
        ArrayList<Tshirts> movieFilteredList = this.TshirtsRelatedToMovie(movie);

        for ( Tshirts merch : movieFilteredList )
        {
            if(merch.getPrice() >= lowerPrice && merch.getPrice() <= upperPrice)
            {
                resultList.add(merch);
            }
        }

        return resultList;
    }
*/
    public Tshirts FindTshirtsByID(int ID)
    {
        for ( Tshirts merch : tshirtsList )
            if ( merch.getProductID() == ID )
                return merch;

        return null;
    }

    public boolean BuyTshirts(Tshirts merch, CustomerShoppingCart cart)
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
}
