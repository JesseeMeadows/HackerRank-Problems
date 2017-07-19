import java.io.*;
import java.util.*;

public class TheBombermanGame {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int C = in.nextInt();
        int N = in.nextInt();
        in.nextLine();
        char clr = 'x';
        
        // Graph
        char[][] g = new char[R][C];

        int bombs = 0;
        
        for (int i = 0; i < R; i++) {
            String row = in.nextLine();
            for (int j = 0; j < C; j++) {
                char ch = row.charAt(j);
                g[i][j] = ch;
                if (ch == 'O' && N % 4 == 1) {bombs++;}
            }
        }
        
        if (N % 2 == 0 || N == 1) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (N%2 == 0) {
                        System.out.print('O');
                    } else {
                        System.out.print(g[i][j]);
                    }  
                }
                System.out.println();
            }
            return;
        }
        
        int count = 1;
        while (count < N) {
            
            // determine bomb placement
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    char ch = g[i][j];
                    if (ch == 'O') {
                        g[i][j] = clr;
                        if (i-1 >= 0   && g[i-1][j] != 'O')    {g[i-1][j] = clr;}
                        if (i+1 <= R-1 && g[i+1][j] != 'O')    {g[i+1][j] = clr;}
                        if (j-1 >= 0   && g[i][j-1] != 'O')    {g[i][j-1] = clr;}
                        if (j+1 <= C-1 && g[i][j+1] != 'O')    {g[i][j+1] = clr;}
                    } else {
                        if (ch != clr) {
                             g[i][j] = '.';
                        }
                    
                    }
                }
            }
            // 
            int bombCount = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    char ch = g[i][j];
                    if (ch == clr) {
                        g[i][j] = '.';
                    } else {
                        g[i][j] = 'O';
                        bombCount++;
                    }
                }
            }
            
            count += 2;
            if (count % 4 == N % 4) {
                if (bombs == bombCount) {
                    break;
                } else {
                    bombs = bombCount;
                }
            
            }
            
        }
            
        for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(g[i][j]);
                }
                System.out.println();
        }
    }
    

}