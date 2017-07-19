import java.io.*;
import java.util.*;

public class TheTimeInWords {

    public static String toE(int i) {
        switch(i) {
            case 1: return "one";

            case 2: return "two";

            case 3: return "three";

            case 4: return "four";

            case 5: return "five";
                    
            case 6: return "six";
                    
            case 7: return "seven";
                    
            case 8: return "eight";
                    
            case 9: return "nine";
                    
            case 10: return "ten";
                    
            case 11: return "eleven";
                    
            case 12: return "twelve";
                    
            case 13: return "thirteen";
                    
            case 14: return "fourteen";
                    
            case 15: return "quarter";
                    
            case 16: return "sixteen";
                    
            case 17: return "seventeen";
                    
            case 18: return "fifteen";
                    
            case 19: return "nineteen";
                    
            case 20: return "twenty";
         
            default: return "invalid hour";
                    
        }
    }
    public static void pt(String s) {
        System.out.println(s);
    }
    public static void timeToEng(int hour, int minute) {
        String h, p;
        String mn = " minutes ";
        int m;
        if (minute > 30) {
            h = toE(hour + 1);
            m = 60 - minute;
            p = "to ";
        } else {
            h = toE(hour);
            m = minute;
            p = "past ";
           
        }
        
        if (m == 0) {
            System.out.println(h + " o' clock");
        }
        else if (m == 1) {
            pt("one minute " + p + h);
        }
        else if (m < 15) {
            pt(toE(m) + mn + p + h);
        }
        else if (m == 15) {
            pt("quarter " + p + h);
        }
        else if (m < 20) {
            pt(toE(m) + mn + p + h);
        }
        else if (m == 20) {
            pt(toE(m) + mn + p + h);
        }
        else if (m < 30) {
            pt(toE(20) + " " + toE(m-20) + mn + p + h );
        }
        else if (m == 30) {
            pt("half past " + h);
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int h = Integer.parseInt(in.nextLine());
        int m = Integer.parseInt(in.nextLine());
        timeToEng(h, m);
        
    }
}
