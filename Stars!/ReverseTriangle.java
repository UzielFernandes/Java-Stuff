//Reverse Triangle

//blank blank star, blank star as you go on

import java.util.Scanner;

public class ReverseTriangle{
    public static void main(String[] args) { //whole point of main method is to get input
        Scanner scanner = new Scanner(System.in);

        System.out.print("how many star ka reverse triangle?: ");
        int inputGiven = Integer.valueOf(scanner.nextLine());

        Structure(inputGiven);
    }

    public static void printStars(int state, int counter) { //to print stars given by the skeleton of printsquare
        while (state!=0) {
            if (state <= counter) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }            
            state--;
            //System.out.print(counter);
        }
    }

    public static void Structure(int inputGiven) { //method to, well, print the square (the structure)
        int rows = inputGiven; //no of rows = input given
        int counter = (inputGiven-inputGiven)+1;

        while (rows != 0) {
            int state = inputGiven; //as rows decreases by one each iteration, have state variable which holds input no permanently
            printStars(state, counter); //send to print stars method
            System.out.println(); //to leave a line after each row

            counter++;
            rows--;
        }
    }
}