//Square of Stars: Almost Self Made

//Enter a number and that many rows and column of stars generate, essentially forming a square

import java.util.Scanner;

public class Square{
    public static void main(String[] args) { //whole point of main method is to get input
        Scanner scanner = new Scanner(System.in);

        System.out.println("how many star ka square?: ");
        int inputGiven = Integer.valueOf(scanner.nextLine());

        printSquare(inputGiven); //send input number to printsquare method
    }

    public static void printStars(int state) { //to print stars given by the skeleton of printsquare
        while (state!=0) {
            System.out.print("*");
            state--;
        }
    }

    public static void printSquare(int inputGiven) { //method to, well, print the square (the structure)
        int rows = inputGiven; //no of rows = input given

        while (rows != 0) {
            int state = inputGiven; //as rows decreases by one each iteration, have state variable which holds input no permanently
            printStars(state); //send to print stars method
            System.out.println(); //to leave a line after each row

            rows--;
        }
    }
}
