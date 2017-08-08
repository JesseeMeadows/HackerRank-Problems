import java.util.Scanner;

/* Problem: "Sherlock and Array"
  * 	url: https://www.hackerrank.com/challenges/sherlock-and-array/problem
  * 
  */
public class SherlockAndArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			in.nextLine();
			int n = in.nextInt();
			int[] a = new int[n];
			in.nextLine();
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}
			
			if (n == 1) {
				System.out.println("YES");
				continue;
			}
			if (n < 3) {
				System.out.println("NO");
				continue;
			}
			
			//pseudo pointer for index
			int p = 1;
			int left = a[0];
			int right = 0;
			for (int i = 2; i < a.length; i++) {
				right += a[i];
			}
			boolean success = false;
			while (p < a.length - 1 && !success) {
				if (left == right) {
					success = true;
				} else {
					left += a[p];
					p++;
					right -= a[p];
				}
			}
			
			if (success) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			
		}
	}

}
