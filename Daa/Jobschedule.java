//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class GfG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // testcases
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");

            // size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");

            // adding id, deadline, profit
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Job(Integer.parseInt(inputLine[k++]),
                                 Integer.parseInt(inputLine[k++]),
                                 Integer.parseInt(inputLine[k++]));
            }

            Solution ob = new Solution();

            // function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println(res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
*/

class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // Your code here
        
        // 1. sort based on descending profit
        Arrays.sort(arr, (a,b) -> b.profit - a.profit);
        
        // 2. find the max deadline:
        int maxDeadLine = 0;
        
        for(Job j : arr){
            maxDeadLine= Math.max(maxDeadLine, j.deadline);
        }
        
        // 3. create an array of slot to assign jobs as per deadline
        int[] deadlines = new int[maxDeadLine+1] ;
        
        int jobs = 0;
        int maxProf = 0;
        
        for(int i = 0; i< n; i++){
            
            int currDead = arr[i].deadline;
          
            int temp = currDead;
            
            // find a free slot
            while(deadlines[temp] != 0){
                temp--;
            }
            
            // if slot is graeter than 0th, we can use it:
            if( temp > 0){ 
                deadlines[temp] = arr[i].id;
                maxProf += arr[i].profit;
                jobs++;
            }

        }
        
        return new int []{jobs, maxProf};
    }
}
