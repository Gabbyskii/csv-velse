import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Player> team;
    static Scanner reader;
    static String header;
    static TextUI ui = new TextUI();

    static void main() {
        ArrayList<Player> team = new ArrayList<>();

        File file = new File("data/playerdata.csv");
        try {
            reader = new Scanner(file);
            //header = reader.nextLine();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] data = line.split(",");

                String name = data[0];
                String position = data[1].trim();
                int heartrate = Integer.parseInt(data[2].trim());
                int collision = Integer.parseInt(data[3].trim());
                int km = Integer.parseInt(data[4].trim());
                boolean yCard = Boolean.parseBoolean(data[5].trim());
                boolean rCard = Boolean.parseBoolean(data[6].trim());
                int speed = Integer.parseInt(data[7].trim());

                Player p = new Player(name, position, heartrate, collision, km, speed,yCard, rCard);
                team.add(p);
            }
            reader.close();

            System.out.println("\n===Team one===");
            displayTeam(team);

            boolean continueReg = true;
            while (continueReg) {
                String input = ui.promptString("Vil du oprette en spiller til? y/n");
                if (input.equals("y")) {
                    createPlayer(team);
                } else {
                    continueReg = false;
                }
            }
            saveData(team);
            displayTeam(team);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void displayTeam(ArrayList<Player> teams) {
        for (Player pl : teams) {
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
                                t.getAvrTopSpeed() +
                                t.getyCard() + "," +
                                t.getrCard() + "\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createPlayer(ArrayList<Player> team) {
        String name = ui.promptString("Hvad er spillerens navn?");
        String position = ui.promptString("Hvad er spillerens position?");
        int heartRate = ui.promptInt("Hvad er spillerens heartrate?");
        int colCount = ui.promptInt("Hvad er spillerens collision count?");
        int km = ui.promptInt("Hvad er spillerens hastighed i km?");
        int topSpeed = ui.promptInt("Hvad er spillerens average top hastighed?");
        boolean yCard = ui.promptBoolean("Har spilleren gult kort?");
        boolean rCard = ui.promptBoolean("Har spilleren rødt kort?");

        Player p = new Player(name, position, heartRate, colCount, km, topSpeed, yCard, rCard);
        team.add(p);
    }
}