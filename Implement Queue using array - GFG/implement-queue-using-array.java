//{ Driver Code Starts
import java.util.Scanner;

class GfG
{
	public static void main(String args[])
	{
		 Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
		 {
			MyQueue obj = new MyQueue();
			int Q = sc.nextInt();
			while(Q>0)
			{
				int QueryType = 0;
				QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					
					obj.push(a);
					
				}else if(QueryType == 2)
				{
				System.out.print(obj.pop()+" ");
				}
				Q--;
			}
			System.out.println("");
			t--;
		 }
	}
}




// } Driver Code Ends




class MyQueue {

    int front, rear,c;
	int arr[] = new int[100005];
	int n = arr.length;

    MyQueue()
	{
		front=0;
		rear=0;
		c = 0;
	}
	
	//Function to push an element x in a queue.
	void push(int x)
	{
	    // Your code here
	    
	    if(c == n )
	    {
	        return;
	    }
	    arr[rear%n] = x;
	    rear++;
	    c++;
	    
	} 

    //Function to pop an element from queue and return that element.
	int pop()
	{
		// Your code here
		if(c==0)
		{
		    return -1;
		}
		int t = arr[front%n];
		front++;
		c--;
		return t;
	} 
}




