package solution;
import java.util.HashMap;
import java.util.Map;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class RemoveZeroSumConsecutiveNodesfromLinkedList {
	public ListNode removeZeroSumSublists(ListNode head) {
		ListNode dummy = new ListNode(0, head);
		int prefix = 0;
		Map<Integer, ListNode> prefixToNode = new HashMap<>();
		prefixToNode.put(0, dummy);

		for (; head != null; head = head.next) {
			prefix += head.val;
			prefixToNode.put(prefix, head);
		}

		prefix = 0;

		for (head = dummy; head != null; head = head.next) {
			prefix += head.val;
			head.next = prefixToNode.get(prefix).next;
		}
		return dummy.next;
	}

}

