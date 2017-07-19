import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CompareTheTriplets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        
        int aScore = 0;
        int bScore = 0;
        if (a0 != b0) {
            if (a0 > b0) {
                aScore++;
            } else {
                bScore++;
            }
        }
        
        if (a1 != b1) {
            if (a1 > b1) {
                aScore++;
            } else {
                bScore++;
            }
        }
        
        if (a2 != b2) {
            if (a2 > b2) {
                aScore++;
            } else {
                bScore++;
            }
        }
        System.out.println(aScore + " " + bScore);
    }
}
