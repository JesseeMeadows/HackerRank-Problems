import java.io.*;
import java.util.*;
import java.lang.StringBuilder;

public class BiggerIsGreater {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        String[] words = new String[t];
        
        // read in words
        for (int i = 0; i < t; i++) {
            words[i] = in.nextLine();
        }
        
        // solve for each word
        for (int i = 0; i < t; i++) {
            char[] it = words[i].toCharArray();
            char[] solved = new char[it.length];
            Integer toSwap = null;
            
            for (int j = it.length - 1; j > 0; j--) {
                // find first character to break ascending order from right to left
                if (it[j-1] < it[j]) {
                    toSwap = new Integer(j-1);
                    break;
                }
            }
            if (toSwap == null) {
                words[i] = new String("no answer");
            } else {
                
                for ( int j = it.length -1; j > toSwap; j--) {
                    if (it[j] > it[toSwap]) {
                        char ch = it[toSwap];
                        it[toSwap] = it[j];
                        it[j] = ch;  
                        break;
                    }
                }
            
                for (int j = 0; j <= toSwap; j++){
                   solved[j] = it[j];
                }
                for (int j = it.length - 1; j > toSwap; j--) {
                    solved[j] = it[toSwap + it.length - j];
                }
                words[i] = new String(solved);
            }
            
        }
        for (int i = 0; i < t; i++) {
            System.out.println(words[i]);
        }
        
        
        
    }
}