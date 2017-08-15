import java.util.Arrays;
import java.util.Scanner;

/*	Problem: "Sansa and Xor"
 * 		url: https://www.hackerrank.com/challenges/sansa-and-xor/problem
 * 		
 * 		Thoughts: Since there can be up to 10 million array entries we would want to eliminate as much
 * 				  work as possible. Knowing that xoring a number by the same number twice returns the original 
 * 				  number. So we only need to know if an entry occurs an odd numbers of times in all contiguous 
 * 				  subarrays. 
 * 					
 * 					-(wrong)- I believe each entry would appear 1 less than the array lengths entry, so if the 
 * 				  arrays length is even the result would be all entries xor'd together and 0 if it were odd.
 * 				  
 * 				  update: Firstly, the problem considers the entire array as a 'sub-array' so we must include that
 * 						  in our evaluation. Next, if the array's length is even than all array entries occur an 
 * 						  even number of times. This would mean all entries cancel themselves out, resulting in zero;
 * 						  For an odd length array, all even indexes should be xor'd together.
 */	
public class SansaAndXor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(in.nextLine());
			// array length even, result is zero
			if ((n | 1) != n) {
				in.nextLine();
				System.out.println(0);
			// otherwise the result is the values at even indices xor'd together;
			} else {
				int result = 0;
				for (int i = 0; i < n; i++) {
					if ((i | 1 ) != i) {
						result = result ^ in.nextInt();
					} else {
						in.nextInt();
					}
				}
				System.out.println(result);
				in.nextLine();
			}
		}
		
	}

}