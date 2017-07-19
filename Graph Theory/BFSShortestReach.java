/*
    Graph and Bag classes are courtesy of the booksite for "Algorithms" 4th ed. by Robert Sedgewick and Kevin Wayne. The       code can be found here: http://algs4.cs.princeton.edu/code/
*/
import java.io.*;
import java.util.*;


public class BFSShortestReach {
	private final int V;
	private Bag<Integer>[] adj;

	public BFSShortestReach(int V) {
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<Integer>();
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
    
    public void printShortestReach(int s) {
        int[] distTo = new int[V];
        boolean[] marked = new boolean[V];
        Arrays.fill(distTo, -1);
        distTo[s] = 0;
        
        //
        marked[s] = true;
        
        Bag<Integer> unmarkedNodes = new Bag<Integer>();
        unmarkedNodes.add(s);
        
        int d = 1;
        
        while (unmarkedNodes.isEmpty() != true) {
            Bag<Integer> unmarked = new Bag<Integer>();
            
            for (Integer i: unmarkedNodes) {
                for (Integer v: this.adj(i)) {
                    if (marked[v] == false) {
                        unmarked.add(v);
                        marked[v] = true;
                        distTo[v] = d;
                    }
                }
            }
            unmarkedNodes = unmarked;
            d++;
        }
        
        for (int i = 0; i < marked.length; i++) {
            if (i != s) {
                String output;
                if (distTo[i] == -1)     output = "-1";
                else                     output = Integer.toString(6 * distTo[i]);
                
                if (i != marked.length - 1) output = output + " ";
                System.out.print(output);
            }
        }
        System.out.println();
    }
    
    public void printGraph() {
        for(int v = 0; v < V; v++) {
            for (Integer i: this.adj(v)) {
                System.out.println (v + "-" + i );
            }
        }
    }
    
    private Iterable<Integer> adj(int v) {
        return adj[v];
    }
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        in.nextLine();
        for (int q = 0; q < Q; q++) {
            int nNodes = in.nextInt();
            int mLinks = in.nextInt();
            in.nextLine();
            
            BFSShortestReach g = new BFSShortestReach(nNodes);
            for (int m = 0; m < mLinks; m++) {
                g.addEdge(in.nextInt() - 1, in.nextInt() - 1);
                in.nextLine();
            }
            int startNode = in.nextInt() - 1;
            if (q != Q - 1)
                in.nextLine();
            g.printShortestReach(startNode);
        }
        
        
    }
    
    
    private static class Bag<Item> implements Iterable<Item> {
        private Node<Item> first;    // beginning of bag
        private int n;               // number of elements in bag

        // helper linked list class
        private static class Node<Item> {
            private Item item;
            private Node<Item> next;
        }

        /**
         * Initializes an empty bag.
         */
        public Bag() {
            first = null;
            n = 0;
        }

        /**
         * Returns true if this bag is empty.
         *
         * @return {@code true} if this bag is empty;
         *         {@code false} otherwise
         */
        public boolean isEmpty() {
            return first == null;
        }

        /**
         * Returns the number of items in this bag.
         *
         * @return the number of items in this bag
         */
        public int size() {
            return n;
        }

        /**
         * Adds the item to this bag.
         *
         * @param  item the item to add to this bag
         */
        public void add(Item item) {
            Node<Item> oldfirst = first;
            first = new Node<Item>();
            first.item = item;
            first.next = oldfirst;
            n++;
        }


        /**
         * Returns an iterator that iterates over the items in this bag in arbitrary order.
         *
         * @return an iterator that iterates over the items in this bag in arbitrary order
         */
        public Iterator<Item> iterator()  {
            return new ListIterator<Item>(first);  
        }

        // an iterator, doesn't implement remove() since it's optional
        private class ListIterator<Item> implements Iterator<Item> {
            private Node<Item> current;

            public ListIterator(Node<Item> first) {
                current = first;
            }

            public boolean hasNext()  { return current != null;                     }
            public void remove()      { throw new UnsupportedOperationException();  }

            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = current.item;
                current = current.next; 
                return item;
            }
        }

    }
}