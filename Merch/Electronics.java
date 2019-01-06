package Merch;

@SuppressWarnings("serial")
public class Electronics extends Merchandise
{

    private String sourceFactory;
    private boolean usesElectricity;
    private boolean containsCharacter;
    private boolean containsLogo;

    public Electronics(String productName, String movie, float price, int quantity, boolean hasOffer, String sourceFactory, boolean usesElectricity, boolean containsCharacter, boolean containsLogo) {
        super(productName, movie, price, quantity, hasOffer);
        this.sourceFactory = sourceFactory;
        this.usesElectricity = usesElectricity;
        this.containsCharacter = containsCharacter;
        this.containsLogo = containsLogo;
    }

    public String getSourceFactory() {
        return sourceFactory;
    }

    public void setSourceFactory(String sourceFactory) {
        this.sourceFactory = sourceFactory;
    }

    public boolean isUsesElectricity() {
        return usesElectricity;
    }

    public void setUsesElectricity(boolean usesElectricity) {
        this.usesElectricity = usesElectricity;
    }

    public boolean isContainsCharacter() {
        return containsCharacter;
    }

    public void setContainsCharacter(boolean containsCharacter) {
        this.containsCharacter = containsCharacter;
    }

    public boolean isContainsLogo() {
        return containsLogo;
    }

    public void setContainsLogo(boolean containsLogo) {
        this.containsLogo = containsLogo;
    }


    @Override
    public String toString() {
        return "Electronics{" +
                "sourceFactory='" + sourceFactory + '\'' +
                ", usesElectricity=" + usesElectricity +
                ", containsCharacter=" + containsCharacter +
                ", containsLogo=" + containsLogo +
                '}';
    }
}
