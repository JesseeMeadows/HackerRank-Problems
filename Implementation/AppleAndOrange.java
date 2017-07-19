import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AppleAndOrange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();       // house start
        int t = in.nextInt();       // house finish
        int a = in.nextInt();  // apple  coordinate - x
        int b = in.nextInt();  // orange coordinate - x
        int m = in.nextInt();  // apple quanity
        int n = in.nextInt();  // orange quanity
        int[] apple = new int[m];
        
        int houseApples = 0;
        int houseOranges = 0;
        
        for(int apple_i=0; apple_i < m; apple_i++){
            int input = in.nextInt();
            if (a+input >= s && a+input <= t) houseApples++;
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            int input = in.nextInt();
            if (b+input <= t && b+input >= s) houseOranges++;
        }
        System.out.println(houseApples);
        System.out.println(houseOranges);
    }
}
