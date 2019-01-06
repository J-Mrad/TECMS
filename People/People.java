package People;

/*
    People Class. Abstract class for all human objects in the system...

    Children: Employee / Customer

    Constructors
    Setters & Getters for contact information (email, phone numbers), first name, last name, birthdate

    toString method

    Contact Information is a subclass inside this class.
    After creating an object of the classes that use this class or its children as superclass,
    you can create a ContactInfo object and add it to the foretold human object.
*/

public abstract class People
{
    public static class ContactInformation
    {
        private String email;
        private int phoneNumber1 = 0;
        private int phoneNumber2 = 0;

        public ContactInformation(String _email) { email = _email; }
        public ContactInformation(String _email, int _phoneNumber) { email = _email; phoneNumber1 = _phoneNumber; }
        public ContactInformation(int _phoneNumber) { phoneNumber1 = _phoneNumber; }
        public ContactInformation(String _email, int _phoneNumber1, int _phoneNumber2) { email = _email; phoneNumber1 = _phoneNumber1; phoneNumber2 = _phoneNumber2; }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getPhoneNumber1() {
            return phoneNumber1;
        }

        public void setPhoneNumber1(int phoneNumber1) {
            this.phoneNumber1 = phoneNumber1;
        }

        public int getPhoneNumber2() {
            return phoneNumber2;
        }

        public void setPhoneNumber2(int phoneNumber2) {
            this.phoneNumber2 = phoneNumber2;
        }

        public String toString()
        {
            return ( "Email: " + (email == null ? "None" : email) + " - PhoneNumber 1: " + (phoneNumber1 == 0 ? "None" : phoneNumber1) + " - PhoneNumber 2: " + (phoneNumber2 == 0 ? "None" : phoneNumber2) );
        }
    }
    private String firstName;
    private String lastName;
    private ContactInformation contactInfo;
    private int age;

    public People(String _firstName, String _lastName, int _age)
    {
        firstName = _firstName;
        lastName = _lastName;
        age = _age;
    }

    public int getage() {
        return age;
    }
    
    public void AddContactInformation(ContactInformation info)
    {
        contactInfo = info;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ContactInformation getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInformation contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String toString()
    {
        return ("Name: " + firstName + " " + lastName + " ::: age: " + age + " ::: Contact Information: " + getContactInfo());
    }


}
