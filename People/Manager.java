package People;


/*
        Manager Class. Extends Employee class

        Constructor

            _AddManager(...)
            _AddClerk(...)
            _RemoveEmployee(...)
 */

import Files.Clerk_Save;
import Files.Manager_Save;
import Interface.Account;
import Interface.UsageLog;

public class Manager extends Employee
{
	

    public Manager(float _hourlyWage, int _hoursPerWeek,  int _shiftStartingHour, int _shiftEndingHour, String _firstName, String _lastName, int _age)
    {
        super(_hourlyWage, _hoursPerWeek, _shiftStartingHour, _shiftEndingHour, _firstName, _lastName, _age);

    }
    
    public Manager(float _hourlyWage, int _hoursPerWeek,  int _shiftStartingHour, int _shiftEndingHour, String _firstName, String _lastName, int _age, int ID)
    {
        super(_hourlyWage, _hoursPerWeek, _shiftStartingHour, _shiftEndingHour, _firstName, _lastName, _age, ID);

    }

    public static void AddClerk(float _hourlyWage, int _hoursPerWeek, int _shiftStartingHour, int _shiftEndingHour, String _firstName, String _lastName, int _age)
    {
        Clerk newClerk = new Clerk(_hourlyWage, _hoursPerWeek, _shiftStartingHour, _shiftEndingHour, _firstName, _lastName, _age);

        Clerk_Save.AddClerk(newClerk);
    }

    public static void AddManager(float _hourlyWage, int _hoursPerWeek, int _shiftStartingHour, int _shiftEndingHour, String _firstName, String _lastName, int _age)
    {
        Manager newManager = new Manager(_hourlyWage, _hoursPerWeek, _shiftStartingHour, _shiftEndingHour, _firstName, _lastName, _age);

        Manager_Save.AddManager(newManager);
    }
    
    public static boolean RemoveEmployee(int ID, Account A)
    {
		for(Manager M : Manager_Save.getList()) {
			
			if( ID == M.getEmployeeID()) {
					
				//
				Manager_Save.RemoveManager(M);
				
				UsageLog.add(A.getUsername() + " has fired " + M.getFirstName() + " " + M.getLastName());
				//
				
				return true;
			}
		}
		
		for(Clerk C : Clerk_Save.getList()) {
			
				if( ID == C.getEmployeeID()) {
				
				//
				Clerk_Save.RemoveClerk(C);
				
				UsageLog.add(A.getUsername() + " has fired " + C.getFirstName() + " " + C.getLastName());
				//
				
				
				return true;
			}
		}

        return false;
    }
    
    
}
