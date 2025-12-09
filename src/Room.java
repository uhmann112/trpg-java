import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Room {
    public int ID;
    public String NAME;
    private boolean hasGold;
    private int gold;
    private boolean hasMonster;
    private Monster monster;
    private int previous;
    public String description;
    public String[] optionDescriprions;
    private Helper h = new Helper();

    public Room(int idNumber){
        this.ID = idNumber;
    }

    public void init(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/"+this.ID+".txt" ));
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

    void setupParams(String[] arr){
        this.NAME = arr[0];
        this.description = arr[1];
        if(arr[2].contains("!")){
            this.hasGold =false;
            this.gold =0;
        }else{
            this.hasGold =true;
            this.gold = Integer.parseInt(arr[3].trim());
        }
        if(arr[4].contains("!")){
            this.hasMonster =false;
            this.monster=null;
        }else{
            this.hasMonster =true;
            int monsterIndex = Integer.parseInt(arr[5].trim());
            this.monster = new Monster(monsterIndex);
        }
        String[] temp = arr[6].split("/");
        this.optionDescriprions = new String[temp.length];
        for (int i = 0; i < temp.length-1; i++) {
            this.optionDescriprions[i]=temp[i];
        }
    }

    public void showInitialState(){
        h.cleco();
        h.printTitle(this.NAME);
        h.printTitle(this.description);
    }
}