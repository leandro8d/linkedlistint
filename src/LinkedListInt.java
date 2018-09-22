
public class LinkedListInt implements ILinkedListInt {

	// First element from list.
	private Node Root;

	public LinkedListInt() {

	}

	@Override
	public void Append(int number) { // Append a number into start of the list.
		try {
			// Verify if already exist a Root node.
			if (this.Root == null) {
				this.Root = new Node(number);
			} else {
				// get the last node from list and set the new number as the last element.
				_GeTail(this.Root).setNext(new Node(number));
			}

		} catch (Exception ex) {
			System.out.println("Fail on Append. " + ex.getMessage());
		}
	}

	@Override
	public void RemoveGraterThan(int value) { // Removes any number grater than parameter used.
		try {
			// calls the method used to remove the elements Grater than parameter value.
			_RemoveGraterThan(value, this.Root, null);

		} catch (Exception ex) {
			System.out.println("Fail on Remove Grater Than. " + ex.getMessage());
		}
	}

	@Override
	public void RemoveTailElement() { // Removes the last element from the list.
		try {
			// calls the method used to remove the elements.
			_RemoveTailElement(this.Root, null);
		} catch (Exception ex) {
			System.out.println("Fail on Remove Tail Element. " + ex.getMessage());
		}

	}

	// private method used to remove the elements.
	private Node _RemoveTailElement(Node node, Node last) {

		if (node.getNext() != null) {
			return _RemoveTailElement(node.getNext(), node);
		} else {
			if (last != null) {
				last.setNext(null);
				return last;
			} else {
				// see if the first element from list is the tail element and remove it.
				this.Root = null;
				return this.Root;
			}
		}
	}

	// private method used to get the last element from list.
	private Node _GeTail(Node node) {

		if (node.getNext() != null) {
			return _GeTail(node.getNext());
		} else
			return node;
	}

	// private method used to remove the elements grater than number passed by
	// param.
	private Node _RemoveGraterThan(int number, Node node, Node lastNode) {

		if (node != null) {
			// verify if the current node has a next element.
			if (node.getNext() != null) {
				// verify if the last node exists(should be the first element from list).
				if (lastNode != null) {
					if (node.getValue() > number) {
						lastNode.setNext(node.getNext());

						return _RemoveGraterThan(number, lastNode.getNext(), lastNode);

					} else {
						return _RemoveGraterThan(number, node.getNext(), node);
					}
				} else {
					if (node.getValue() > number) {
						// set the next element as root.
						this.Root = node.getNext();
						return _RemoveGraterThan(number, this.Root, null);
					} else
						return _RemoveGraterThan(number, this.Root.getNext(), this.Root);
				}
			} else {
				if (node.getValue() > number) {
					lastNode.setNext(null);
				}

				// returns the last used node.
				return lastNode;
			}
		}
		return node;

	}

}