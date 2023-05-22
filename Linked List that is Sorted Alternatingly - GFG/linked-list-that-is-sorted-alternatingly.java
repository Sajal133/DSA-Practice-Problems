//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends


/*
Structure of node class is:

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/
class Solution {
    
   public Node sort(Node head){
        //your code here, return the head of the sorted list
        if (head == null || head.next == null) {
            return head;
        }
        
        Node mid = getMiddle(head);
        Node midNext = mid.next;
        mid.next = null;
        
        Node left = sort(head);
        Node right = sort(midNext);
        
        return merge(left, right);
    }
    
    private Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private Node merge(Node left, Node right) {
        Node dummy = new Node(0);
        Node current = dummy;
        
        while (left != null && right != null) {
            if (left.data < right.data) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            
            current = current.next;
        }
        
        if (left != null) {
            current.next = left;
        }
        
        if (right != null) {
            current.next = right;
        }
        
        return dummy.next;
   }


}