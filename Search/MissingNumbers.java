import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* Problem: "Missing Numbers"
  * 	url: https://www.hackerrank.com/challenges/missing-numbers/problem
  * 
  * 	Thoughts:
  * 		Should be pretty simple, you can sort both list and iterate through 
  * 		both of them concurrently. The missmatches will be the missing numbers.
  * 		The pointer pointer to the smaller number in the missmatch will be the
  * 		missing number.
  * 		
  */
public class MissingNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		in.nextLine();
		int m = Integer.parseInt(in.nextLine());
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = in.nextInt();
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		ArrayList<Integer> missingNumbers = new ArrayList<>();
		int ptrA = 0;
		int ptrB = 0;
		
		while (ptrA < a.length && ptrB < b.length) {
			if (a[ptrA] == b[ptrB]) {
				ptrA++;
				ptrB++;
			} else if (a[ptrA] < b[ptrB]) {
				missingNumbers.add(a[ptrA++]);
			} else {
				missingNumbers.add(b[ptrB++]);
			}
			
		}
		
		while (ptrA < a.length) {
			missingNumbers.add(a[ptrA++]);
		}
		
		while (ptrB < b.length) {
			missingNumbers.add(b[ptrB++]);
		}
		
		if (!missingNumbers.isEmpty()) {
			System.out.print(missingNumbers.get(0) + " ");
		}
		for (int i = 1; i < missingNumbers.size(); i++) {
			if (!missingNumbers.get(i).equals(missingNumbers.get(i-1))) {
				System.out.print(missingNumbers.get(i) + " ");
			}
		}
		
		
		

	}

}
