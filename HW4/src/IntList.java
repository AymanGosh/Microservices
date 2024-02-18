
public class IntList {
	private IntNode _head;
	private IntNode _tail;

	public IntList() {
		_head = null;
	}

	public void addToEnd(int num) {
		// adds num at the end of the list
		IntNode node = new IntNode(num);
		if (_head == null)
			_head = node;
		else {
			IntNode ptr = _head;
			while (ptr.getNext() != null)
				ptr = ptr.getNext();
			ptr.setNext(node);
			_tail = node;
		}
	}

	public IntNode get_tail() {
		return _tail;
	}

	public String toString() {
		String s = "";
		IntNode temp = _head;
		while (temp != null) {
			s = s + temp.getValue() + " --> ";
			temp = temp.getNext();
		}
		s += " null";
		return s;
	}

	public IntNode get_head() {
		return _head;
	}

	/**
	 * Q1 - time complexity:O(n) / space complexity: O(1)
	 * 
	 * @param sum The target sum to check for in sublists.
	 * @return true if a sublist with the given sum exists, false otherwise.
	 */
	public boolean subListSum(int sum) {
		IntNode temp1 = _head;
		// Variable to store the running sum of the sublist
		int tempSum = 0;
		while (temp1 != null) {

			// Initialize a second pointer to the current position of the first pointer
			IntNode temp2 = temp1;

			// Update the running sum with the value of the current node
			tempSum += temp1.getValue();

			// Check if the running sum equals the target sum
			if (tempSum == sum) {
				return true;
			}

			// Adjust the running sum by removing elements from the sublist
			while (temp1 != null && tempSum > sum) {
				tempSum -= temp2.getValue();
				if (tempSum < 0) {
					break;
				}

				// Move the second pointer to the next node
				temp2 = temp2.getNext();
			}
			temp1 = temp1.getNext();
		}
		return false;
	}

	/***************************************************/

	/**
	 * Q2 - time complexity:O(n) / space complexity: O(1) Finds the node in the list
	 * where the absolute difference between the average of elements before and
	 * after the node is maximized.
	 *
	 * @return The node with the maximum difference in averages, or null if the list
	 *         is empty.
	 */
	public IntNode averageNode() {
		IntNode temp = _head;
		double maxAvg = Double.NEGATIVE_INFINITY;
		IntNode maxNode = null;

		// Running sums and counts for both halves of the list
		double sum1 = 0;
		int count1 = 0;

		double sum2 = 0;
		int count2 = 0;

		// Calculate initial sums and counts for both halves of the list
		while (temp != null) {
			sum2 += temp.getValue();
			count2++;
			temp = temp.getNext();
		}

		temp = _head;

		// Iterate through the list and update sums and counts
		while (temp != null && temp.getNext() != null) {
			// Update sums and counts for both halves
			sum1 += temp.getValue();
			count1++;

			sum2 -= temp.getValue();
			count2--;

			double avg1 = sum1 / count1;
			double avg2 = sum2 / count2;

			double difference = Math.abs(avg2 - avg1);

			if (difference > maxAvg) {
				maxAvg = difference;
				maxNode = temp;
			}

			temp = temp.getNext();
		}
		// Return the node with the maximum average difference
		return maxNode;
	}

}