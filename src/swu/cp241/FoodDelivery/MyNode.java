package swu.cp241.FoodDelivery;

public class MyNode {
	
	private Object data;
	private MyNode nextNode;
	MyNode(Object object) {
		this(object, null);
	}
	MyNode (Object object,MyNode node) {
		data = object;
		nextNode = node;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object object) {
		data = object;
	}
	public void setNextNode(MyNode node) {
		nextNode = node;
	}
	public MyNode getNextNode() {
		return nextNode;
	}
    
}


