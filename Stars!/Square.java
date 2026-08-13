import java.util.Scanner;

public class Square{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("how many star ka square?: ");
        int inputGiven = Integer.valueOf(scanner.nextLine());

        printSquare(inputGiven);        
    }

    public static void printStars(int state) {
        while (state!=0) {
            System.out.print("*");
            state--;
        }
    }

    public static void printSquare(int inputGiven) {
        int rows = inputGiven;

        while (rows != 0) {
            int state = inputGiven;
            printStars(state);
            System.out.println();

            rows--;
        }
    }
}
