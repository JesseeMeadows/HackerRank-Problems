import java.util.Scanner;

/* Problem: "Game of Thrones - I"
  * 	url: https://www.hackerrank.com/challenges/game-of-thrones/problem
  * 	
  * 	Thoughts: There should be no more than 1 letter that has an odd character
  * 			  frequency(The rest should be even).
  */
public class GameOfThronesI {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		String s = in.nextLine();
		int[] charFreq = new int[26];
		for (int i = 0; i < s.length();i++) {
			charFreq[s.charAt(i) - 'a']++;
		}
		
		int oddCount = 0;
		for (int i = 0; i < charFreq.length; i++) {
			if (charFreq[i] % 2 == 1) {
				oddCount++;
			}
		}
		if (oddCount > 1) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}

}
