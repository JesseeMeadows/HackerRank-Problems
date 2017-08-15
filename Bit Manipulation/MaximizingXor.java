import java.util.Scanner;

/*	Problem: "Maximizing Xor"
 * 		url: https://www.hackerrank.com/challenges/maximizing-xor/problem
 * 		
 * 		Thoughts: simply iterate through all the possible permutations while tracking
 * 				  the max xor value throughout the process 
 */	

public class MaximizingXor {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int a = Integer.parseInt(in.nextLine());
        int b = Integer.parseInt(in.nextLine());
        
        int d = Math.max(a,b);
        int c = Math.min(a,b);
        int max = Integer.MIN_VALUE;
        for (int i = c; i <= d; i++) {
            for (int j = i; j <= d; j++ ) {
                int xord = i ^ j;
                max = Math.max(xord, max);
            }
        }
        System.out.println(max);
        
    }
}