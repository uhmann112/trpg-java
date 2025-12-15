public class Player {

    public String name;
    public int strength =10;
    public int LP =100;
    public int gold=0;

    public Player(String name){
        this.name=name;

    }

    public void setLP(int modifier){
       this.LP+=modifier;
    }
    public void setStrenght(int modifier){
        this.strength +=modifier;
    }

    public int getLP() {
        return LP;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public void dead(){

    }
}
