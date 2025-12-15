

int eventID =0;
boolean playing = true;
public Room room;
public Player player;
public Helper h=new Helper();
public int roomid =1;

void main() {






    String playerName = h.getName();
    player = new Player(playerName);
    h.printStuff(player.name);

    gameLoop();
}

public void gameLoop() {
    while (playing) {
        showPlayer();
        room = new Room(roomid);
        room.init();
        room.showInitialState();
        h.waitForInput();
        room.makeChoice();
        checkForEvent();
        checkForEvent();

    }
}
void checkForEvent(){
    if(room.isEvent==true ) {
        eventID = room.eventID;
        if (eventID == 1) {
            Event event = new Event(eventID,room.monsterIndex,player);
        } else if (eventID == 3) {
            roomid = room.NEXT;

        } else if (eventID == 2) {
            Event event = new Event(eventID,room.itemIndex,player);

        }
    }


}

void showPlayer(){
    h.printTitle("player:");
    h.printTitle(player.name);
    h.printStuff("strength: "+player.getStrength());
    h.printStuff("LP: "+player.getLP());
    h.printStuff("gold: "+player.getGold());

    h.waitForInput();
}