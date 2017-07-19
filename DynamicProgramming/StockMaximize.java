import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StockMaximize {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	Scanner in = new Scanner(System.in);
    	int T = in.nextInt();
    	for (int t = 0; t < T; t++) {
    		in.nextLine();
        	int N = in.nextInt();
        	in.nextLine();
        	int[] p = new int[N];
        	for (int n = 0; n < N; n++) {
        		p[n] = in.nextInt();
        	}
        	
        	int max = Integer.MIN_VALUE;
        	long total = 0L;
        	for (int i = N - 1; i >= 0; i--) {
        		if (p[i] < max) {
        			total = total + (max - p[i]);
        		}
        		if (p[i] > max) {
        			max = p[i];
        		}
        	}
        	System.out.println(total);
    	}
    	
    }
    
}