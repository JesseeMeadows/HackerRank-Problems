import java.io.*;
import java.util.*;

public class NonDivisibleSubset {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        
        int[] setS = new int[n];
        int[] r = new int[k];
        
        // Read in set S
        for (int i = 0; i < n; i++) {
            setS[i] = in.nextInt();
            r[setS[i] % k]++;
        }
        
        // All integers divisible by 1 -> S' is empty
        if (n == 1) System.out.println(1);
        else if (k == 1) {
            System.out.println(1);
        } else if (k == 2) {                
            if (r[1] > 0 && r[0] > 0) {
                System.out.println(2);
            } else {
                System.out.println(1);
            }
        } else {
            int sPrime = 0;
            for (int i = 1; 2*i < k ; i++) {
                if (r[i] > r[k-i]) {
                    sPrime += r[i];
                } else {
                    sPrime += r[k-i];
                }
            } 
            if (k % 2 == 0 && r[k/2] > 0) sPrime++;
            if (sPrime > 0 && r[0] > 0) sPrime++;
            System.out.println(sPrime);
        }
        
    }
}