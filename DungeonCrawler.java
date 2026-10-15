
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
iii. Treasure: collect a nice treasure - can add a purpose to it later
iv. Key: find the key so that the player can truly exit

abilities? more maps?*/

import java.util.*;

public class DungeonCrawler {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int Mhealth = 5;
        int Phealth = 10;
        int Steps = 0;

        int xcoord = 1;
        int ycoord = 1;

        int KAcquired = 0;
        int Wineh = 0;

        int newy = ycoord;
        int newx = xcoord;

        mapper(xcoord, ycoord, KAcquired, Wineh, newy, newx, Mhealth, Phealth, Steps);
    }

    public static void mapper(int xcoord, int ycoord, int KAcquired, int Wineh, int newy, int newx, int Mhealth, int Phealth, int Steps) {
        Scanner sc = new Scanner(System.in);

        char[][] MAP = {  //left to right xcoord, top to down ycoord //11,6
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','P','#','_','_','_','#','_','_','_','#','_','_','#'},
            {'#','_','#','_','_','_','#','#','#','_','#','_','_','#'},
            {'#','_','#','_','_','M','_','_','#','_','#','_','_','#'},
            {'#','_','#','_','_','_','#','_','#','_','#','#','_','X'},
            {'#','_','#','#','#','_','#','_','#','_','_','#','_','#'},
            {'#','_','_','_','#','_','#','_','#','T','_','#','_','#'},
            {'#','_','#','#','#','_','#','_','#','_','_','#','_','#'},
            {'#','_','#','_','_','_','#','_','#','#','#','#','_','#'},
            {'#','_','#','_','#','#','#','_','_','_','_','#','_','#'},
            {'#','_','#','_','#','_','#','_','#','#','_','#','_','#'},
            {'#','_','#','_','#','_','#','_','#','_','_','#','_','#'},
            {'#','_','#','_','#','#','#','_','#','_','#','#','_','#'},
            {'#','_','_','_','_','_','#','_','#','_','#','_','_','#'},
            {'#','_','#','#','#','_','#','_','#','_','#','_','_','#'},
            {'#','_','#','_','_','_','#','K','#','_','_','_','_','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
        };

        System.out.println(MAP[ycoord][xcoord] + "\n");
        mapPrinter(MAP);

        System.out.println("ARE YOU READYYY TO PLAYYY!!???? (0 for no): ");
        int confirm = Integer.valueOf(sc.nextLine());

        if (confirm == 0) {
            System.out.println("bro?");
        } else {
            System.out.println("All the best! (The monster has " + Mhealth + " health points btw, avoid hitting walls to not drop you health in the process");
            System.out.println("To obtain the treasure, have atleast 8 health, acquire the key and reach the exit with the least steps as possible");
            movePlayer(sc, MAP, ycoord, xcoord, KAcquired, Wineh, newy, newx, Mhealth, Phealth, Steps);
        }
    }

    public static void mapPrinter(char[][] MAP) {
        System.out.println("\n");

        for (int i = 0; i < MAP.length; i++) {
            for (int j = 0; j < MAP[i].length; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int Winning(int KAcquired, int ycoord, int xcoord, char[][] MAP, int Wineh) {
        System.out.println(ycoord + "" + xcoord);//

        if (KAcquired == 1) {
            System.out.println("YOU WIN THE GAMEE!!!!!!!");
            return 1;
        } else {
            System.out.println("You've yet to get the key man!");
            MAP[ycoord][xcoord] = 'X';
            return 0;
        }
    }

    public static void movePlayer(Scanner sc, char[][] MAP, int ycoord, int xcoord, int KAcquired, int Wineh, int newy, int newx, int Mhealth, int Phealth, int Steps) {

        String TC = "NO";

        while (true) {

            System.out.println("Press the movable characters: ");
            char mover = sc.next().charAt(0);

            if(Phealth <= 0) {
                System.out.println("You ran out of health dear");
                break;
            }

            if((Steps <= 68 && Phealth >= 8 && KAcquired == 1) || TC.equals("YES!")) {
                MAP[6][11] = '_';
            } else if(Steps > 68 || Phealth < 8 || KAcquired != 1) {
                MAP[6][11] = '#';
            }  

            if (mover == 'W' || mover == 'w') { //move up

                if (MAP[(ycoord-1)][xcoord] != '#') {

                    if (MAP[(ycoord-1)][xcoord] == 'K') {
                        KAcquired = 1;
                    }

                    if (MAP[(ycoord-1)][xcoord] == 'M') {
                        if (Mhealth >= Phealth) {
                            System.out.println("You couldn't defeat the monster :(");
                            break;
                        } else {
                            System.out.println("YOOOO YOU DEFEATED THE MONSTER!!!!");
                        }
                    }

                    if (MAP[(ycoord-1)][xcoord] == 'T') {
                        System.out.println("YOU ACQUIRED THE TREASUREEEE!!!!!!");
                        TC = "YES!";
                    }

                    if (MAP[(ycoord-1)][xcoord] == 'X' && KAcquired == 1) {
                        System.out.println("YOU WIN THE GAMEE!!!!!!!");
                        System.out.println("Final Stats: ");
                        System.out.println("Steps taken: " + Steps);
                        System.out.println("Final Health: " + Phealth);
                        System.out.println("Treasure Acquired: " + TC);
                        break;

                    } else if (MAP[(ycoord-1)][xcoord] == 'X' && KAcquired == 0) {
                        System.out.println("You've yet to get the key man!");
                        continue;
                    }

                    MAP[ycoord][xcoord] = '_';
                    ycoord--;
                    MAP[ycoord][xcoord] = 'P';
                    Steps++;

                    mapPrinter(MAP);

                } else {
                    System.out.println("Uh Huh, youre hitting a wall AND your health is: " + Phealth-- + "\n");
                }

            } else if (mover == 'D' || mover == 'd') { //move right

                if (MAP[ycoord][xcoord+1] != '#') {

                    if (MAP[ycoord][xcoord+1] == 'K') {
                        KAcquired = 1;
                    }

                    if (MAP[(ycoord)][xcoord+1] == 'M') {
                        if (Mhealth >= Phealth) {
                            System.out.println("You couldn't defeat the monster :(");
                            break;
                        } else {
                            System.out.println("YOOOO YOU DEFEATED THE MONSTER!!!!");
                        }
                    }

                    if (MAP[(ycoord)][xcoord+1] == 'T') {
                        System.out.println("YOU ACQUIRED THE TREASUREEEE!!!!!!");
                        TC = "YES!";
                    }

                    MAP[ycoord][xcoord] = '_';

                    if (MAP[ycoord][xcoord+1] == 'X' && KAcquired == 1) {
                        System.out.println("YOU WIN THE GAMEE!!!!!!!");
                        System.out.println("Final Stats: ");
                        System.out.println("Steps taken: " + Steps);
                        System.out.println("Final Health: " + Phealth);
                        System.out.println("Treasure Acquired: " + TC);
                        break;

                    } else if (MAP[ycoord][xcoord+1] == 'X' && KAcquired == 0) {
                        System.out.println("You've yet to get the key man!");
                        continue;
                    }

                    xcoord++;
                    MAP[ycoord][xcoord] = 'P';
                    Steps++;

                    mapPrinter(MAP);

                } else {
                   System.out.println("Uh Huh, youre hitting a wall AND your health is: " + Phealth-- + "\n");
                }

            } else if (mover == 'A' || mover == 'a') { //move left

                if (MAP[ycoord][xcoord-1] != '#') {

                    if (MAP[ycoord][xcoord-1] == 'K') {
                        KAcquired = 1;
                    }

                    if (MAP[(ycoord)][xcoord-1] == 'M') {
                        if (Mhealth >= Phealth) {
                            System.out.println("You couldn't defeat the monster :(");
                            break;
                        } else {
                            System.out.println("YOOOO YOU DEFEATED THE MONSTER!!!!");
                        }
                    }

                    if (MAP[(ycoord)][xcoord-1] == 'T') {
                        System.out.println("YOU ACQUIRED THE TREASUREEEE!!!!!!");
                        TC = "YES!";
                    }

                    MAP[ycoord][xcoord] = '_';

                    if (MAP[ycoord][xcoord-1] == 'X' && KAcquired == 1) {
                        System.out.println("YOU WIN THE GAMEE!!!!!!!");
                        System.out.println("YOU WIN THE GAMEE!!!!!!!");
                        System.out.println("Final Stats: ");
                        System.out.println("Steps taken: " + Steps);
                        System.out.println("Final Health: " + Phealth);
                        System.out.println("Treasure Acquired: " + TC);
                        break;

                    } else if (MAP[ycoord][xcoord-1] == 'X' && KAcquired == 0) {
                        System.out.println("You've yet to get the key man!");
                        continue;
                    }

                    xcoord--;
                    MAP[ycoord][xcoord] = 'P';
                    Steps++;

                    mapPrinter(MAP);

                } else {
                    System.out.println("Uh Huh, youre hitting a wall AND your health is: " + Phealth-- + "\n");
                }

            } else if (mover == 'S' || mover == 's') { //move down

                if (MAP[ycoord+1][xcoord] != '#') {

                    if (MAP[ycoord+1][xcoord] == 'K') {
                        KAcquired = 1;
                    }

                    if (MAP[(ycoord+1)][xcoord] == 'M') {
                        if (Mhealth >= Phealth) {
                            System.out.println("You couldn't defeat the monster :(");
                            break;
                        } else {
                            System.out.println("YOOOO YOU DEFEATED THE MONSTER!!!!");
                        }
                    }

                    if (MAP[(ycoord+1)][xcoord] == 'T') {
                        System.out.println("YOU ACQUIRED THE TREASUREEEE!!!!!!");
                        TC = "YES!";
                    }

                    MAP[ycoord][xcoord] = '_';

                    if (MAP[ycoord+1][xcoord] == 'X' && KAcquired == 1) {
                        System.out.println("YOU WIN THE GAMEE!!!!!!!");
                        System.out.println("YOU WIN THE GAMEE!!!!!!!");
                        System.out.println("Final Stats: ");
                        System.out.println("Steps taken: " + Steps);
                        System.out.println("Final Health: " + Phealth);
                        System.out.println("Treasure Acquired: " + TC);
                        break;

                    } else if (MAP[ycoord+1][xcoord] == 'X' && KAcquired == 0) {
                        System.out.println("You've yet to get the key man!");
                        continue;
                    }

                    ycoord++;
                    MAP[ycoord][xcoord] = 'P';
                    Steps++;

                    mapPrinter(MAP);

                } else {
                    System.out.println("Uh Huh, youre hitting a wall AND your health is: " + Phealth-- + "\n");
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
