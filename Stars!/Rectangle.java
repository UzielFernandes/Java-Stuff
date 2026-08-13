//Rectangle of Stars

//Program inputs number of rows and columns as two seperate numbers to generate stars in that dimensions

import java.util.Scanner;

public class Rectangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter no of rows: ");
        int noOfRows = Integer.valueOf(scanner.nextLine());

        System.out.print("enter no of columns: ");
        int noOfColumns = Integer.valueOf(scanner.nextLine());

        Structure(noOfRows, noOfColumns);
        //Stars(noOfRows, noOfColumns);
    }

    public static void Stars(int columns) {
        while(columns != 0) {
            System.out.print("*");
            columns--;
        }
    }
    
    public static void Structure(int rows, int columns) {
        
        while(rows != 0) {
            Stars(columns);
            rows--;
            System.out.println();
        }
    }

}