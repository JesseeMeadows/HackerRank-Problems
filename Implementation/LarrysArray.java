import java.io.*;
import java.util.*;

public class LarrysArray {
    
    public static void rot1(int[] a, int i) {
        if (i == a.length -1) {
            int temp = a[i];
            a[i] = a[i-2];
            a[i-2] = a[i-1];
            a[i-1] = temp;
            
        } else {
            int temp = a[i+1];
            a[i+1] = a[i-1];
            a[i-1] = a[i];
            a[i] = temp;
        }
            
    }
    
    public static void rot2(int[] a, int i) {
        if (i == a.length-1) {
            int temp = a[i];
            a[i] = a[i-1];
            a[i-1] = a[i-2];
            a[i-2] = temp;
            
        } else {
            int temp = a[i-1];
            a[i-1] = a[i+1];
            a[i+1] = a[i];
            a[i] = temp;
        }
            
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        
        for (int i_t = 0; i_t < t; i_t++) {
            int n = in.nextInt();
            in.nextLine();
            int[] a = new int[n];
            
            // read in array
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            
            int i = 0;
            while (i < n-2) {
                if (a[i] != i+1) {
                    int j = i+1;
                    while (a[j] != i+1) {
                        j++;
                    }
                    while (j > i) {
                        rot1(a, j);
                        j--;
                    }
                } 
                i++;
            }
            if (a[i-1] < a[i] && a[i] < a[i+1]){
                System.out.println("YES");
            } else if (a[i+1] < a[i-1] && a[i-1] < a[i]) {
                System.out.println("YES");
            } else if (a[i] < a[i+1] && a[i+1] < a[i-1]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }           
        }
        
        
    }
}