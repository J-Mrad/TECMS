package Interface;


public class Account {
	
	private String Username = "xxx";
	private int Password = 123;
	private Boolean admin = false;
		
	protected Boolean isManager = false;

	public Account(String Username, int Password, Boolean admin) {
		this.Username = Username;
		this.Password = Password;
		this.admin = admin;		
	}
	
	public String getUsername() {
		return Username;
	}


	public int getPassword() {
		return Password;
	}

	public void setPassword(int password) {
		Password = password;
	}
	public Boolean getAdmin() {
		return admin;
	}
	
	public String toString() {
		return Username + " : " + Password;
		
	}
}
