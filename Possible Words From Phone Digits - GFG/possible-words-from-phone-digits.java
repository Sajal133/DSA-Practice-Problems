//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    // Function to find list of all words possible by pressing given numbers.
    static ArrayList<String> possibleWords(int a[], int N) {
        // Create a HashMap to map each digit to its corresponding characters on the keypad.
        HashMap<Integer, String> keyboard = new HashMap<Integer, String>();
        initKeyboard(keyboard);

        // Create a list to store the final result.
        ArrayList<String> result = new ArrayList<String>();

        // Call the recursive function to generate all possible words.
        compile(a, 0, "", keyboard, result);

        // Return the result.
        return result;
    }

    // Recursive function to generate all possible words.
    private static void compile(int[] digits, int index, String prefix, HashMap<Integer, String> keyboard, List<String> result) {
        // Base case: if the prefix length equals the digits length, add it to the result.
        if (index == digits.length) {
            result.add(prefix);
            return;
        }

        // Get the characters corresponding to the current digit.
        String chars = keyboard.get(digits[index]);

        // For each character, append it to the prefix and recursively call the function for the next digit.
        for (int i = 0; i < chars.length(); i++) {
            compile(digits, index + 1, prefix + chars.charAt(i), keyboard, result);
        }
    }

    // Function to initialize the keyboard mapping.
    private static void initKeyboard(HashMap<Integer, String> keyboard) {
        keyboard.put(2, "abc");
        keyboard.put(3, "def");
        keyboard.put(4, "ghi");
        keyboard.put(5, "jkl");
        keyboard.put(6, "mno");
        keyboard.put(7, "pqrs");
        keyboard.put(8, "tuv");
        keyboard.put(9, "wxyz");
    }
}
