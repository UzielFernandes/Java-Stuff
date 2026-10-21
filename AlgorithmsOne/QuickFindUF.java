/* QuickFind uses an array to unionize and find if two elements are connected through components using a list: 
if the indices at two array positions are true then those nodes are connected
to unionize indexes list[a] = list [b] must be done */
import java.util.Scanner;

public class QuickFindUF {
    private int[] id; //private keyword to initialize id array

    public QuickFindUF(int N) { //N is number of elements which will be passed from main function
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    } //this constructer creates a list with nos corresponding to their indexes as independent components
      // i.e if n=5: id = [0,1,2,3,4]

    public boolean Find(int p, int q) { //if indexes of two numbers are same then they are in the same component ie connected so return true
        return id[p] == id[q];
    }

    public void Union(int p, int q) { //replaces id of first no 'p' with that of second no 'q' to establish a union
        int pid = id[p];
        int qid = id[q];

        for (int i = 0; i < id.length; i++) { //check every element of list
            if (id[i] == pid) { //when we reach 'p' element 
                id[i] = qid; //replace its value with that of second element
            }
        }
    }

    public static void main(String[] args) { //main method
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter No of Nos: ");
        int N = sc.nextInt();
        QuickFindUF uf = new QuickFindUF(N);

        while (sc.hasNextInt()) {
            System.out.println("Enter first No to operate: ");
            int p = sc.nextInt();

            System.out.println("Enter second No to operate: ");
            int q = sc.nextInt();

            if (!uf.Find(p, q)) { //check if already connected
                uf.Union(p, q); //if not connect em by calling that method
                System.out.println(p + " " + q); //whatever this prints, it indicates that we have a brand new connnection!!
            }
        }

        sc.close();
    }
}