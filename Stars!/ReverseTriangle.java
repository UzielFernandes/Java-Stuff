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

    public static void Stars(int blankorstar, int longestSide, int starGiver) { //1,2,3,4 is its values
        while(blankorstar != (longestSide+1)) {
            if (blankorstar >= starGiver) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            blankorstar++;
        }
    }

    public static void Structure(int longestSide) {
        int starGiver = longestSide;
        int blankorstar = 1;

        while(blankorstar != (longestSide+1)) {
            Stars(blankorstar,longestSide, starGiver);

            blankorstar++;
            System.out.println();
        } 
    }

}