import java.io.*;
import java.util.*;

public class EmasSuperComputer {
    private TreeMap<Integer, ArrayList<Node>> st;
    public Scanner in;
    public int M;
    public int N;
    
    public EmasSuperComputer(Scanner in, int M, int N) {
        this.in = in;
        this.M = M;
        this.N = N;
        this.computePluses();
    }
    public void printPluses() {
        int maxArea = 0;
        Set<Integer> keys = st.keySet();
        for(Integer key: keys){
            for (Node x: st.get(key)) {
                for (int i = key; i >= 0 && areaOf(key,i) > maxArea; i--) {
                    if (fit(key, i) == true) {
                        ArrayList<Node> list = st.get(i);
                        for (Node y: list) {
                            if (x == y) {
                                continue;
                            } else if (dontIntersect(x,y) == true) {
                                if (areaOf(key, i) > maxArea) {
                                    maxArea = areaOf(key,i);
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println(maxArea);
    }
    
    private int areaOf(int p1, int p2) {
        return (1 + 4* p1) * (1 + 4*p2);
    }
    
    private boolean dontIntersect(Node x, Node y) {
        if ((y.x > x.x + x.p || y.x <  x.x - x.p) && (y.y > x.y + x.p || y.y < x.y - x.p)) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean fit(int p1, int p2) {
        if (p1 == 0 || p2 == 0) {
            return true;
        }
        else if (M > 2 + p1 + p2 || N > 2 + p1 + p2) {
            return true;
        }
        else {
            return false;
        }   
        
    }
    
    public void computeArea(){
        NavigableMap nmap = st.descendingMap();
        Set<Integer> keys = nmap.navigableKeySet();
        int max = 0;
        for(Integer key: keys) {
            for(Node x: st.get(key)) {
                
            }
        }
    }
    
    
    private void add(Integer key, Node value) {
        ArrayList tempList = null;
        if (st.containsKey(key)) {
            tempList = st.get(key);
            if(tempList == null)
                tempList = new ArrayList();
            tempList.add(value);  
        } else {
            tempList = new ArrayList();
            tempList.add(value);               
        }
        st.put(key,tempList);
}
    
    private void computePluses() {
        C[][] g = new C[M][N];
        st = new TreeMap<Integer, ArrayList<Node>>();
        for (int r = 0; r < M; r++) {
            String row = in.nextLine();
            int gl = 0; // amount of G pixels to left
            for (int c = 0; c < N; c++) {
                char ch = row.charAt(c);
                if (ch == 'G') {
                    C p = new C();
                    p.w = gl;
                    gl++;
                    if (r > 0 && g[r-1][c] != null) p.h = 1 + g[r-1][c].h;
                    else p.h = 0;
                    g[r][c] = p;
                } else {
                    gl = 0;
                }
            }            
        }
        
        // iterate in the reverse direction to get the cell's right and below value
        // this should be enough to compute Pluses
        
        
        for (int r = M-1; r >= 0; r--) {
            int gr = 0; // amount of G pixels to right
            for (int c = N-1; c >=0; c--) {
                    C p = g[r][c];
                if (p != null) {
                    int width = Math.min(p.w, gr);
                    int height;
                    C below = null;
                    if (p.h != 0) {
                        if (r+1 < M && (below = g[r+1][c]) != null) { 
                            below = g[r+1][c]; 
                            height = Math.min(p.h, below.h);
                            p.h = 1 + below.h;
                        } 
                        else {    height = 0;   }
                    
                    }
                    else {
                        p.h = 0;
                        height = 0;
                    } 
                    gr++;
                    int plus = Math.min(height, width);
                    add(plus, new Node(r, c, plus));
                } else {
                    gr = 0;
                  }
           }
       }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        in.nextLine();
        
        EmasSuperComputer s = new EmasSuperComputer(in, M, N);
        s.printPluses();

        
        
        
    }
    private class C  {
        public int h; // height
        public int w; // width
        
        public C() {
            
        }
        public C( int h, int w) {
            this.h = h;
            this.w = w;
        }
    }
    
    private class Node implements Comparable<Node> {
        public int x;
        public int y;
        public int p;
        
        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.p = p;
        }
        
        public int compareTo(Node o) {
            if (this.x < o.x) return -1;
            if (this.x > o.x) return 1;
            if (this.y < o.y) return -1;
            if (this.y > o.y) return -1;
            return 0;
        }
    }
}