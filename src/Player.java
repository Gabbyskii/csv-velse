public class Player {

   private String name;
   private String position;
   private int heartrate;

    public Player(String name, String position, int heartrate) {
        this.name = name;
        this.position = position;
        this.heartrate = heartrate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(int heartrate) {
        this.heartrate = heartrate;
    }


    @Override
    public String toString() {
        return "Player: " + name + position + " "+ heartrate;
    }

}
