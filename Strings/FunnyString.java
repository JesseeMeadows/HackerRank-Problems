import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FunnyString {

    static String funnyString(String s){
        int rIter = s.length() - 1;
        int sIter= 1;
        while(rIter > 0) {
            if (abs(s.charAt(sIter) - s.charAt(sIter - 1)) != abs(s.charAt(rIter - 1) - s.charAt(rIter)) ){
                return "Not Funny";
            } else {
                rIter--;
                sIter++;
            }
        }
        return "Funny";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = funnyString(s);
            System.out.println(result);
        }
    }
    
    public static int abs(int x) {
        if (x < 0) return (x * -1);
        else       return x;
    }
}
