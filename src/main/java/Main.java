import java.util.Scanner;

public class Main {
	public static Scanner reader = new Scanner (System.in);
	public static void main(String[] args) {
		
		int [] arr = {1,2,3,4,5,6};
			
		System.out.println(buildListFromArr(arr));
		System.out.println("****");
	
		Node<Integer> list = buildListFromArr(arr);
		/*
		printList(list);
		System.out.println("****");
		printOppositeListRecursive(list);
		System.out.println("****");
		//buildList();
		System.out.println("****");
		printListEven(list);
		System.out.println("****");
		System.out.println(findNumber(list, 7));
		System.out.println("****");
		System.out.println(deleteNum(list, 0));
	*/
		System.out.println(deleteIndex(list, 6));
	}

	public static Node<Integer> buildListFromArr(int[] arr) {
		Node<Integer> list = new Node<>(arr[0]);
		Node<Integer> current = list;
		for(int i=1; i<arr.length; i++) {
		    Node<Integer> newNode = new Node<>(arr[i]);
			current.setNext(newNode);
			current = newNode;
		}
		return list;
	}
	
	public static void printList(Node<Integer> list) {
		Node<Integer> current = list;
		while (current != null) {
			System.out.println(current.getValue());
			current = current.getNext();
		}
	}
	
	public static void printListRecursive(Node<Integer> list) {
		if (list == null) {
			return;
		}
		System.out.println(list.getValue());
		printListRecursive(list.getNext());
	}
	
	public static void printOppositeListRecursive(Node<Integer> list) {
		if (list == null) {
			return;
		}
		printOppositeListRecursive(list.getNext());
		System.out.println(list.getValue());
	}
	
	public static void buildList() {
		Node<Integer> list = new Node<Integer>(null);
		Node<Integer> current = list;
		System.out.println("Enter numbers possitive or -1 to end");
		int num = reader.nextInt();
		while(num != -1) {
			Node<Integer> newNode = new Node<Integer>(num);
			current.setNext(newNode);
			current = newNode;
			System.out.println("Enter number or -1 to end:");
			num = reader.nextInt();
		}
		list = list.getNext();
		System.out.println(list);
	}
	
	public static void printListEven(Node<Integer> list) {
		while(list != null) {
			if ((list.getValue())%2==0) {
				System.out.println(list.getValue());
			}
			list = list.getNext();
		}
	}
	
	public static boolean findNumber(Node<Integer> list, int target) {
		Node<Integer> current = list;
		while (current != null) {
			if (current.getValue() == target) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}
	
	public static Node<Integer> deleteNum(Node<Integer> list, int x) {
		Node<Integer> head = list;
		boolean flag = false;
		if (list.getValue()==x) {
			return list.getNext();
		}
		while(list.getNext() != null) {
			if(list.getNext().getValue() == x && flag == false)
			{
				list.setNext(list.getNext().getNext());
				flag = true;
			}
			list = list.getNext();
		}
		return head;
	}
	
	public static Node<Integer> deleteIndex(Node<Integer> head, int index){
		head = new Node<>(null, head);
		Node<Integer> current = head;
		int nodeCount=1;

		while (current != null) {
			if(nodeCount==index){
				current.setNext(current.getNext().getNext());
				return head.getNext();
			}
			nodeCount++;
			current = current.getNext();
		}
		return head.getNext();
	}
	
	public static boolean ifL1InL2TailRecursive(Node<Integer> head1, Node<Integer> head2,Node<Integer> current) {
		if (head1 == null) {
			return true;  
		}
		if (current == null) {
			return false;  
		}

		if (head1.getValue() == current.getValue()) {
			return ifL1InL2TailRecursive(head1.getNext(),head2,head2);
		} 
		else {
			return ifL1InL2TailRecursive(head1, head2,current.getNext());
		}
	}
	
	

}
