//Max sotsky, Andrew Creaghan, Nick Lee

public class SinglyLinkedList implements List {

	private Node head;
	private int size;
	
	//Constructor 
	public SinglyLinkedList() {
		head = null;
		size = 0;
	}

	private static class Node {
		private Object data; // reference to the data 
		private Node next;	 // reference to the next node
		
		// Constructors
		
		/** Creates a new node with a null next field.
		 * 
		 *  @param dataItem The data we want to store
		 *   
		 */
		
		private Node(Object dataItem) {
			data = dataItem;
			next = null;
		}
		
		/** Creates a new node that references another node.
		 * 
		 *  @param dataItem The data we want to store
		 *  @param nodeRef The node references by the new node
		 *  
		 */
		
		private Node(Object dataItem, Node nodeRef) {
				data = dataItem;
				next = nodeRef;
			}
		
		private Node getNext() {
			return next;
		}
		
		private void setNext(Node aRef) {
			this.next = aRef;
		}
		
		private void setData(Object dataItem) {
			this.data = dataItem;
		}
		
		private Object getData() {
			return this.data;
		}
		
	}
	
	// Getters and Setters
	public int getSize() {							//___LIST INTERFACE METHOD___
		return this.size;
	}
	
	/** Add an item to the front of the list.
	 * 
	 * @param item The item to be added
	 * 
	 */
	public void addFirst(Object item) {
		// add code here
		head = new Node(item,head);
		size++;
	}
	
	public void addAfter(Node aNode, Object item) {
		// add code here
		aNode.next = new Node(item,aNode.next);
		size++;
	}
	
	/** Remove the node after a given node
	 * 
	 * @param aNode The node before the one to be removed
	 * @return The data from the removed node or null if there is no node to remove
	 * 
	 */

	/*
	public boolean remove(Object dataItem){ 				//___LIST INTERFACE METHOD___
		if (this.getSize() == 0){
			this.removeFirst();
			return true;
		}
		else if (this.getSize() != 0){
			Node current = head;
			while(current.getNext() != null && current.data != dataItem){
				current = current.getNext();
			}
			current.setNext(new Node(newItem,null));
			size--;
			return true;
		}
		else
			return false;
	}
	*/
	public Object removeAfter(Node aNode) {
		// add code here
		Node temp = aNode.next;
		if(temp != null){
			aNode.next = temp.next;
			size--;
			return temp.data;
		}
		else
			return null;
	}
	
	/** Remove the first node from the list
	 * 
	 * @return the returned node's data or null if the list is empty
	 * 
	 */
	//Ricker's removeFirst Method
	public Object rickerRemoveFirst(){
		Node temp = head;
		if(head != null)
			head = head.getNext();
		if(temp != null){
			size--;
			return temp.getData();
		}
		else{
			return null;
		}
	}
	
	
	public Object removeFirst() {
		// add code here
		Node temp = head;
		if(head != null)
			head = head.next;
		if(temp != null){
			size--;
			return temp.data;
		}
		else
			return null;
	}
	public void addLast (Object newItem){
		if(head == null)
			head = new Node(newItem, null);
		else{
			Node current = head;
			while(current.getNext() != null){
				current = current.getNext();
			}
			current.setNext(new Node(newItem,null));
			size++;
		}
	}

	/*
	public Object remove(Node aNode){		//Tuesday class remove method
		Node temp = aNode.next;
		if(temp != null){
			aNode.next = aNode.next.next;
			size--;
			return temp.data;
		}
		else
			return null;
	}
	*/
	public boolean isEmpty(){
		return head ==null;
	}
	public boolean remove(Object dataItem){
		if (isEmpty())
			return false;
		else{
			Node help = new Node(null);
			help.next = head;
			Node p = help;
			while(p.next != null){
				if(p.next.getData() == dataItem){
					Node next = p.getNext();
					p.next = next.getNext();
					return true;
				}
				else{
					p = p.getNext();
				}
			}
			return false;
		}
	}
	private boolean contains(Object dataItem, Node aNode){
		if(aNode.getData() == dataItem)
			return true;
		else if (aNode.getNext() == null)
			return false;
		else
			return contains(dataItem, aNode.getNext());
	}
	public boolean contains(Object dataItem){
		if(isEmpty() == true)
			return false;
		else
			return contains(dataItem,head);
	}

	public Object remove(){
		if (isEmpty()) {
			return null;
		}
		else{
			Object element = head.getData();
			head = head.getNext();
			return element;
		}
    }
	
	//================================TEXTBOOK METHODS -NOTES==================================================
	private Node getNode(int index){
		Node aNode = head;
		for(int i = 0; i < index && aNode != null;i++){
			aNode = aNode.next;
		}
		return aNode;
	}
	public Object get(int index){
		if (index < 0 || index >= size){
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node aNode = getNode(index);
		return aNode.data;
	}
	public Object set(int index, Object newValue){
		if (index < 0 || index >= size){
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node aNode = getNode(index);
		Object result = aNode.data;
		aNode.data = newValue;
		return result;
	}
	public void add(int index, Object item){
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if(index == 0){
			addFirst(item);
		}
		else{
			Node aNode = getNode(index-1);
			addAfter(aNode, item);
		}
	}
	public void add(Object item){						//___LIST INTERFACE METHOD___
		add(size,item);
	}	
	public String toString() {
	    Object obj;
	    String result = "[  ";

	    Node currentNode = head;

	    while (currentNode != null) {
	      obj = currentNode.data;
	      result = result + obj.toString() + "  ";
	      currentNode = currentNode.next;
	    }
	    result = result + "]";
	    return result;
	  }
	  
}
