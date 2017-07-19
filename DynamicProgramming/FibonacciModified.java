import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FibonacciModified {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        BigInteger t1 = new BigInteger(Integer.toString(in.nextInt()));
        BigInteger t2 = new BigInteger(Integer.toString(in.nextInt()));
        int n = in.nextInt();
        
        BigInteger[] seq = new BigInteger[n];
        seq[0] = t1;
        seq[1] = t2;
        
        for (int i = 2; i < n; i++) {
            seq[i] = (seq[i - 2]).add((seq[i - 1]).multiply(seq[i - 1]));
        }
        System.out.println(seq[n-1]);
    }
}
