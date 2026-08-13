//Square of Stars: Self Made

//Enter a number and that many rows and column of stars generate, essentially forming a square

import java.util.Scanner;

public class SelfSquare {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter no of stars: ");
        int noOfStars = Integer.valueOf(scanner.nextLine());
        
        System.out.println(noOfStars);

        sub(noOfStars); //to call the method
    }

    public static void sub(int noOfStars) {

        int rows = noOfStars; //no of rows = no input by user
        int starIteration = noOfStars; //a replenishing variable which = to no input by user

        while (rows != 0) { //while rows is not 0 (each iteration rows decreases by 1!)
            while(starIteration != 0) { //to print stars
                System.out.print("*");
                starIteration--;
            }
            System.out.println();
            starIteration = noOfStars;
            rows--;
        }   
    }
}