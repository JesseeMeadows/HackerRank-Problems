import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SamAndSubStrings {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	Scanner in = new Scanner(System.in);
    	String s = in.nextLine();
    	char[] b4Mod = new char[s.length() + 1];
    	
    	long lsd = 0;
    	// Calculate LSD    
    	for (int i = 0; i < s.length(); i++) {
    		int ithDigit = s.charAt(i) - '0';
    		lsd += (i+1) * ithDigit; 
    	}
    	
    	// Calculate 
    	long r = 0;
    	for (int i = s.length()-1; i >= 0; i--) {
    		//System.out.println("lsd: " + lsd + "   r: " + r);
    		b4Mod[i+1] = Character.forDigit((int)((lsd + r) % 10), 10);
    		int ithDigit = s.charAt(i) - '0';
    		if (lsd + r > 9) {
    			r = (lsd + r) / 10;
    		} else {
    			r = 0;
    		}
    		lsd -= (ithDigit * ( i + 1)); 
    		
    	}

		b4Mod[0] = Character.forDigit((int)((lsd + r) % 10), 10);
    	
    	BigInteger preMod = new BigInteger(new String(b4Mod), 10);
    	BigInteger result = preMod.mod(new BigInteger("1000000007"));
    	System.out.println(result);
    	
    }
}
