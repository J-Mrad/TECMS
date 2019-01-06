package Merch;

@SuppressWarnings("serial")
public class PhoneAccessories extends Electronics
{

    private String phoneModel;
    private int weight;
    private boolean detachable;

    public PhoneAccessories(String productName, String movie, float price, int quantity, boolean hasOffer, String sourceFactory, boolean usesElectricity, boolean containsCharacter, boolean containsLogo, String phoneModel, int weight, boolean detachable) {
        super(productName, movie, price, quantity, hasOffer, sourceFactory, usesElectricity, containsCharacter, containsLogo);
        this.phoneModel = phoneModel;
        this.weight = weight;
        this.detachable = detachable;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isDetachable() {
        return detachable;
    }

    public void setDetachable(boolean detachable) {
        this.detachable = detachable;
    }


    @Override
    public String toString() {
        return "PhoneAccessories{" +
                "phoneModel='" + phoneModel + '\'' +
                ", weight=" + weight +
                ", detachable=" + detachable +
                '}';
    }

}
