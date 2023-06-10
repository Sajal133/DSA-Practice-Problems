//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    void pushZerosToEnd(int[] arr, int n) {
        // code here
        int c = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0){
                moveIt(arr, i, c);
                break;
            }
        }
    }
    public static void moveIt(int[] nums, int i, int c){
        c++;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == 0) {
                moveIt(nums, j, c);
                return;
            }
            nums[j - c] = nums[j];
        }
        for (int k = 1; k < c + 1; k++) {
            nums[nums.length - k] = 0;
        }
    }
}