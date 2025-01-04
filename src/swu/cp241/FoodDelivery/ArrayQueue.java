package swu.cp241.FoodDelivery;

public class ArrayQueue implements QueueADT {
	 private int total;
	 private Object s[];
	 int front,rear;
	 public ArrayQueue(){
		 Queue();
	 }
	 public void Queue(){
		 front = -1;
		 rear = -1;
		 total = 20;
		 s = new Object[total];
	 }
	 @Override
	 public void enqueue(Object e) throws Exception {
		 if(isFull()) {
			 throw new Exception("Queue is full");
		 }else {
			 rear++;      
			 s[rear]=e;   
		 }
	 }
	 @Override
	 public Object dequeue() throws Exception {
		 if(isEmpty()) {
			 throw new Exception("Queue is empty");
		 }else {
			 front++;            
			 return s[front];    
		 }
	 }
	 @Override
	 public boolean isEmpty() {
		 if(rear==-1) {
			 return true;
		 }else {
			 return false;
		 }
	 }
	 @Override
	 public boolean isFull() {
		 if(rear==total-1) {
			 return true;
		 }else {
			 return false;
		 }
	 }
	 @Override
	 public void clear() {
		 front = -1;
		 rear = -1;
		 total = 3;
		 s = new Object[total];
	 }
	 @Override
	 public int length() {
		 return 0;
	 }
}