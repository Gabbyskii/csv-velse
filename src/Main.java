import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // arraylist sat i globaalt scope istedet for inde i metode parametre
    static ArrayList<Player> teams;
    // erklæret Scanner udenfor main metoden og gjort static så den er accessible fra metoder
    static Scanner reader; // = new Scanner(System.in);
    static String header;
    static TextUI ui = new TextUI();

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

                Player p = new Player(name, position, heartrate, collision, km, speed, yCard, rCard);
                team.add(p);
            }
            reader.close();


            System.out.println("\n===Team one===");
               displayTeam(team);

            boolean continueReg = true;
            while (continueReg) {
                String input = ui.promptString("Vil du oprette en spiller til? y/n");
                if (input.equals("y")) {
                    createPlayer();
                } else {
                    continueReg = false;
                }
            }
            saveData(team);

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

            for (Player t : teams) {
                fileWriter.write(
                        t.getName() + "," +
                        t.getPosition() + "," +
                        t.getHeartrate() + "," +
                        t.getCollisionCount() + "," +
                        t.getKm() + "," +
                        t.getAvrTopSpeed() + "," +
                        t.getyCard() + "," +
                        t.getrCard() + "\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void createPlayer(){
        String name = ui.promptString("Hvad er spillerens navn?");

        /*Player p = new Player(name, position, heartrate, collision, km, speed, yCard, rCard);
        teams.add(p);*/
        // obs: bruger den globale "teams", ikke den lokale "team" i main
    }




}

