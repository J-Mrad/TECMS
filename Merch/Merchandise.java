package Merch;

import java.io.Serializable;

public class Merchandise implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1756624457312458291L;
	
	private String productName;
    private String movie;
    private float price;
    private int quantity;
    private boolean hasOffer;

    private int productID;
    public static int availableProductID = 1;

    public Merchandise(String productName, String movie, float price, int quantity, boolean hasOffer) {
        this.productName = productName;
        this.movie = movie;
        this.price = price;
        this.quantity = quantity;
        this.hasOffer = hasOffer;

        this.productID = availableProductID;
        availableProductID++;

    }

    public static Merchandise getFromID(int sID) {
    	for(Tshirts TS : Tshirts.getTshirtsList()) {
    		if (TS.getProductID() == sID) return TS;
    	}
    	for(ToyProps TS : ToyProps.getToyPropsList()) {
    		if (TS.getProductID() == sID) return TS;
    	}
    	for(Posters TS : Posters.getPostersList()) {
    		if (TS.getProductID() == sID) return TS;
    	}
    	for(ActionFigures TS : ActionFigures.getActionFiguresList()) {
    		if (TS.getProductID() == sID) return TS;
    	}
    	return null;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isHasOffer() {
        return hasOffer;
    }

    public void setHasOffer(boolean hasOffer) {
        this.hasOffer = hasOffer;
    }


    public int getProductID() {
        return productID;
    }

    @Override
    public String toString() {
        return "Merchandise{" +
                "productName='" + productName + '\'' +
                ", movie=" + movie +
                ", price=" + price +
                ", quantity=" + quantity +
                ", hasOffer=" + hasOffer +
                ", productID=" + productID +
                '}';
    }


}
