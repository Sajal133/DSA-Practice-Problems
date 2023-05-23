//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String s) {
	// Your code here
	int n=0,p=0;
        double x=0;
        s=s.trim();
        if(s.length()==0) return 0;
        if(s.charAt(0)=='-') n=1;
        else if(s.charAt(0)=='+') p=1;
        for (int i=0;i<s.length();i++){
            if((n==1||p==1)&&i==0) continue;
            if(s.charAt(i)<'0'||s.charAt(i)>'9') return -1;
            else x=x*10+s.charAt(i)-'0';
        }
        if(n==1) x=(-1)*x;
        return (int)x;
    }
}
