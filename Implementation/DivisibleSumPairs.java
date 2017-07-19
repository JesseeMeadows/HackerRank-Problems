import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DivisibleSumPairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = 0;
        }
        int totalPairs = 0;
        for(int i = 0; i < n; i++){
            int remainder = in.nextInt() % k;            
            totalPairs += a[(k - remainder) % k];
            a[remainder]++;
        }
        System.out.println(totalPairs);
    }
}
