import java.util.Scanner;

/*	Problem: "The Great Xor"
 * 		url: https://www.hackerrank.com/challenges/the-great-xor/problem
 * 
 * 		Thoughts: 
 * 			Seems very similar to the "Sum vs Xor" problem. You can increase a number via xoring by x
 * 			that contains 1-bit's at the other number's 0-bits. This problem only requires that the result
 * 			is higher, so for any 0-bit in our original number there's 2^bit's-position of numbers that can be used
 * 			to increase the number. This is because for a given bit, say 16, the lower order bits can only change up
 * 			to 15 (n - 1) bits. This means that the number will increase for all numbers you can represent via that bit. 
 * 			One solution for this problem would be to simply flip all bits besides the left-most 1 bit.
 */
public class TheGreatXor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int Q = Integer.parseInt(in.nextLine());
		for (int q = 0; q < Q; q++) {
			long n = in.nextLong();
			long power = 1; // 0 -base case;
			long count = 0;
			if ((n & 1) == 0) {
				count++;
			}
			n = n >> 1;
			while (n > 1) {
				if ((n & 1) == 0) {
					count += (1L << power);
				}
				power++;
				n = (n >> 1);
			}
			System.out.println(count);
		}
		
	}

}
