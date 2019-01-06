package People;

/*
        Customer Class. Extends the People class

        Constructors
        Setters & Getters for Customer ID, Loyalty Points, total movies profit, money a customer has spent so far

        toString method

        Method that suggests a movie to a customer based on their watched list
 */


public class Customer extends People
{
    private int customerID;
    public static int availableCustomerID = 1;
    private int loyaltyPoints = 0;
    public static float totalMoviesProfit;         //total profit the cinema has made so far out of selling tickets
    public float moneyCustomerPaidSoFar;    //total amount of money a specific customer has spent so far in buying tickets and food
    public int moviesWatchedCount = 0 ;

    public Customer(String _firstName, String _lastName, int _age)
    {
        super(_firstName, _lastName, _age); 
        customerID = availableCustomerID;
        availableCustomerID++;
        
        loyaltyPoints = 0;
        moneyCustomerPaidSoFar=0;
        
    }
    
    public Customer(String _firstName, String _lastName, int _age, int loyaltyPoints, float moneyCustomerPaidSoFar,int moviesWatchedCount )
    {
        super(_firstName, _lastName, _age);

        customerID = availableCustomerID;
        availableCustomerID++;
        
        this.loyaltyPoints = loyaltyPoints;
        this.moneyCustomerPaidSoFar = moneyCustomerPaidSoFar;
        this.moviesWatchedCount = moviesWatchedCount;
    }
    
    public Customer(String _firstName, String _lastName, int _age, int loyaltyPoints, float moneyCustomerPaidSoFar,int moviesWatchedCount, int CID )
    {
        super(_firstName, _lastName, _age);

        customerID = CID;
        
        this.loyaltyPoints = loyaltyPoints;
        this.moneyCustomerPaidSoFar = moneyCustomerPaidSoFar;
        this.moviesWatchedCount = moviesWatchedCount;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public static float getTotalMoviesProfit() {
        return totalMoviesProfit;
    }

    public float getMoneyCustomerPaidSoFar() {
        return moneyCustomerPaidSoFar;
    }

}
