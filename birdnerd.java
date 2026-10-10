import java.util.Scanner;
import java.util.ArrayList;

public class birdnerd {
    private String name;
    private String latinName;
    private int observations;

    public birdnerd(String initialName, String initialLatin) {
        this.name = initialName;
        this.latinName = initialLatin;
        this.observations = 0;
    }

    public static void addBird(Scanner sc, ArrayList<birdnerd> data) {   //declare in main and use here, not really necessary but when you have to use again in other functions that time youll understand aaaa
        System.out.println("Enter bird name: ");
        String birdName = sc.nextLine();
        System.out.println("Enter its latin name or some gibberish lol: ");
        String latinName = sc.nextLine();

        birdnerd newBird = new birdnerd(birdName, latinName);
        data.add(newBird);

        System.out.println(data); //automatically naviates tostring metgid
        
    }

    @Override 
    public String toString() {
        return "The name of your bird be: " + name + " it's latin name be: " + latinName + " and youve seen it: " + observations + " times";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<birdnerd> data = new ArrayList<>();

        while (true) {
            System.out.println("""
                    Type 1 for adding birds
                    2 for recording and printing observations
                    3 to print all birds
                    4 to print one bird of your choice
                    5 to quit
                    """);

            int option = Integer.valueOf(sc.nextLine());

            if (option == 1) {
                addBird(sc, data);
            }

            if (option == 2) { //for printing obdservations first make the search and then add the observation++ through the position of bird in array

            }

            if (option == 3) {
                System.out.println(data);
            }

            if (option == 4) {

            }

            if (option == 5) {
                break;
            }
        }
        

    }
}

