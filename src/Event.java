import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Event {
    public int eventID;
    public Monster monster;
    public int stuffID;
//    public Item item;
    public Player player;
    public Helper h = new Helper();

    public Event(int eventID,int stuffID,Player player){
        this.eventID = eventID;
        this.stuffID = stuffID;
        this.player = player;
        eval();
    }

    void eval(){
        if(this.eventID==1){
            fight();
        } else if (this.eventID == 2) {
            readLore();
        }
    }

    private void readLore() {
        String monsterFile = "./src/i" + this.stuffID + ".txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(monsterFile));
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();
                String[] txtArray = everything.split("\\.");

                h.printTitle(txtArray[0]);
                for (int i = 1; i < txtArray.length ; i++) {
                    h.printStuff(txtArray[i]);
                }

            } finally {
                br.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        h.waitForInput();
    }

    private void fight(){
    String monsterFile = "./src/m" + this.stuffID + ".txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(monsterFile));
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();
                String[] txtArray = everything.split("###");
                fight2(txtArray);

            } finally {
                br.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    void fight2(String[] args){
        h.printTitle(args[0]);
        h.waitForInput();
        h.printStuff(args[1]);
        int monsterStrength = Integer.parseInt(args[2].trim());
        int playerStrength = player.getStrength();
        if(monsterStrength<playerStrength){
            h.printStuff(args[3]);
        } else if (monsterStrength>playerStrength) {
            h.printStuff(args[4]);
            player.setLP((int)(playerStrength-monsterStrength));


        }
    }






}
