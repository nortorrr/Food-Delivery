package swu.cp241.FoodDelivery;

import java.util.ArrayList;

public class Order  {
	private String Email;
	private ArrayList<String> Qty;
	
	public Order(String emailC, ArrayList<String> qtyC) {
		this.Email = emailC;
		this.Qty = qtyC;
	}

	public void setOrder(String emailC, ArrayList<String> qtyC) {
		Email = emailC;
		Qty = qtyC;
		
	}

	public ArrayList<String> getQty() {
		return Qty;
	}
	
	
	public String getEmail() {
		return Email;
	}
	
}


