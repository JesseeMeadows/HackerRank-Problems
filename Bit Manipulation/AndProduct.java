import java.util.Scanner;

/*	Problem: "And Product"
 * 		url: https://www.hackerrank.com/challenges/and-product/problem
 * 
 * 		Thoughts: if we are to bitwise AND across a range a numbers, the result will only include a 1-bit
 * 				  at position-n if ALL numbers in the range do the same. Starting from our left-most bit in the hi 
 * 				  number, we'll include this bit if the if it is greater,on it's own, than the lo number of the range
 * 				  we'll then move to the next bit in the hi, and compare the combination of the 2 highest bits in hi
 * 				  to the lo number. We'll continue doing this  until we find a bit that fails. Once failed, the combination 
 * 				  will be our answer(the combination of bits is greater the the lo number, then those bit's will be ANDed away
 * 				  by a permutation that includes said bits followed by opposite bits of the lo #. 
 * 
 * 				  We can XOR lo and hi together then iterate to find the left-most one bit of the result. Then we can subtract
 * 				  off the lower-order bits from lo to get our answer.
 * 

 */
public class AndProduct {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		for (int n = 0; n < N; n++) {
			in.nextLine();
			long lo = in.nextLong();
			long hi = in.nextLong();
			// lo must contain the highest 0-bit to be a lower #
			long firstZeroDigit = Long.highestOneBit((lo ^ hi));
			if (firstZeroDigit != 0) {
				// subtract the lower order bits(starting from first 0-bit from left) to get our leading 1 segment
				System.out.println(lo - (lo & (firstZeroDigit - 1)));			
			} else {
				System.out.println(hi);			// hi equals lo
			}
			//System.out.println("lo: " + lo + "\thi: " + hi + "\t HOB: " + firstZeroDigit);
		}
	}

}

