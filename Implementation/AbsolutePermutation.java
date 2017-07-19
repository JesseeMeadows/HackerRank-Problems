import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.StringBuilder;

public class AbsolutePermutation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            
            if (k == 0) {
                for (int i = 1; i < n+1; i++) {
                    System.out.print(i);
                    if (i != n) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            } 
            else {
                if (n % (2 * k) == 0) {
                    StringBuilder s = new StringBuilder();
                    int chCount = 1;
                    boolean pos = true;
                    int posCounter = 0;
                    while (chCount < n + 1) {                     
                        if (pos) {
                            s.append((chCount + k) + " ");
                            chCount++;
                            posCounter++;
                            if (posCounter == k) {
                                pos = false;
                                posCounter = 0;
                            }
                        } else {
                            s.append((chCount - k) + " ");
                            chCount++;
                            posCounter++;
                            if (posCounter == k) {
                                pos = true;
                                posCounter = 0;
                            }
                        }
                    }
                    s.trimToSize();
                    System.out.println(s.toString());
                } else {
                    System.out.println(-1);
                }
            }
            
            
        }
    }
}
