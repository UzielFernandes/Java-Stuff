/*Quick Union Weight is a modification by adding the smaller tree alays to the bigger tree regardless of p and q*/

import java.util.Scanner;

public class QuickUnionWeight {
    private int id[]; //private keyword to initialize id array
    private int sz[]; //to maintain size of each tree 

    public QuickUnionWeight(int N) { //N is number of elements which will be passed from main function
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    } //this constructer creates a list with nos corresponding to their indexes as independent components
      // i.e if n=5: id = [0,1,2,3,4]

    public boolean Find(int p, int q) { //if indexes of two numbers are same then they are in the same component ie connected so return true
        return root(p) == root(q);
    }

    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    } //if no in list is not what we want, go to its parent till it goes to the root

    public void Union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i == j) return;

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i]; //adding smaller tree to larger tree
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    } //to union, set the value of index of number to unionize to the ROOT of second value (i.e to from above, union(3,6) would mean root of 3 (1) will be made a child of root of 6(4))

    public static void main(String[] args) { //main method
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter No of Nos: ");
            int N = sc.nextInt();
            QuickUnionWeight uf = new QuickUnionWeight(N);

            while (true) {
                System.out.println("Enter first No to operate: ");
                int p = sc.nextInt();

                System.out.println("Enter second No to operate: ");
                int q = sc.nextInt();

                if (!uf.Find(p, q)) { //check if already connected
                    uf.Union(p, q); //if not connect em by calling that method
                    System.out.println("connected elements: " + p + " " + q); //whatever this prints, it indicates that we have a brand new connnection!!
                } else {
                    System.out.println(p + " " + q + " are already connected");
                }
            }
        }

    }

