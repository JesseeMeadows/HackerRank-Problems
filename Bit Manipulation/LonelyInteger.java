import java.util.Scanner;

/*	Problem: "Lonely Integer"
 * 		url: https://www.hackerrank.com/challenges/lonely-integer/problem
 * 		
 * 		Thoughts: xoring an integer 'x' with some integer 'y' twice will return 
 *				  the original integer 'y'; So if there's 2 of every integer in
 *				  the array except for 1 entry that contains 1, we can xor all
 *				  integers in the array together and all the pairs will cancel 
 *				  eachother out. This will result in the lonely number
 */	

public class LonelyInteger {

    static int lonelyinteger(int[] a) {
    	if (a.length == 1) return a[0];
    	
    	int sum = 0;
    	for (int i = 0; i < a.length; i++) {
    		sum = sum ^ a[i];
    	}
    	return sum;
    	
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = lonelyinteger(a);
        System.out.println(result);
    }

}
