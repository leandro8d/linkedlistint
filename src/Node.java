
public class Node {
	
	private int Value;
	private Node Next;
	
	public int getValue() {
		return Value;
	}

	public void setValue(int value) {
		Value = value;
	}

	public Node getNext() {
		return Next;
	}

	public void setNext(Node next) {
		Next = next;
	}

	public Node() {}
	
	public Node(int value) {
		Value = value;
	}
	
}
