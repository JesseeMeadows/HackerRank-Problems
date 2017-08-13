
public class BitManipulation {

	public static void main(String[] args) {
		int n = 10;
		int k = 5;
		
		// Maximum Integer
		int maxInt = ~(1 << 31);
			maxInt = (1 << 31) - 1;
			maxInt = (1 << -1);
			
		// Minimum Integer
		int minInt = 1 << 31;
			minInt = 1 << -1;
				
		// Maximum long
		long maxLong = (1L << 63) - 1;	
		System.out.println(maxLong);
		System.out.println(Long.MAX_VALUE);
		
		// Double integer
		 int g = 5;
		 	g = g << 1;
		 	
		 // halve integer
		 // z
		  int f = 12;
		  f = f >> 1;
		 	
		 // y  
		 
		 // multiply by m-th power of 2
		 	int m = 4;
		 	f = f << m;
		 	
		 // divide by m-th power of 2
		 	int someNum = 24;
		 	someNum = someNum >> 3;
		 	
		 // check odd number
		 	int oddNum = 3;
		 	boolean isOdd = (oddNum & 1) == 1; 
		 	
		 // swap 2 values
		 	int a = 5;
		 	int b = 5;
		 	a ^= b;		// produces the differing bits between the 2 - note that
		 	b ^= a;		// essentially flips all the originally differing bits, giving us 'a'
		 				// 	
		 	a ^= b;		// same thing here, 'b' is the original 'a', and xor'ing it with the 
		 				// differing bits between the 2 gives us 'b' because the combination of 
		 				// 2 xor's do affect similar bits between the 2, only flipping differing bits
		 	
		 	
		 	// Get absolute value
		 	int absOfN = (n ^ (n >> 31)) - (n >> 31);
		 	
		 			// (n >> 31) : if n is positive will result in 0
		 			// 			 : otherwise will result in -1 (all 1 bits including sign bit)
		 			
		 			// n ^ (n >> 31) : if n is positive the result will be the original number
		 			//				 : else we'll get the one's complement of the original number
		 			// 				 : this is because -number xor against 11111..11 
		 			
		 			// - (n >> 31)	 : results in the original number if positive, if negative
		 			// 				 : subtracts 1 from the now positive number
		 	
		 			// Essentially nothing happens if the number is positive, but if it's negative
		 			// all bits get flipped resulting in the one's complement of the number and then
		 			// one is subtracted from this result to give us the 2's complement of the number
		 			// which is how java represents negative numbers (2's complement of positive counterpart)
		 	
		 	// Get the max of two values
		 	int maxAB = b & ((a-b) >> 31) | a & (~(a-b) >> 31);
		 	
		 	/* 		b & ((a-b) >> 31) : results in b if b > a because (a-b) >> 32 will be -1 or 11111...111
		 	 * 							otherwise results will be zero 
		 	 * 		a & (~(a-b) >> 31 : if (a-b) is positive, the '~' will flip the sign bit to make it negative
		 	 * 							so that the '>> 31' will result in -1 or 1111...111. 'a' will return itself
		 	 * 							other the '~' flips it positive and 'a' is & with 0 resulting in 0
		 	 * 			
		 	 * 	Thus what happens is that the maximum is returned, if they're equal the '|' will return their value
		 	 * 							
		 	 */
		 				
		 	
		 	// Get the min of two values
		 	int minAB = a & ((a-b) >> 31) | b & (~(a-b) >> 31);
		 	
		 	/* Only difference here is that 'a' and 'b'  are swapped before the '&' such that they
		 	 * return the opposite value with the same respective functionality to the max value
		 	 * 
		 	 */
		 	
		 	// Check whether both have the same sign
		 	boolean sameSign = (g ^ f) >= 0;          // simple, differing bitsigns will result in a 
		 											  // > 1 sign bit, giving us a negative number
		 	// Calculate 2^n
		 	int twoTon = 2 << (n-1);
		 	
		 	// Whether is factorial of 2
		 	boolean isFactorialOf2 = n > 0 ? (n & (n - 1)) == 0 : false;
		 	
		 	/* a factorial of 2 will obtain a single '1' bit, subtracting from 1 this number will
		 	 * result in a '1's in all positions prior to the '1', so '&'ing the two will be zero
		 	 * 		example:			16	=	0010000
		 	 * 				(16 - 1)	15  =   0001111
		 	 * 						& result:   0000000
		 	 */				
		 	
		 	// Modulo 2^n against m
		 	int mod2ToN = m & (n - 1);
		 	
		 	// Get the average
		 	g = (g + f) >> 1;	// add and divide by 2
		 	g = ((g ^ f) >> 1) + (g & f);	
		 	
		 	// Get the m-th bit of n (from low to high)
		 	int mthBit = (n >> (m-1)) & 1;			// shifts mth bit to 1st bit and &'s with 1
		 	
		 	// Set the m-th bit of n to 0 (from low to high)
		 	n = n & ~(1 << (m-1));
		 	n = n + 1;
		 	n = -~n;
		 	n = n - 1;
		 	n = ~-n;
		 	
		 	// Get the contrast number
		 	n = ~n + 1;
		 	n = (n ^ -1) + 1; 
		 	if (g==a) g=b; 
		 	if (g==b) g=a;
		 	g = a ^ b ^ g;
		 	
		 	// Setting kth bit
		 	n = n |(1 << k - 1);
		 	
		 	// clearing kth bit
		 	n = n & (1 << k - 1);
		 	
		 	// toggle kth bit
		 	n = n ^ (1 << k - 1);
		 	
		 	// check if kth bit set
		 	boolean kthBitSet = n == (n | (1 << k - 1));
		 	
		 	// check if 2 ints are equal
		 	boolean isEqual = (m ^ n) == 0;			// 0 differing bits
		 	
		 	// GCD of two numbers
		 	// while(b^=a^=b^=a%=b);
		 	// return a;
		 	
		 	// return right-most 1 in binary set
		 	int rightMostOne = (m ^ (m & (m - 1)));
		 	
		 	/*	 (m & (m - 1))	: subtracting one will result in, from left-to-right, the original
		 	 * 					  number up until the right-most 1 becoming a zero, then all 1s;
		 	 * 					  &'ing this number with the original will give us the original number
		 	 * 					  back with the right-most 1 being flipped;
		 	 * 
		 	 * 	 (m ^ prevResult): This will give us the answer because xor'ing the previous result with
		 	 * 					   the original number will result in the only differing bit
		 	 */
		 	
		 	// xor without '^' operator
		 	int result = (~m & n) | (m & ~n);
	}

}
