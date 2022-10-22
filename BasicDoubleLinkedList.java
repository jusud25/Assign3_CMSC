import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T>implements Iterable<T>{
			protected Node head;
			protected Node tail;
			protected int size;

			/**
			 * Constructor takes no parameter variable but it initializes all the
			 * attributes.
			 */
			public BasicDoubleLinkedList() {
				head = null;
				tail = null;
				size = 0;
			}

			/**
			 * @return return the size of the list without traversing it
			 */
			public int getSize() {
				var starter=head;
				
			if(starter!=null) {
				size++;
			  starter=starter.next;
			}
			return size;
			
			}

			/**
			 * @param To add an element to the end of the 
			 * list and update the size of the list
			 */
			public void addToEnd(T data) {
				while(head== null) {
					head = new Node(data);
					tail = head;
					return;
				}
				tail.next = new Node(data);
				tail.next.prev = tail;

				tail = tail.next;
			
				
			}
			/**
			 * @param data To add element to the front of the list and update the size of
			 *             the list
			 */
			public void addToFront(T data) {
				while(head == null) {
					var check = new Node(data);
					check.next = head;
					head.prev = check;
					head = check;


					return;
				}
				var datas=new Node(data);
			     head.prev=datas;
			     datas.next=head;
			     head=datas;
				return;
			}

			/**
			 * @return Returns but does not remove the first element from the list
			 * @return Also if there are no elements, the method returns null.
			 */
			public T getFirst() {
				if(head==null) {
					return null;
				}
				return head.data;
			}

			/**
			 * 
			 * @return It returns but does not remove the 
			 * last element from the list if
			 * there is no element, the method returns null
			 */
			public T getLast() {
				var datas=head;
				while(datas.next!=null) 
					datas=datas.next;
				return datas.data;
			}

			/**
			 * @return To return the objects of the BasicDoubleLinkedListIterator
			 */
			public ListIterator<T> iterator() {
				return new BasicDoubleLinkedListIterator(head);

			}
			/**
			 * @param targetData To remove first element from the list
			 * @param comparator To compare element for deletion
			 * @return
			 */

			public Node remove(T targetData, Comparator<T> comparator) {
				var status = head;
				if (head == null) {
			    return status;
				}
				while (status != null) {
					if (comparator.compare(status.data, targetData) == 0) {
						if (status.prev != null) {
							status.prev.next = status.next;
						}
						if (status.next != null) {
							status.next.prev = status.prev;
						}
						if (!(status == head)) {
							head = head.next;
						}
						if (status == tail) {
							tail = status.prev;

						}
						return status;
					}
					status = status.next;
				}
				return status;

			}

			/**
			 * @return to return first element in the list
			 */
			public T retrieveFirstElement() {
				T retrieveElement = getFirst();
				head = head.next;
				if (head == null) {
					return null;
				}
				if (head == null) {
					tail = null;
				} 
				else {
				head.prev= null;
				}
				return retrieveElement;	
			}

			/**
			 * @return to remove and return the last element 
			 * from the list
			 * return null if there is no element in the list
			 */
			public T retrieveLastElement() {
				T last = getLast();
				tail = tail.prev;
				if (tail == null) {
					head = null;
				} else {
					tail.next = null;
				}
				if (!(tail != null)) {
					return null;
				}
				return last;
			}

			/**
			 * An ArrayList containing the elements
			 * @return To return the list of items
			 */
			public ArrayList<T> toArrayList() {
				ArrayList<T> newList = new ArrayList<>();
				var node = head;
				while (node != null) {
					newList.add(node.data);
					node = node.next;
				}
				return newList;
			}
			 public String toString() {
			       Node current = head;
			        String data = "";

			        while (current != null) {
			            data += current.next + "->";
			            current = current.next;
			        }

			        return data;
			    }

			/**
			 * The inner Node class used to link the data
			 */
			protected class Node {
				T data;
				Node next;
				Node prev;

				public Node(T dataNode) {
					data = dataNode;
					prev = null;
					next = null;
					
			

				}
			}

			/**
			 * @class This inner class will implement ListIterator 
			 * methods inherited from the java API
			 *
			 */
			class BasicDoubleLinkedListIterator implements ListIterator<T> {
				Node head;
				Node cur;

				public BasicDoubleLinkedListIterator(Node head) {
					this.head = head;
					cur = null;
				}

				/**
				 * check for next element after reading current element
				 * 
				 * @return return true if there is next element to read otherwise return false
				 */
				@Override
				public boolean hasNext() {
					if(cur==null&&head!=null) {
						return true;
					}
					return(cur.next!= null);
					
					
					}
				
				

				@Override
				public T next() {
					if (!hasNext()) {

						throw new NoSuchElementException("There's no data to read from from");
					}
					else if (!(cur != null)) {
						cur = head;
					} else {
						cur = cur.next;
					}
					return cur.data;
				}

				/**
				 * To check for previous element
				 * 
				 * @return return true if there is a previous element, false otherwise
				 */
				@Override
				public boolean hasPrevious() {
				return(!( cur == null));

				}

				/**
				 * @return return previous element in the list and moves the cursor position
				 *         backwards
				 */
				@Override
				public T previous() {

					if (!hasPrevious()) {
						throw new NoSuchElementException("No previous element");
					}
					T ele = cur.data;
					cur = cur.prev;
					return ele;

				}

				/**
				 * @return This is not supported
				 */
				@Override
				public int nextIndex() throws UnsupportedOperationException {
					throw new UnsupportedOperationException("It is not supported");

				}

				/**
				 * @return This is not supported
				 */
				@Override
				public int previousIndex() throws UnsupportedOperationException {
					throw new UnsupportedOperationException("It is not supported");
				}

				/**
				 * @return It is unsupported
				 */
				@Override
				public void remove() throws UnsupportedOperationException {
					throw new UnsupportedOperationException("It is not supported");
				}

				/**
				 * @return It is unsupported
				 */
				@Override
				public void set(T e) throws UnsupportedOperationException {
					throw new UnsupportedOperationException("It is not supported");

				}

				@Override
				public void add(T e) throws UnsupportedOperationException {
					throw new UnsupportedOperationException("It is not supported");
				}
				
					
				}
			}
