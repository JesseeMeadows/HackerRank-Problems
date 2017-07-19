import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SaveThePrisoner {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int prisoners = in.nextInt();
            int start = in.nextInt();
            int sweets = in.nextInt() % prisoners;
            
            int poisonedPrisoner = start + sweets; 
            if (poisonedPrisoner > prisoners) {
                poisonedPrisoner = poisonedPrisoner % prisoners;
            }
            if (poisonedPrisoner == 1) {
                System.out.println(prisoners);
            } else {
                System.out.println(poisonedPrisoner - 1);  
            }
  
        }      
        
        
    }
}
