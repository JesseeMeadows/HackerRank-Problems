import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockAndValidString {

    static String isValid(String s){
        // Complete this function
        // Create Array that holds the count of each character in alphabet
        int[] count = new int[26];
        
        // frequency of character can't be differ by more than 1 up to 3 chars
        if (s.length() <= 3) {
            return "YES";
        }
        
        // ensure there's atleast 3 different characters in string otherwise
        // 2 types : compare 2 types and submit if counts +/- 1 of eachother
        // 1 types : submit true (freq of 1 char is always true)
        int index1 = s.charAt(0) - 'a';
        int index2 = -1;
        int index3 = -1;
        
        // index 1-2-3 chars
        char c1 = s.charAt(0);    
        char c2;
        
        // find if second character type exist
        int i_s = 0;             // String s index counter
        
        while (i_s < s.length() && s.charAt(i_s) != c1) {
            count[index1]++;
            i_s++;
        }
        
        // String consist of only 1 character
        if (i_s == s.length()) return "YES";
        
        assert i_s < s.length();
        
        // otherwise loop terminated due to running into our second character
        index2 = s.charAt(i_s) - 'a';
        c2 = s.charAt(i_s);
        
        // find if third character type exist
        while (i_s < s.length() && s.charAt(i_s) != c1 && s.charAt(i_s) != c2) {
            if (s.charAt(i_s) == c1) count[index1]++;
            else                     count[index2]++;
            i_s++;
        }
        
        // only 2 character type exist in string s
        if (i_s == s.length()) {
                // counts of 2 chars differ by more than 1
                if (count[index1] - count[index2] > 1 
                ||  count[index2] - count[index1] > 1) { 
                    return "NO";
                }
                // counts within 1 of eachother
                else {
                    return "YES";
                }
        }
        
        // o/w there's atleast 3 different chars in string s
        // count frequecy of rest of characters
        while (i_s < s.length()) {
            count[s.charAt(i_s) - 'a']++;
            i_s++;
        }
        
        
        int maxCount = 0;
        int charsAtMax = 0;
        int minCount = s.length(); 
        int charsAtMin = 0;
        for (int i = 0; i < 26; i++) {
            int chCount = count[i];
            if (chCount != 0) {
                if (chCount > maxCount) {
                    maxCount = chCount;
                    charsAtMax = 0;
                }
                if (chCount == maxCount) {
                    charsAtMax += 1;
                }
                
                if (chCount < minCount) {
                    minCount = chCount;
                    charsAtMin = 0;
                } 
                if (chCount == minCount) {
                    charsAtMin += 1;
                }
            }
        }
        
        
        // char freq are all the same
        if (maxCount == minCount) return "YES";
        else if (charsAtMax == 1 && charsAtMin * minCount + maxCount == s.length()) return "YES";
        else if (charsAtMin == 1 && charsAtMax * maxCount + minCount == s.length()) return "YES";
        else return "NO";
            
        
        
        
        
        
        
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
