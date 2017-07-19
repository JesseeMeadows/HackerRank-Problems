import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class ExtraLongFactorials {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        if (a == 1) {
            System.out.println(1);
        } else if (a == 2) {
            System.out.println(2);
        } else {
            BigInteger[] factorials = new BigInteger[a + 1];
            factorials[1] = new BigInteger("1");
            factorials[2] = new BigInteger("2");
            for (int i = 3; i <= a; i++) {
                factorials[i] = (factorials[i-1]).multiply(new BigInteger(Integer.toString(i)));
            }
            System.out.println(factorials[a]);
        }
        
        
    }
}