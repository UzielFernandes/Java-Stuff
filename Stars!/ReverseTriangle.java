//Reverse Triangle

//blank blank star, blank star as you go on
//Used square logic but replaced stars with blank space where not needed

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
        int counter = 1; //to start frin bottom up to the input number

        while (rows != 0) {
            int state = inputGiven; //as rows decreases by one each iteration, have state variable which holds input no permanently
            printStars(state, counter); //send to print stars method
            System.out.println(); //to leave a line after each row

            counter++;
            rows--;
        }
    }
}

/*  ChatGPTs Approach (more decentralization)

public static void printSpaces(int number) {
    while (number != 0) {
        System.out.print(" ");
        number--;
    }
}

public static void printStars(int number) {
    while (number != 0) {
        System.out.print("*");
        number--;
    }
}

public static void printTriangle(int size) {
    int row = 1;

    while (row <= size) {
        printSpaces(size - row);
        printStars(row);
        System.out.println();

        row++;
    }
} */