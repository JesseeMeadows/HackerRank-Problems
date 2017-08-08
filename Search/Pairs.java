import java.util.Arrays;
import java.util.Scanner;

/* Problem: https://www.hackerrank.com/challenges/pairs/problem
 *   
 *  Thoughts: 
 *  - we could radix sort the numbers in linear time then use 2 pointers starting
 *    at the beginning of the array. We'll use 2 pointers starting one pointer at 
 *    index 0 and the other at index 1. We will find the difference between the 2 
 *    values at the pointers and for that value we'll:
 *    	if less than K, move right pointer to the next index
 *      if greater than k:
 *      	move left pointer right(move both pointers right if they're adjacent)
 *      if equal to K:
 *      	increment both pointers 1 unit, add 1 to count 
 */
public class Pairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		in.nextLine();

		Integer[] a = new Integer[N];
		for (int i = 0; i < N; i++) {
			a[i] = in.nextInt();
		}

		// We'll settle with quicksort for a quick and easy solution although
		// radix sort would give us better results
		Arrays.sort(a);

		// pseudo-pointer indexes
		int lp = 0;
		int rp = 1;

		int count = 0;

		while (lp < a.length && rp < a.length) {
			int diff = a[rp] - a[lp];

			if (diff < K) {
				rp++;
			} else if (diff > K) {
				lp++;
				if (lp == rp)
					rp++;
			} else {
				count++;
				lp++;
				rp++;
			}
		}

		System.out.println(count);

	}

}
