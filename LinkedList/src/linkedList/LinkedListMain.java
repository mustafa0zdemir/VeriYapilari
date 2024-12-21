package linkedList;

public class LinkedListMain {


	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		
		Node data1 = new Node(1);
		Node data2 = new Node(2);
		Node data3 = new Node(3);
		
		l.insertFirst(data1);
		l.insertFirst(data2);
		l.insertLast(data3);
		//l.write();
		l.deleteFirst();
		l.write();
		l.deleteLast();
		l.write();
	}

}
