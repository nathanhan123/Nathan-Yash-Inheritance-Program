import java.util.Scanner;

public class Game {

    protected static int ticketCount = 100;
    protected static Scanner scanner = new Scanner(System.in);

    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";


    public static void main(String[] args) {
        Game game = new Game();
        game.start();
        while (true) {
            game.play();
        }
    }

    public void start() {
        System.out.println(BLUE + "Welcome to the Payout Palace Arcade! My name is DBG, and I will be your guide throughout your Arcade fun. My caretaker Nathan has kindly gifted you 100 TICKETS to enjoy yourself on this fine day! Where would you like to start?" + RESET);
    }

    public void play() {
        System.out.println("Current Ticket Count: " + ticketCount);
        System.out.println("Select a game (type number) or 'q' to quit:");
        System.out.println("1: Basketball (5 tickets)");
        System.out.println("2: Slot Machine (3 tickets)");
        System.out.println("3: Skee-Ball (8 tickets)");

        String choice = scanner.nextLine();

        if (choice.equals("q")) {
            System.out.println("Thanks for playing!");
            System.exit(0);
        }

        switch (choice) {
            case "1":
                if (ticketCount >= 5) {
                    ticketCount -= 5;
                    System.out.println("Playing Basketball!");
                    Basketball basketball = new Basketball();
                    basketball.play();
                } else {
                    System.out.println("Not enough tickets for Basketball.");
                    return;
                }
                break;
            case "2":
                if (ticketCount >= 3) {
                    ticketCount -= 3;
                    System.out.println("Spinning Slot Machine!");
                    Slot slot = new Slot();
                    slot.start();
                    slot.play();
                } else {
                    System.out.println("Not enough tickets for Slot Machine.");
                    return;
                }
                break;
            case "3":
                if (ticketCount >= 8) {
                    ticketCount -= 8;
                    System.out.println("Playing Skee-Ball!");
                    Skeeball skeeball = new Skeeball();
                    skeeball.play();
                } else {
                    System.out.println("Not enough tickets for Skee-Ball.");
                    return;
                }
                break;
            default:
                System.out.println(RED + "Invalid choice. Try again." + RESET);
        }
    }
}
