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

    public static void main(String[] args) {
        char[][] MAP = {
        {'#','#','#','#','#','#'},
        {'#','_','_','_','_','#'},
        {'#','_','_','_','_','#'},
        {'#','_','_','_','_','#'},
        {'#','_','_','_','_','#'},
        {'#','_','_','_','_','#'},
        {'#','#','#','#','#','#'}
        };

        mapPrinter(MAP);
    }

    public static void mapPrinter(char[][] MAP) {
        for(int i = 0; i != 7; i++) {
            for(int j = 0; j != 6; j++) {
                if (j == 5) {
                    System.out.print(MAP[i][j] + "\n");
                } else {
                    System.out.print(MAP[i][j] + " ");
                }
                
            }
        }
    }
}