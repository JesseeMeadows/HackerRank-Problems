import java.util.Scanner;

/*	Problem: "Sum vs Xor"
 * 		url: https://www.hackerrank.com/challenges/sum-vs-xor/problem
 * 		
 * 		Thoughts: 
 * 			<>     0 <= x <= n
 * 			<>     n + x == n ^ x;
 * 
 * 			The only way that I believe a number can increase via xoring by a given x is when
 * 			that x contains 1 bits only at indexes that the number doesn't. So if a given x has
 * 			y 0-bits before its left-most 1-bit, it would have 2^(y-1) numbers that satisfy our 
 * 			conditions.
 */
public class SumVsXor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long count = 1; // 0 -base case;
		while (n > 0) {
			if ((n & 1) == 0) {
				count = (count << 1);
			}
			n = (n >> 1);
		}
		System.out.println(count);
	}

}
