import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Room {
    public int NEXT;
    public int ID;
    public String NAME;
    private boolean hasGold;
    private int gold;
    private boolean hasMonster;
    private int previous;
    public String description;
    public String[] optionDescriptions;
    private Helper h = new Helper();
    public int choice = 0;
    public boolean isEvent = false;
    public int eventID;
    public int monsterIndex;
    public int itemIndex;

    public Room(int idNumber) {
        this.ID = idNumber;
    }

    public void init() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/" + this.ID + ".txt"));
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
                setupParams(txtArray);
            } finally {
                br.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void setupParams(String[] arr) {
        this.NAME = arr[0];
        this.description = arr[1];
        if (arr[2].contains("!")) {
            this.hasGold = false;
            this.gold = 0;
        } else {
            this.hasGold = true;
            this.gold = Integer.parseInt(arr[3].trim());
        }
        if (arr[4].contains("!")) {
            this.hasMonster = false;
        } else {
            this.hasMonster = true;
            monsterIndex = Integer.parseInt(arr[5].trim());
        }
        String[] temp = arr[6].split("/");
        this.optionDescriptions = new String[temp.length];
        for (int i = 0; i < temp.length; i++) {
            this.optionDescriptions[i] = temp[i];
        }
        this.NEXT=Integer.parseInt(arr[8].trim());
        this.itemIndex = Integer.parseInt(arr[7].trim());
    }

    public void showInitialState() {
        h.cleco();
        h.printTitle(this.NAME);
        h.printStuff(this.description);


    }

    public void makeChoice() {
        choice = h.getDir();
        h.printStuff(this.optionDescriptions[choice]);
        checkForEvent(this.optionDescriptions[choice]);
    }


    public void checkForEvent(String text) {
        if (text.contains("EVENT1")) {
            this.isEvent = true;
            this.eventID = 1;
        } else if (text.contains("EVENT2")) {
            this.isEvent = true;
            this.eventID = 2;
        }else if (text.contains("EVENT3")) {
            this.isEvent = true;
            this.eventID = 3;
        }
    }
}




