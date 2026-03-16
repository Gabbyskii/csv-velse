import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //arraylist sat i globaalt scope istedet for inde i metode parametre.
    static ArrayList<Player> teams;
    // erklæret Scanner udenfor main metoden og gjort static så den er accessible fra metoder
    static Scanner reader; // = new Scanner(System.in);
    static String header;

    static void main() {
        ArrayList<Player> team = new ArrayList<>();

        File file = new File("data/playerdata.csv");
        try {
            // fjernet scanner herfra: Scanner reader = new Scanner(file);

            reader = new Scanner(file);
            header = reader.nextLine(); // skipper header i filen

            while (reader.hasNextLine()) {
                String line = reader.nextLine(); // vi vil kun have: "Phillip", "hb", 168,
                String[] data = line.split(",");

                String name = data[0];
                String position = data[1].trim();
                int heartrate = Integer.parseInt(data[2].trim());
                int collision = Integer.parseInt(data[3].trim());
                int km = Integer.parseInt(data[4].trim());
                int speed = Integer.parseInt(data[5].trim());
                boolean yCard = Boolean.parseBoolean(data[6].trim());
                boolean rCard = Boolean.parseBoolean(data[7].trim());

                Player p = new Player(name, position, heartrate, collision,km,speed,yCard,rCard);
                team.add(p);

                System.out.println("\n===Team one===");
                /*team.get(0).setName("Mbappe");
                team.get(0).setPosition("Goalkeeper");
                team.get(0).setHeartrate(165);
                team.get(1).setPosition("hb");
                team.get(2).setPosition("Angriber");*/
                displayTeam(team);
                saveData(team);

            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }

    public static void displayTeam(ArrayList<Player> teams) {
        for (Player pl: teams) {
            System.out.println(pl);
        }
    }

    public static void saveData(ArrayList<Player> teams) {
        try {
            FileWriter fileWriter = new FileWriter("data/playerdata.csv");

            for (Player t: teams) {
                fileWriter.write(t.getName() + ", " + t.getPosition()
                        + " , "+ t.getHeartrate()+" , "+ t.getKm() +
                        " , "+ t.getAvrTopSpeed() + " , "
                        + t.getyCard() + " , "+ t.getrCard()
                        +" , "+ t.getCollisionCount()+" \n");
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void createPlayer(){
        TextUI ui = new TextUI();
        String name = ui.promptString("Hvad er spillerens navn?");

        teams.add(name, "" , 0 , 0 , 0 , false , false , 0 );

    }




}

