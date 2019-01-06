package Merch;

import java.io.Serializable;

public class Toys extends Merchandise  implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -960688934426249310L;
	
	private int ageGroup;
    private String type;
    private boolean framed;
    private boolean hasAccessories;

    public Toys(String productName, String movie, float price, int quantity, boolean hasOffer, int ageGroup, String type, boolean framed, boolean hasAccessories) {
        super(productName, movie, price, quantity, hasOffer);
        this.ageGroup = ageGroup;
        this.type = type;
        this.framed = framed;
        this.hasAccessories = hasAccessories;

    }

    public int getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isFramed() {
        return framed;
    }

    public void setFramed(boolean framed) {
        this.framed = framed;
    }

    public boolean isHasAccessories() {
        return hasAccessories;
    }

    public void setHasAccessories(boolean hasAccessories) {
        this.hasAccessories = hasAccessories;
    }


    @Override
    public String toString() {
        return "Toys{" +
                "ageGroup=" + ageGroup +
                ", type='" + type + '\'' +
                ", framed=" + framed +
                ", hasAccessories=" + hasAccessories +
                '}';
    }
}
