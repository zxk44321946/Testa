package test;

public class User {
	
	private String username;
    private String password;
    public User(){
    	super();
    }
    public User(String username,String password){
    	this.password=password;
    	this.username=username;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
