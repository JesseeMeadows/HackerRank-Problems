import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/* 
 * S(4) = |A3 - A2| + |A2 - A1| + |A1 - A0|
 * S(3) = |A2 - A1| + |A1 - A0|
 * 
 * S(4) = |A3 - A2| + S(3)
 * 
 * We want to maximize S(k) and since our results are calculated via Absolute Value's of index's with addition,
 * we need to keep track of both the maximum and minimum S(K) when A[K] is A[K] and A[K] is 1
 * */
public class SherlockAndCost {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            in.nextLine();
            int N = in.nextInt();
            in.nextLine();
            if (N <= 1) {
                System.out.println("0");
                continue;
            }
            
            int[] a = new int[N];
            for (int n = 0; n < N; n++) {
                a[n] = in.nextInt();
            }
            System.out.println(findS(a));
        }
    }
    
    public static int findS(int[] a) {
    	int[][] cache = new int[a.length][2];
    	
    	return Math.max (
    			findS(cache, a, a[1], 2) + a[1] - 1,
    			findS(cache, a,    1, 2) + abs(1 - a[0])
    			);
    }
    
    public static int findS(int[][] cache, int[] a, int lastValue, int index) {
    	
    	if (index >= a.length - 1)  {
    		if (lastValue != 1) return abs(1 - lastValue);
    		else 				return a[a.length - 1] - lastValue; 
    	}
    	
    	if (lastValue == 1) {
    		if (cache[index][1] != 0) return cache[index][1];
    	} else {
    		if (cache[index][0] != 0) return cache[index][0];
    	}
    	
    	return cache[index][(lastValue == 1 ? 1 : 0)] = Math.max( 
    			findS(cache, a, a[index], index + 1) + abs(a[index] - lastValue),
    			findS(cache, a, 		1, index + 1) + abs(1 - lastValue)
    	);
    }
    
    public static int abs(int a) {
        if (a < 0) return a * -1;
        else       return a;
    }
}
