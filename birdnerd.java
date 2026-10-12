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

    public static void addBird(Scanner sc, ArrayList<birdnerd> data,ArrayList<String> birdname) {   //declare in main and use here, not really necessary but when you have to use again in other functions that time youll understand aaaa
        System.out.println("Enter bird name: ");
        String birdName = sc.nextLine();
        System.out.println("Enter its latin name or some gibberish lol: ");
        String latinName = sc.nextLine();

        birdnerd newBird = new birdnerd(birdName, latinName);
        data.add(newBird);
        birdname.add(birdName);

        System.out.println(data); //automatically naviates tostring method
    }

    public int getObservations(int observerPlus) {
        this.observations += observerPlus;
        return this.observations;
    }

    public String getBirdName() {
        return this.name;
    }

    public static void Searcher(ArrayList<birdnerd> data, ArrayList<String> birdname, int searchPurpose, int observerPlus, Scanner sc) {
        int pass = 0;

        System.out.println("Enter birdy to be found: ");
        String find = String.valueOf(sc.nextLine());


        for(int i = 0; i < data.size(); i++) {
            if ((birdname.get(i).equals(find))) {
                System.out.println(data.get(i));
                pass = 1;

                if(searchPurpose == 1) {
                    System.out.println("how many " + data.get(i).getBirdName() + " did you see today? (0 for none) ");
                    observerPlus = Integer.valueOf(sc.nextLine());

                    System.out.println("here's your updated observations count for the bird " + data.get(i).getBirdName() + ": ");
                    data.get(i).getObservations(observerPlus);
                    System.out.println(data.get(i));    
                }
                break;
            }
        }   

        if (pass == 0) {
            System.out.println("your bird not found brother");
        }

        }

    @Override 
    public String toString() {
        return "The name of your bird be: " + name + " it's latin name be: " + latinName + " and youve seen it: " + observations + " times";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<birdnerd> data = new ArrayList<>();
        ArrayList<String> birdname = new ArrayList<>();

        int searchPurpose = 0; //if this is 0 search only prints else it adds to the observations

        while (true) {
            System.out.println("""
                    Type 1 for adding birds
                    2 for recording and printing observations
                    3 to print all birds
                    4 to print one bird of your choice
                    5 to quit
                    """);

            int option = Integer.valueOf(sc.nextLine());

            switch(option) {
                        
            case 1: 
                addBird(sc, data, birdname);
            
            case 2:
                Searcher(data, birdname, 1, 0, sc);

            case 3:
                System.out.println(data);

            case 4:
                Searcher(data, birdname, 0, 0, sc);

            case 5:
                break;
            }
        }
    }
}

