import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PlusMinus {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        double pos = 0;
        double neg = 0;
        double zero = 0;
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            if (arr[arr_i] > 0) {
                pos += 1;
            }
            else if (arr[arr_i] == 0) {
                zero += 1;
            }
            else {
                neg += 1;
            }            
        }
        BigDecimal positive = new BigDecimal(pos/n, new MathContext(6));
        BigDecimal negative = new BigDecimal(neg/n, new MathContext(6));
        BigDecimal zeroPercent = new BigDecimal(zero/n, new MathContext(6));
        
        System.out.println(positive);
        System.out.println(negative);
        System.out.println(zeroPercent);
    }
}