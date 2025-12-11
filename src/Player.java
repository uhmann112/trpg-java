public class Player {

    public String name;
    public int strength;
    public int LP;

    public Player(String name){
        this.name=name;

    }

    public void setLP(int modifier){
        if(modifier<0){
            if((this.LP-modifier)<=0){
                sendSignal("dedge");
            }
        }else{
            this.LP = this.LP + modifier;
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void sendSignal(String status){
        //TODO: signale senden an den MANAGER oder die MAINKLASSE
    }
}
