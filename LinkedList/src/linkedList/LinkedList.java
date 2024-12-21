package linkedList;

public class LinkedList {
	
	Node head;
	Node tail;
	
	public LinkedList() {
		head = null;
		tail = null;
	}
	
	
	void insertFirst(Node newNode) {
		
		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		
		newNode.next = head;
		head = newNode;
	}
	
	
	void deleteFirst() {
		
		if(head == null) {
			System.out.println("Liste boş baştan silme yapılamaz");
		}
		head = head.next;
		if(head == null) {
			tail = null;
		}
	}
	
	void insertLast(Node newNode) {
		if(head == null) {
			head = newNode;
		}
		tail.next = newNode;
		tail = newNode;
	}
	
	
	void deleteLast() {
		Node tmp,previous;
		tmp = head;
		previous = null;
		while(tmp != tail) {
			previous = tmp;
			tmp = tmp.next;
		}
		if(previous == null) {
			head = null;
		}
		else {
			previous.next = null;
			tail = previous;
		}
		
	}
	
	Node search(int value) {
		Node tmp;
		tmp = head;
		while(tmp != null) {
			if(tmp.data == value)
				return tmp;
			tmp = tmp.next;
		}
		return null;
	}
	
	
	
	
	void deleteMiddle(Node s) {
		Node tmp,previous;
		tmp = head;
		previous = null;
		while(tmp!=s) {
			previous = tmp;
			tmp=tmp.next;
		}
		previous.next = s.next;
	}
	
	
	
	int nodeCount() {
		int count = 0;
		Node tmp;
		tmp = head;
		while(tmp != null) {
			tmp = tmp.next;
			count++;
		}
		return count;
	}
	
	
	
	void write() {
		Node tmp;
		tmp = head;
		while(tmp != null) {
			System.out.print(tmp.data);
			tmp = tmp.next;
			System.out.print(" -> ");
		}
	}

}
