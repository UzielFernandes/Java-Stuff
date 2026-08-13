//Triangle of Stars

//Enter a number and the longest side of the triangle would be that many stars, then reduce by one star

import java.util.Scanner;

public class Triangle { //to take input
    public static void main(String[] args) { //whole point of main method is to get input
        Scanner scanner = new Scanner(System.in);

        System.out.print("how many stars should be the longest side of teh triangle?: ");
        int inputGiven = Integer.valueOf(scanner.nextLine());

        Structure(inputGiven); //pass this variable to structure
    }

    public static void printStars(int longestSide) {
        while(longestSide != 0) { //while this variable is not 0:each iteration print star and decrease value by one
            System.out.print("*");
            longestSide--;
        }
    }

    public static void Structure(int noOfStars) {
        int longestSide = 1; //placehoolder variable, for while loop condition to be equal to input

        while(longestSide != (noOfStars+1)) { //placeholder variable adds its way upto input by one: one iteration at a time
            printStars(longestSide);
            longestSide++;
            System.out.println();
        }
    }
}