package swu.cp241.FoodDelivery;

public class LinkedQueue implements QueueADT {

	Object e;
	MyNode head = null;
	MyNode tail = null;
	int size = 0;

	public LinkedQueue() {
		Queue();
	}

	public void Queue() {
		head = tail = null;
	}

	public void enqueue(Object e) throws Exception {
		if (isFull()) {
			throw new Exception("Queue is full");
		} else {
			if (isEmpty()) {
				MyNode p = new MyNode(e);
				head = tail = p;
			} else {
				MyNode p = new MyNode(e);
				tail.setNextNode(p);
				tail = p;
			}
			size++;
		}
	}

	public Object dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is empty");
		} else {
			MyNode p = head;
			head = head.getNextNode();
			return p.getData();
		}
	}

	public boolean isEmpty() {
		if (tail == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {
		return false;
	}

	public void clear() {
		head = tail = null;
		size = 0;
	}

	public int length() {
		return size;
	}

}
