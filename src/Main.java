import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void main() {
        ArrayList<Player> team = new ArrayList<>();

        File file = new File("data/playerdata.csv");
        try {
            Scanner reader = new Scanner(file);

            reader.nextLine(); // skipper header i filen
            while (reader.hasNextLine()){
                String line = reader.nextLine(); // vi vil kun have: "Phillip", "hb", 168,
                String[] data = line.split(",");

                String name = data[0];
                String position = data[1];
                int heartrate = Integer.parseInt(data[2].trim());

                Player p = new Player(name, position, heartrate);
                team.add(p);

                System.out.println("===Team one===");
                displayTeam(team);

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }


    public static void displayTeam(ArrayList<Player>teams){
        for (Player pl: teams){
            System.out.println(pl);
        }
    }


}
