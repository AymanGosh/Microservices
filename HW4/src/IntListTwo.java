
public class IntListTwo {
	IntNodeTwo _head, _tail;
	private int MAX_TIMES = 100;

	public IntListTwo() {
		_head = null;
		_tail = null;
	}

	/**
	 * Adds a new element to the end of the two-way linked list.
	 *
	 * This method creates a new node with the specified integer value and appends
	 * it to the end of the list. If the list is empty, the new node becomes both
	 * the head and the tail of the list. Otherwise, the new node is connected to
	 * the current tail, and the tail is updated to the new node.
	 *
	 * @param num The integer to add to the end of the list.
	 */
	public void addToEnd(int num) {
		// Create a new node
		IntNodeTwo newNode = new IntNodeTwo(num);
		// If the list is empty, set both head and tail to the new node
		if (_head == null) {
			_head = newNode;
			_tail = newNode;
		} else {
			// Traverse the list to find the current tail node
			IntNodeTwo temp = _head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			// Connect the new node to the current tail
			temp.setNext(newNode);
			newNode.setPrev(temp);
			// Update the tail to the new node
			_tail = newNode;
		}
	}

	/**
	 * Converts the two-way linked list to a string representation.
	 *
	 * @return A string representation of the two-way linked list.
	 */
	public String toString() {
		// If the list is empty, return an empty string representation

		if (_head == null)
			return "{}";
		// Start building the string representation
		String s = "{";
		IntNodeTwo temp = _head;
		while (temp.getNext() != null) {
			s = s + temp.getNum() + ", ";
			temp = temp.getNext();
		}
		// Append the last element and close the string representation
		s += temp.getNum() + "}";
		return s;
	}

	/**
	 * Converts the two-way linked list to a string representation in reverse order.
	 *
	 * This method generates a reversed string representation of the two-way linked
	 * list by utilizing a recursive helper method. The resulting string is enclosed
	 * in curly braces. If the list is empty, an empty string representation is
	 * returned.
	 *
	 * @return A string representation of the two-way linked list in reverse order.
	 */
	public String toStringReverse() {
		if (_head == null)
			return "{}";

		// Use a recursive helper method to build the reversed string representation
		return "{" + reverseIntListTwo(_head, "") + "}";
	}

	/**
	 * Recursively reverses the two-way linked list and constructs a string
	 * representation.
	 *
	 * @param current The current node in the traversal.
	 * @param s       The intermediate string representation.
	 * @return The final reversed string representation of the two-way linked list.
	 */
	public String reverseIntListTwo(IntNodeTwo current, String s) {

		if (current == null)
			return s;
		// Recursive case: build the reversed string representation
		if (current == _head) {
			return reverseIntListTwo(current.getNext(), current.getNum() + "") + s;
		} else {
			return reverseIntListTwo(current.getNext(), current.getNum() + ", ") + s;
		}
	}

	/******************************************/
	// q4
	private IntNodeTwo moveRight(IntNodeTwo current, int steps) {
		if (current == null)
			return null;
		if (steps == 0) {
			return current;
		} else {
			return moveRight(current.getNext(), steps - 1);
		}
	}

	private IntNodeTwo moveLeft(IntNodeTwo current, int steps) {
		if (current == null)
			return null;
		if (steps == 0) {
			return current;
		} else {
			return moveLeft(current.getPrev(), steps - 1);
		}
	}

	/**
	 * Recursively moves through the two-way linked list based on the values in the
	 * links.
	 *
	 * @param current The current node in the traversal.
	 * @param flag    The maximum number of times to attempt moving in either
	 *                direction.
	 * @return True if a valid path is found; false otherwise.
	 */
	private boolean move(IntNodeTwo current, int flag) {
		if (current == _tail) {
			// Reached the end of the list, a valid path is found
			return true;
		}
		if (current == null || flag == 0) {
			// Current node is null or reached the maximum number of attempts, no valid path
			// found

			return false;
		}

		// Calculate the number of steps based on the current node's value
		int steps = current.getNum();
		// Move right and left in the list
		IntNodeTwo rightNodeTwo = moveRight(current, steps);
		IntNodeTwo leftNode = moveLeft(current, steps);
		// Recursively check for valid paths in both directions
		return move(rightNodeTwo, flag - 1) || move(leftNode, flag - 1);
	}

	/**
	 * Recursively checks for valid paths in the two-way linked list.
	 *
	 * @param current The current node in the traversal.
	 * @return True if there is a valid path; false otherwise.
	 */
	public boolean checkWays(IntNodeTwo current) {
		if (current != null) {
			// Continue checking for valid paths in the next node
			checkWays(current.getNext());
			// Check if there is a cycle and try MAX_TIMES times then stop
			return move(current, MAX_TIMES);
		} else {
			// End of the list, no valid path found
			return false;
		}
	}

	/**
	 * Checks if there is a valid path in the two-way linked list.
	 *
	 * A valid path is defined as a series of links starting at the top of the list
	 * and progressing either to the right or left based on the value in the link.
	 * It is not possible to advance beyond the limits of the list in either
	 * direction, and the route should end in the other link.
	 *
	 * @return True if there is a valid path; false otherwise.
	 */
	public boolean isWay() {
		return checkWays(_head);
	}
}
