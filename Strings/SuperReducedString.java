import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.StringBuilder;

public class SuperReducedString {

    static String super_reduced_string(String s){
        StringBuilder st = new StringBuilder(s);
        boolean cont = true;
        while (cont) {
            cont = false;
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < st.length() - 1; i++) {
                if (st.charAt(i) == st.charAt(i+1)) {
                    cont = true;
                    if (i == st.length() - 3) {
                        temp.append(st.charAt(st.length()-1));
                    }
                    i++;
                } else {
                    temp.append(st.charAt(i));
                    if (i == st.length() - 2) {
                        temp.append(st.charAt(st.length()-1));
                    }
                }
            }
            st = temp;
        }
        if (st.length() == 0) return "Empty String"; 
        return st.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
