import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MiniMaxSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max, min;
        Long total = 0L;
        
        int input = in.nextInt();
        max = input;
        min = input;
        total = total + input;
        
        for(int i = 0; i < 4; i++){
            input = in.nextInt();
            total += input;
            if (input > max)    max = input;
            if (input < min)    min = input;
        }
        
        System.out.println((total - max) + " " + (total - min) );
    }
}
