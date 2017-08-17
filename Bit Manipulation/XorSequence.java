import java.util.Arrays;
/*	Problem: "Xor Sequence"
 * 		url: https://www.hackerrank.com/challenges/xor-se/problem
 * 		
 * 		Thoughts: I had to look at the pattern to see this, but some observations are that there persist a pattern
 * 				  such that:
 * 					
 * 				  index multiples of 4 are have values of their index
 * 				  index multiples of 2 AND not 4 have values equal to   1 + i
 * 				  the number between these two will be a zero
 * 
 *				  As a result, a pattern repeats every 4 indexes:
 *				 
 *				  - first a zero
 *				  - then a index that's a multiple of 4 and equal to 4 due to being xor'd with the prior zero
 *				  - thirdly, a 1 because that last value is equal to the previous index and the only differing bit will be the 1-bit
 *				  - and finally will be an index that contains a value equal to 1+index. This is because this index will always be
 *					even, and when being xord with the previous value of 1 returns the value of this even index with the 1-bit flipped
 * 					
 * 				  
 */
import java.util.Scanner;	

public class XorSequence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			in.nextLine();
			long L = in.nextLong();
			long R = in.nextLong();
			long sum = 0;
			
			long range = (R - L) + 1L;
			if (range > 8) {
				System.out.println(computeLargeN(L, R));
			} else {
				sum = sumN(L, R);
				System.out.println(sum);
			}
		}
			
	}
	
	public static long computeSumOfRange(long l, long r) {
		l = l - 1;
		return  (r+1) * (r >> 2) - (l + 1) * (l >> 2);

	}
	
	public static long sumN(long l, long r) {
		long sum = 0;
		for (long i = l; i <= r; i++) {
			switch ((int)(i & 3)) {
			case 0: sum = sum ^ i;
				break;
			case 1: sum = sum ^ 1;
					break;
			case 2: sum = sum ^ (i + 1);
					break;
			}
		}
		return sum;
	}

	public static long computeLargeN(long l, long r) {
		long sum = 0;
		long x = (l & 7);
		
		if (x < 7) {
			sum = sumN(l, l + (7 - x));
		}
		
		x = (r & 7);		
		if (x == 0) {
			sum = sum ^ r;
		} else if(x < 7) {
			sum = sum ^ sumN(r - x, r);
		}
		return sum;
	}
}
