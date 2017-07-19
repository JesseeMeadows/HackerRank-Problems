import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TheMaximumSubarray {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            in.nextLine();
            int N = in.nextInt();
            int[] a = new int[N];
            in.nextLine();
            
            a[0] = in.nextInt();
            int nonCont = 0;
            int count = 0;
            boolean positive = a[0] >= 0;
            int max = a[0];
            if (positive) nonCont += a[0];
            
            // read into array, combining contiguous substrings of positive and negative numbers
            for (int n = 1; n < N; n++) {
                int x = in.nextInt();
                if (x > max) max = x;
                if (x >= 0) nonCont += x;
                if (positive) {
                    if (x >= 0) {
                        a[count] += x;
                        if (max > a[count]) max = a[count];
                    } 
                    else {
                    	positive = false;
                    	// Combine Contiguous positive subarray with the previous positive subarray
                    	// when both are larger than the contiguous negative subarray that sits between them
                    	if (count - 2 >= 0 && a[count] >= abs(a[count - 1]) && a[count-2] >= abs(a[count - 1])) {
                    		a[count - 2] += a[count] + a[count-1];
                    		a[count] = 0;
                    		a[count - 1] = x;
                            if(a[count - 2] > max) max = a[count - 2];
                    		count--;
                    	} else {
                    		a[++count] += x; 
                    	}
                    }
                } else {
                    if (x < 0)  a[count] += x;
                    else {
                        a[++count] += x;
                        positive = true;
                    }
                }
            }
            
            if (max < 0) {
                System.out.println(max + " " + max);
                continue;
            }

            // each
            int i = (a[0] < 0 ? 1 : 0);
            if (a[i] > max) max = a[i];
            while(i + 2 < count) {
            	int wOffset = i+2;
            	int between = abs(a[i+1]);
            	while (/*a[i] >= between && */  wOffset < count) {
            		a[i] += a[wOffset] + a[wOffset-1];
            		if (a[i] > max) max = a[i];
            		
            		wOffset += 2;
            	/*	if (a[wOffset] >= between) {
            			a[wOffset] += a[i] - between;
            			if (a[wOffset] > max) max = a[wOffset];
            			i = wOffset; 
            			break;
            		} else {
            			between = between - a[wOffset] + a[wOffset-1];
            			wOffset += 2;
            		}*/
            	}
            	i += 2;
            }
            
            System.out.println(max + " " + nonCont); 
        }
    }
    
    public static int abs(int val) {
        if (val < 0) return -1 * val;
        else return val;
    }
}
