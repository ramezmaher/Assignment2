
public class MyLinkedList {
LinkedListNode head;
public void add(int val) {
	LinkedListNode node = new LinkedListNode();
	node.value=val;
	node.next=null;
	if (head == null) {
		head = node;
	}
	else {
		LinkedListNode n;
		n=head;
		while (n.next != null) {
			n=n.getNext();
		}
		n.next=node;
	}
}
public void show() {
	LinkedListNode no=head;
	while (no.next != null) {
		System.out.print(no.getValue()+" ");
		no=no.getNext();
	}
	System.out.print(no.getValue());
}
}