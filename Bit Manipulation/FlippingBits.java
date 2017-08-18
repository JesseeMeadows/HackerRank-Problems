import java.util.Scanner;

/*	Problem: "Flipping Bits"
 * 		url: https://www.hackerrank.com/challenges/flipping-bits/problem
 * 
 */
public class FlippingBits {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        for (int t = 0; t < T; t++) {
            String x = (Integer.toBinaryString(Integer.parseUnsignedInt(in.nextLine())));
            char[] y = new char[32];
            int z = 0;
            for (; z < 32 - x.length(); z++) {
            		y[z] = '1';
            }
            for (int i = 0; i < x.length(); i++) {
            		if (x.charAt(i) == '1') {
            			y[i+z] = '0';
            		} else {
            			y[i+z] = '1';
            		}
            }
            System.out.println(Integer.toUnsignedString(Integer.parseUnsignedInt(new String(y), 2)));
            
        
        }
    }
}
