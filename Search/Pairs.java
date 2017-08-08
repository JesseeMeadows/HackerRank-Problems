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
		
	}

}
