package swu.cp241.FoodDelivery;

public interface QueueADT {

	public void enqueue(Object e) throws Exception;
	public Object dequeue() throws Exception;
	public boolean isEmpty();
	public boolean isFull();
	public void clear();
	public int length();

}
