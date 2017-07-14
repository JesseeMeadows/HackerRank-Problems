import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockAndAnagrams {

    static int sherlockAndAnagrams(String s){
        // Complete this function
    	int count = 0;
    	int size = 1;
    	
    	// iterate over each subString
    	while (size != s.length()) {
    		
    		for (int i = 0; i + size < s.length() - size; i++) {
    			String ss = s.substring(i,i+size);
    			System.out.println(ss);
    			int[] ssFreq = getFreq(ss);
    			for (int j = i + size; j+size < s.length(); j++) {
    				if (isAnagram(ssFreq, s.substring(j, j+size))) {
    					count++;
    				}
    			}
    		}
    		size++;
    	}
    	
    	return count;
    }
    
   // static int calcSkip()
    
    static boolean isAnagram(int[] a, String ss) {
    	int[] o = getFreq(ss);
    	for (int i = 0; i < 24; i++) {
    		if (a[i] != o[i]) return false;
    	}
    	return true;
    }
    
    static int[] getFreq(String ss) {
    	int[] letterFreq = new int[24];
    	for (int i = 0; i < ss.length(); i++) {
    		letterFreq[ss.charAt(i) - 'a']++;
    	}
    	return letterFreq;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
    }
}
