package People;

/*
        Employee Class. Abstract class that extends People class.
        Children: Manager / Clerk

        Constructors
        Setters & Getters for hourly wage, hours per week, shift start and shift end, employment date

        toString method

        Each employee has his own unique ID
 */

public abstract class Employee extends People
{
    private int employeeID;
    public static int availableEmployeeID = 1;
    private float hourlyWage;
    private int hoursPerWeek;
    private int shiftStartingHour, shiftEndingHour;

    public Employee(float _hourlyWage, int _hoursPerWeek, int _shiftStartingHour, int _shiftEndingHour, String _firstName, String _lastName, int _age)
    {
        super(_firstName, _lastName, _age);
        hourlyWage = _hourlyWage;
        hoursPerWeek = _hoursPerWeek;
        shiftStartingHour = _shiftStartingHour;
        shiftEndingHour = _shiftEndingHour;

        employeeID = availableEmployeeID;
        availableEmployeeID++;
    }
    
    public Employee(float _hourlyWage, int _hoursPerWeek, int _shiftStartingHour, int _shiftEndingHour, String _firstName, String _lastName, int _age, int EID)
    {
        super(_firstName, _lastName, _age);
        hourlyWage = _hourlyWage;
        hoursPerWeek = _hoursPerWeek;
        shiftStartingHour = _shiftStartingHour;
        shiftEndingHour = _shiftEndingHour;

        employeeID = EID;
    }

    public int getshiftStartingHour() {
    	return shiftStartingHour;
    }
    public int getshiftEndingHour() {
    	return shiftEndingHour;
    }
    
    public int getEmployeeID() {
        return employeeID;
    }

    public float getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(float hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }


}
