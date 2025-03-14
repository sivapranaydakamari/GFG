//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> subarr = new ArrayList<>();
        if(arr.length < 1){
            subarr.add(-1);
            return subarr;
        }
        int l = 0;
        int r = 0;
        int sum = 0;
        while(r < arr.length){
            sum += arr[r];
            while(sum > target && l <= r){
                sum -= arr[l];
                l++;
            }
            if(sum == target){
                subarr.add(l+1);
                subarr.add(r+1);
                return subarr;
            }
            r++;
        }
        
        subarr.add(-1);
        return subarr;
    }
}
