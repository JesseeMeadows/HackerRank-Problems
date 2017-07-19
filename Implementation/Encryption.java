import java.io.*;
import java.util.*;
import java.lang.Math;
import java.lang.StringBuilder;

public class Encryption {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            int col, row;
            int sRoot = (int)Math.sqrt(s.length());
            int x = s.length() - (sRoot * sRoot);
            if (x == 0) {
                row = sRoot;
                col = sRoot;
            } else if (x > sRoot) {
                row = sRoot + 1;
                col = sRoot + 1;
            } else {
                row = sRoot;
                col = sRoot + 1;
            }
            
            StringBuilder cp = new StringBuilder();
            int count = 0;
        
            
                for (int i = 0; i < col; i++) {
                    for (int j = 0; j < row; j++) {
                       int index = (j * col) + i;
                       if (index < s.length()) {
                           cp.append(s.charAt(index));
                       }
                    }
                    if (i < col - 1) {
                        cp.append(' '); 
                    }
                }
        System.out.println(cp);
            
            
        
            
    }
}