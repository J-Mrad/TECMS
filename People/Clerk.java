package People;

import Files.Customer_Save;

/*
        Clerk Class. Extends Employee class

        Constructors

        Methods to manage customers:
            _AddCustomer(...)
            _FindCustomerByID(...)
                ->RemoveCustomer(...) , takes the customer object reference as input. Use FindCustomerByID to obtain that.

 */

public class Clerk extends Employee
{

    public Clerk(float _hourlyWage, int _hoursPerWeek, int _shiftStartingHour, int _shiftEndingHour, String _firstName, String _lastName, int _age)
    {
        super(_hourlyWage, _hoursPerWeek, _shiftStartingHour, _shiftEndingHour, _firstName, _lastName, _age);
    }
    
    public Clerk(float _hourlyWage, int _hoursPerWeek, int _shiftStartingHour, int _shiftEndingHour, String _firstName, String _lastName, int _age, int ID)
    {
        super(_hourlyWage, _hoursPerWeek, _shiftStartingHour, _shiftEndingHour, _firstName, _lastName, _age, ID);
    }
    

    public static void AddCustomer(String _firstName, String _lastName, int _age)
    {
        Customer newCustomer = new Customer(_firstName, _lastName, _age);

        Customer_Save.AddCustomer(newCustomer);
    }
    
    public static Customer FindCustomerByID(int ID)
    {
        for ( Customer i : Customer_Save.getList() )
        {
            if ( i.getCustomerID() == ID )
            {
                return i;
            }
        }

        return null;
    }

    public static boolean RemoveCustomer(Customer c)
    {
        if(c != null)
        {
        	Customer_Save.getList().remove(c);
            return true;
        }

        return false;
    }
    
    
    
}
