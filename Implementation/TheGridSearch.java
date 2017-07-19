import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TheGridSearch {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String[] G = new String[R];
            for(int i=0; i < R; i++){
                G[i] = in.next();
            }
            
            // Pattern rows, cols
            int r = in.nextInt();
            int c = in.nextInt();
            String[] P = new String[r];           
            
            //read in pattern string
            for(int i=0; i < r; i++){
                P[i] = in.next();
            }
            
            boolean found = false;
            
            for (int row = 0; row <= R - r; row++) {
                int pRow = 0;
                int indexOf = G[row + pRow].indexOf(P[pRow]);
                while ( indexOf != -1) {
                    do {
                        pRow++;
                        if (pRow == r) {
                            found = true; 
                            break;
                        }
                        String cmp;
                    } while (G[row + pRow].substring(indexOf, indexOf + c).compareTo(P[pRow]) == 0);
                    pRow = 0;
                    if ( (C-1) - (indexOf) >= c) {
                        indexOf = G[row + pRow].indexOf(P[pRow], indexOf + 1);
                    } else {
                        break;
                    }
                }
            }
            System.out.println(found ? "YES" : "NO");
  
        }
    }
}
