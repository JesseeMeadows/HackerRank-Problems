import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Kangaroo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        
        // v1 will never catch v2 if v2 is faster since it's starts ahead of v1
        if (v2 > v1) {
            System.out.println("NO");
        } else if ( (v2 - v1) != 0 && (x1 - x2) % (v2 - v1) == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
      
            
    }
    
}

