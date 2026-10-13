/*DUNGEON CRAWLER!!!!: A CAPSTONE PROJECH BEFORE CS TAKES ME

CORE IDEA:
A custom made map is generated and the user has to navigate towards the exit avoiding and fighting mobs,
collecting treasures and avoiding obstacles

MECHANICS:
i. Map: an array list fenced with astericks/hashtags which if the user collides with counts that move as invalid (a loop to print all elements)
ii. Player: The player itself is denoted by a letter
iii. Movement: The player navigates through the map using the 'W', 'A', 'S' and 'D' keys corresponding to the direction 
The player's position in the map is deduced by using the index system of an array as a coordinate system, so simply if the user
inputs w (move north), the index value of the row while increase by provided there is no obstacle

FEATURES TO ADD (EXPANDABLE):
i. Mobs: but instead of having to fight you have to generate immunity to face them
ii. Immunity: gathered by roaming through the map and finding certain collectibles
iii. Treasure: collect a nice treasure - can add a purpose to it later
iv. Key: find the key so that the player can truly exit

abilities? more maps?*/

import java.util.*;

public class DungeonCrawler {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int xcoord = 1;
        int ycoord = 5;

        int wxCoord = 7;
        int wyCoord = 0;
        mapper(xcoord, ycoord, wxCoord, wyCoord);

    }

    public static void mapper(int xcoord, int ycoord, int wxCoord, int wyCoord) {
        Scanner sc = new Scanner(System.in);

        char[][] MAP = {  //left to right xcoord, top to down ycoord
        {'#','#','#','#','#','#','#','X','#'},
        {'#','_','_','_','_','_','#','_','#'},
        {'#','_','#','_','#','#','#','_','#'},
        {'#','_','#','_','#','K','#','_','#'},
        {'#','_','#','_','#','_','#','_','#'},
        {'#','P','#','_','_','_','_','_','#'},
        {'#','#','#','#','#','#','#','#','#'}
        };

        System.out.println('\n');

        System.out.println(MAP[ycoord][xcoord] + "\n");
        mapPrinter(MAP);

        System.out.println("ARE YOU READYYY TO PLAYYY!!???? (0 for no): ");
        int confirm = Integer.valueOf(sc.nextLine());

        if(confirm == 0) {
            System.out.println("bro?");
        } else {
            movePlayer(sc, MAP, ycoord, xcoord, wxCoord, wyCoord);
        }
    }


    public static void mapPrinter(char[][] MAP) {
        for(int i = 0; i != MAP.length; i++) {
            for(int j = 0; j != MAP[0].length; j++) {
                if (j == (MAP.length + 1)) {
                    System.out.print(MAP[i][j] + "\n");
                } else {
                    System.out.print(MAP[i][j] + "  ");
                }
                
            }
        }
    }

    public static void movePlayer(Scanner sc, char[][] MAP, int ycoord, int xcoord, int wxCoord, int wyCoord) {

        while (true) {
            System.out.println("Press the movable characters: ");
            char mover = sc.next().charAt(0);

            if (ycoord == wyCoord && xcoord == wxCoord) {
                System.out.println("YOU WIN THE GAMEE!!!!!!!");
                break;
            }

            if (mover == 'W' || mover == 'w') { //move up
                
                if (MAP[(ycoord-1)][xcoord] != '#') {
                        MAP[ycoord][xcoord] = '_';
                        ycoord--;
                        MAP[ycoord][xcoord] = 'P';      
                        
                        mapPrinter(MAP);

                } else {
                    System.out.println("Uh Huh, youre hitting a wall \n");
                }
                               
            } else if (mover == 'D' || mover == 'd') { //move right

                if (MAP[(ycoord)][(xcoord+1)] != '#') {
                        MAP[ycoord][xcoord] = '_';
                        xcoord++;
                        MAP[ycoord][xcoord] = 'P';      
                        
                        mapPrinter(MAP);

                } else {
                    System.out.println("Uh Huh, youre hitting a wall \n");
                }

            } else if (mover == 'A' || mover == 'a') { //move left

                if (MAP[(ycoord)][(xcoord-1)] != '#') {
                        MAP[ycoord][xcoord] = '_';
                        xcoord--;
                        MAP[ycoord][xcoord] = 'P';      
                        
                        mapPrinter(MAP);

                } else {
                    System.out.println("Uh Huh, youre hitting a wall \n");
                }

            } else if (mover == 'S' || mover == 's') { //move down

                if (MAP[(ycoord+1)][(xcoord)] != '#') {
                        MAP[ycoord][xcoord] = '_';
                        ycoord++;
                        MAP[ycoord][xcoord] = 'P';      
                        
                        mapPrinter(MAP);

                } else {
                    System.out.println("Uh Huh, youre hitting a wall \n");
                }

            } else if (mover == 'Q' || mover == 'q') {
                System.out.println("Quitters Losers");
                break;
            } else {
                System.out.println("Print something valid dear");
            }


        }
    }
}