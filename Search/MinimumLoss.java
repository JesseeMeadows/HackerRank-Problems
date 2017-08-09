import java.util.Arrays;
import java.util.Scanner;

/* Problem: "Minimum Loss"
  * 	url: https://www.hackerrank.com/challenges/minimum-loss/problem
  * 	
  * 	Thoughts: We could first create an index to track the original order of
  * 			  Prices, then sort the prices. We'll then iterate through the 
  * 			  sorted price list, and for each entry we will find the first 
  * 			  entry before it that has a lower index. This will give us the 
  * 			  minimum possible loss for each entry, and we'll just have to 
  * 			  track the minimum of all of them while iterating through the list
  * 
  */

// I'll use the class to create a simple pair object to hold the original index
// of the object, but for parity sake I'll keep the name of the class the same
// to reflect the problem I'm solving
public class MinimumLoss implements Comparable<MinimumLoss> {
	public final int index;
	public final long value;
	
	public MinimumLoss (int index, long value) {
		this.index = index;
		this.value = value;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		int n = Integer.parseInt(in.nextLine());
		MinimumLoss[] p = new MinimumLoss[n];
		for (int i = 0; i < n; i++) {
			p[i] = new MinimumLoss(i, in.nextLong());
		}
		
		// We'll use the standard library's sort which is a variation of mergesort
		// for objects, but a radix sort would typically be better
		Arrays.sort(p);
		
		long min = Integer.MAX_VALUE;
		
		for (int i = 0; i < p.length; i++) {
			// Note: we move on to the next element when the possible minimum loss
			// 		 grows larger than the minimum 
			for (int j = i + 1; j < p.length && p[j].value - p[i].value < min ; j++) {
				if (p[i].index > p[j].index) {
						min = p[j].value - p[i].value;	 
				}
			}
		}
		
		System.out.println(min);

	}
	
	public int compareTo(MinimumLoss other) {
		return Long.valueOf(this.value).compareTo(other.value);
	}

}
