//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String x = read.readLine();
            String y = read.readLine();
            Solution ob = new Solution();
            String result = ob.findSum(x, y);

            System.out.println(result);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String findSum(String s1, String s2) {
        
         s1 = s1.replaceFirst("^0+(?!$)", "");
         s2 = s2.replaceFirst("^0+(?!$)", "");
        
        if (s1.length() < s2.length()) { // allows keeping s1 string as larger
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        
        StringBuilder str1 = new StringBuilder(s1).reverse();
        StringBuilder str2 = new StringBuilder(s2).reverse();
        
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i;
        for(i = 0; i < str2.length(); i++){
            int sum = (str1.charAt(i) - '0') + (str2.charAt(i) - '0') + carry;
            result.append(sum % 10);
            carry = sum/10;
        }
        
        for(; i < str1.length(); i++){
            int sum = (str1.charAt(i) - '0') + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        
        if(carry != 0){
            result.append(carry);
        }
        return result.reverse().toString();
    }
}