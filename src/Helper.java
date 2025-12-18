import java.util.Scanner;

public class Helper {
    public void cleco(){
        for (int i = 0; i < 100; i++) {
            System.out.println("");

        }
    }

    public void printTitle(String content){
        System.out.print("=======");
        System.out.print(content.trim());
        System.out.println("=======");
    }

    public  void printStuff(String content){
        System.out.println(content);
    }

    public String getName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("what is your name");
        String input = sc.nextLine();

        return input;
    }

    public int getDir(){
        printStuff("gib ein in welche richtung du willst");
        printStuff("UP,DOWN,LEFT,RIGHT");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toUpperCase();

        switch (input) {
            case "UP":
                return 0;
            case "DOWN":
                return 1;
            case "LEFT":
                return 2;
            case "RIGHT":
                return 3;
            default:
                printStuff("Ungültige Eingabe");
                return -1; // Fehlercode
        }
    }

    public void waitForInput(){
        System.out.println("Enter zum weitermachen");
        Scanner sc = new Scanner(System.in);
        String lol = sc.nextLine();
    }
}