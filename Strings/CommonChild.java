import java.util.Scanner;

/* Problem: "Sherlock and Array"
  * 	url: https://www.hackerrank.com/challenges/sherlock-and-array/problem
  * 	Thoughts: we can use a DP approach in that we recursively check 
  * 			  the max length score possible of 2 cases: if we were to
  * 			  include the character in the answer, and if we didn't;
  * 	
  */
public class CommonChild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String a = in.nextLine();
		String b = in.nextLine();
		
		System.out.println(find(a,b));

	}

	public static int find(String a, String b) {
		int[][] cache = new int[a.length()][b.length()];
		
		
		return find(a, 0, b, 0, cache) - 1;
	}

	public static int find(String a, int indexA, String b, int indexB, int[][] c) {
		if (indexA == a.length() || indexB == b.length()) {
			return 1;
		}
		
		if (c[indexA][indexB] > 0) {
			return c[indexA][indexB];
		}
		
		int nextAchar = b.indexOf(a.charAt(indexA), indexB);
		
		if (nextAchar == -1) {
			return c[indexA][indexB] = find(a, indexA + 1, b, indexB, c);
		} else {
			return c[indexA][indexB] = Math.max(
					1 + find(a, indexA + 1, b, nextAchar + 1, c),
					find(a, indexA + 1, b, indexB, c) );
		}
		
	}
}
