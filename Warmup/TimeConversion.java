import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TimeConversion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        int first2Digits = Integer.parseInt(time.substring(0,2));
        if (time.contains("AM") ) {
            if (first2Digits != 12) {
                System.out.println(time.substring(0,8));
            } else {
                System.out.println("00" + time.substring(2,8));
            }
        } else {
            if (first2Digits != 12) {
                System.out.println((first2Digits + 12) + time.substring(2,8));
            } else {
                System.out.println(time.substring(0,8));
            }
        }
    }
}

