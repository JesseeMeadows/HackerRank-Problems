import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Candies {
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        
        if (n == 1) {
            System.out.println("1");
            return;
        } 
        
        int[] a = new int[n]; 
        int[] greaterLeft = new int[n];
        greaterLeft[0] = 0;
        a[0] = in.nextInt();
        
        int ascendingCnt = 0;
        for (int i = 1; i < n; i++) {
            in.nextLine();
            a[i] = in.nextInt();
            if (a[i] > a[i-1])  ascendingCnt++;
            else                ascendingCnt = 0; 
            greaterLeft[i] = ascendingCnt;
        }
        
        int descendingCnt = 0;
        long candies = 1 + greaterLeft[n-1];
        
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > a[i+1]) {
                descendingCnt++;
            } else {
                descendingCnt = 0;
            }
            candies += 1 + Math.max(descendingCnt, greaterLeft[i]);
        }
        System.out.println(candies);
        
        
    }
}
