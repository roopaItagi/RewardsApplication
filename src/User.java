

import java.util.ArrayList;
import java.util.List;

public class User {

	int id;
	String name;
	String password;
	int points;
	int amount;
	ArrayList<String> giftrewards =new ArrayList<>();
	
	public User(int id, String name, String password, int points) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.points = points;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public ArrayList<String> getGiftrewards() {
		return giftrewards;
	}
	public void setGiftrewards(ArrayList<String> giftrewards) {
		this.giftrewards = giftrewards;
	}
}
