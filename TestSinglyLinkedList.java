

public class TestSinglyLinkedList {

	public static void main(String[] args) {

		/*
		System.out.println("===================================================");

		SinglyLinkedList test = new SinglyLinkedList();
		test.addFirst("str1");
		test.addFirst("str2");
		test.addFirst("str3");
		System.out.println(test.getSize());
		//System.out.println(test.removeFirst());
		System.out.println(test.getSize());
		test.addLast("str4");
		System.out.println(test.getSize());
		//test.removeAfter(test.next);
		System.out.println(test.removeFirst());
		System.out.println(test.removeFirst());
		System.out.println(test.removeFirst());
		System.out.println(test.getSize());

		System.out.println("===================================================");

		SinglyLinkedList test2 = new SinglyLinkedList();
		test2.add("hello");
		test2.add("world");
		System.out.println(test2.getSize());
		System.out.println(test2.get(0));
		System.out.println(test2.get(1));
		test2.set(0,"helloooooooo");
		System.out.println(test2.get(0));
		System.out.println("test toString " + test2.toString());

		System.out.println("===================================================");

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertFront(1);
		//list.insertEnd(2); <-- Null pointer exception
		System.out.println(list.toString());
		*/
		SinglyLinkedList myList = new SinglyLinkedList();
		myList.addFirst("hello");
		myList.addFirst(" world");
		System.out.println(myList.toString());
		System.out.println(myList.contains("hello"));
		System.out.println(myList.contains("hell o"));


	}

}
