import java.util.Scanner;

public class SelfSquare {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter no of stars: ");
        int noOfStars = Integer.valueOf(scanner.nextLine());
        
        System.out.println(noOfStars);

        sub(noOfStars);
    }

    public static void sub(int noOfStars) {

        int rows = noOfStars;
        int starIteration = noOfStars;

        while (rows != 0) {
            while(starIteration != 0) {
                System.out.print("*");
                starIteration--;
            }
            System.out.println();
            starIteration = noOfStars;
            rows--;
        }   
    }
}