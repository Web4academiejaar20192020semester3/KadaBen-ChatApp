package domain;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

	private String status;
    private ArrayList<Person> friends;
	private String userId;
	private String password;
	private String firstName;
	private String lastName;
	private String geslacht;
	private String leeftijd;
	private Role role;

	public Person(String userId, String password, String firstName,
			String lastName, String leeftijd, String geslacht, Role role) {
		setUserId(userId);
		setPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
		setLeeftijd(leeftijd);
		setGeslacht(geslacht);
		setRole(role);
		setStatus("Offline");
		this.friends = new ArrayList<>();
	}

	public Person(String userId, String password, String firstName,
				  String lastName, String leeftijd, String geslacht) {
		setUserId(userId);
		setPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
		setLeeftijd(leeftijd);
		setGeslacht(geslacht);
		setRole(Role.LID);
		setStatus("Offline");
		this.friends = new ArrayList<>();
	}

	public Person() {
        this.friends = new ArrayList<>();
	}

	public void addFriend(Person p) {
	    if (!friends.contains(p)) {friends.add(p);}
    }

    public void setFriends(ArrayList<Person> persons) {
	    this.friends = persons;
    }

    public ArrayList<Person> getFriends() {
	    return this.friends;
    }

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		if (status == null || status.isEmpty()) {
			throw new DomainException("Invalid status: can't be empty.");
		} else {
			this.status = status;
		}
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role=role;
	}
	

	public void setUserId(String userId) {
		if (userId.isEmpty()) {
			throw new IllegalArgumentException("No id given");
		}
		String USERID_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(USERID_PATTERN);
		Matcher m = p.matcher(userId);
		/*if (!m.matches()) {
			throw new IllegalArgumenxtException("Email not valid");
		}*/
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public String getFullName() {
		return this.firstName+this.lastName;
	}

	public String getPassword() {
		return password;
	}

	public boolean isCorrectPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		return getPassword().equals(password);
	}

	public void setPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.isEmpty()) {
			throw new IllegalArgumentException("No firstname given");
		}
		this.firstName = firstName;// firstName;

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.isEmpty()) {
			throw new IllegalArgumentException("No last name given");
		}
		this.lastName = lastName;
	}

	public String getGeslacht() {
		return geslacht;
	}

	public void setGeslacht(String geslacht) {
		if (geslacht == null || geslacht.isEmpty()) throw new IllegalArgumentException("geslacht mag niet leeg zijn");
		this.geslacht = geslacht;
	}

	public String getLeeftijd() {
		return leeftijd;
	}

	public void setLeeftijd(String leeftijd) {
		if (leeftijd == null || leeftijd.isEmpty()) throw new IllegalArgumentException("leeftijd mag niet leeg zijn");
		this.leeftijd = leeftijd;
	}


}
