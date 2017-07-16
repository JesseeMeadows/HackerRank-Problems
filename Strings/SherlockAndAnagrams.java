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
    		
    		
    		for (int i = 0; i < s.length() - size; i++) {
    			String ss = s.substring(i,i+size);
    			int[] ssFreq = getFreq(ss);
    			int[] oFreq = Arrays.copyOf(ssFreq, 26);
    			for (int j = i; j + size < s.length(); j++) {
        			oFreq[s.charAt(j) 		 - 'a']--;
    				oFreq[s.charAt(j + size) - 'a']++;
    				
    				if (isAnagram(ssFreq, oFreq)) {
    					count++;
    				}
    			}
    		}
    		size++;
    	}
    	
    	return count;
    }    
    static boolean isAnagram(int[] a, int[] o) {
    	for (int i = 0; i < 26; i++) {
    		if (a[i] != o[i]) return false;
    	}
    	return true;
    }
    
    static int[] getFreq(String ss) {
    	int[] letterFreq = new int[26];
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
