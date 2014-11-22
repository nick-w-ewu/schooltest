//Nicholas Witmer
//CSCD 300-01
//11/20/2014
//Homework 5/6
//This class has been adapted from CSCD 300 LinkedStack demo code

public class MyStack<E>
{
	public class Node<T> 
	{
		private T element;
		private Node<T> next;
		/** Creates a node with null references to its element and next node. */
		public Node()
		{
			this(null, null);
		}
		/** Creates a node with the given element and next node. */
		public Node(T e, Node<T> n)
		{
			element = e;
			next = n;
		}
	}

	protected Node<E> top;	// reference to the head node
	protected int size;		// number of elements in the stack

	/** Creates an empty stack. */
	public MyStack()
	{
		top = null;
		size = 0;
	}
	public int size()
	{ 
		return size;
	}

	public boolean isEmpty()
	{
		if (top == null) 
			return true;
		return false;
	}
	public void push(E elem)
	{
		Node<E> v = new Node<E>(elem, top);	// create and link-in a new node, new node's next gets top; 
		top = v;                            // equivalent to addFirst operation on linked list.
		size++;
	}
	public E peek() throws EmptyStackException
	{
		if (isEmpty()) 
			throw new EmptyStackException("Stack is empty.");
		return top.element;
	}
	public E pop() throws EmptyStackException
	{
		if (isEmpty()) 
			throw new EmptyStackException("Stack is empty.");

		E temp = top.element;
		top = top.next;	// equivalent to removeFirst operation on linked list.
		size--;
		return temp;
	}
}
