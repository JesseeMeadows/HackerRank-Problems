import java.io.*;
import java.util.*;

public class QuicksortInPlace {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in); 
        int n = in.nextInt();
        in.nextLine();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        qSort(a, 0, a.length - 1);
        
        
    }
    
    public static void qSort(int[] a, int lo, int hi) {
        if (hi - lo > 0) {
            int p = partition(a, lo, hi);
            for (int j = 0; j < a.length; j++) {
              System.out.print(a[j] + " ");
            }
            System.out.println();
            qSort(a, lo, p - 1);
            qSort(a, p + 1, hi);
        }  
    }
    
    public static int partition(int[] a, int lo, int hi) {        
        if (hi <= lo) return lo;
       
        int i = lo;
        while (a[i] < a[hi]) {
            if (i == hi) return hi;
            i++;
        }
        
        int gt = i;
        while (i < hi) {
            if (a[i] <= a[hi]) {
                swap(a, i, gt++);
            }
            i++;
        }
        swap(a, gt, hi);
        return gt;
    }
    
    public static void swap(int[] a, int indexA, int indexB) {
        int temp = a[indexA];
        a[indexA] = a[indexB];
        a[indexB] = temp;
    }
}