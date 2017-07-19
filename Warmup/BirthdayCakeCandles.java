import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BirthdayCakeCandles {

    static int birthdayCakeCandles(int n, int[] ar) {
        // Complete this function
        if (n == 0) return 0;
        if (n == 1) return 1;
        int max = ar[0];
        int count = 1;
        int input;
        for (int i = 1; i < ar.length; i++) {
            input = ar[i];
            if (input < max) {
                continue;
            } else if (input > max) {
                max = input;
                count = 1;
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
