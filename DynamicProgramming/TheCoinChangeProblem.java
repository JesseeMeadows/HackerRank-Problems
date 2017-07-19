import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TheCoinChangeProblem {

    static long getWays(int n, long[] c){
        Arrays.sort(c);
        long[] ways = new long[n + 1];
        ways[0] = 1L;   // base case

	    for (int i = 0; i < c.length && Math.toIntExact(c[i]) <= n; i++) {
		  int coin = Math.toIntExact(c[i]);
		  for (int value = coin; value < ways.length; value++) {
			 ways[value] += ways[value - coin];
		  }
	    }
        
        // Complete this function
        return ways[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        
        System.out.println(ways);
    }
}
