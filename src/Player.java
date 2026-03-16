public class Player {

   private String name;
   private String position;
   private int heartrate;
   private int collisionCount;
   private int km;
   private int avrTopSpeed;
   private int yCard;
   private int rCard;


    public Player(String name, String position, int heartrate, int collisionCount, int km, int avrTopSpeed, int yCard, int rCard) {
        this.name = name;
        this.position = position;
        this.heartrate = heartrate;
        this.collisionCount = collisionCount;
        this.km = km;
        this.avrTopSpeed = avrTopSpeed;
        this.yCard = yCard;
        this.rCard = rCard;
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

    public int getrCard() {
        return rCard;
    }

    public int getyCard() {
        return yCard;
    }

    public int getAvrTopSpeed() {
        return avrTopSpeed;
    }

    public int getKm() {
        return km;
    }

    public int getCollisionCount() {
        return collisionCount;
    }

    @Override
    public String toString() {
        //return "Player: " + name +","+ position + ", "+ heartrate;
        String s = "Player: "+ this.name;
        s += " (Position: "+ position + " &";
        s += " HeartRate: "+ heartrate;
        s += " CCount: "+ collisionCount;
        s+= " Km: "+ km;
        s+= " Top speed: "+avrTopSpeed;
        s+= " yellow card: "+ yCard;
        s+= " red card: "+ rCard+")\n";
        return s;
    }

}
