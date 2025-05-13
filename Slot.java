import java.util.Random;

public class Slot extends Game {

    private int cost = 3;
    private Random random = new Random();

    public void start() {
        System.out.println(BLUE + "Ready to crank that machine? Each spin at our signature slot machine - THE DEBT CREATOR - will cost you three tickets, and you will have the chance to win big tickets at Payout Palace." + RESET);
        System.out.println("Press 's' to crank the machine!");
        String output = scanner.nextLine().trim();
        while (true) {
            if (output.equals("s")) {
                if (ticketCount >= cost) {
                        ticketCount -= cost;
                        break;
                } else {
                        System.out.println(RED + "Not enough tickets to spin." + RESET);
                        return;
                }
            }
            if(!output.equals("s")) {
                System.out.println(RED + "Invalid input. Try again." + RESET);
                output = scanner.nextLine().trim();
            }
        }
    }
    
    public void play() {
        double result = random.nextDouble();

        if (result < 0.02) {
            ticketCount += 75;
            System.out.println(GREEN + "JACKPOT! You won 75 tickets!" + RESET);
        } else if (result < 0.06) {
            ticketCount += 20;
            System.out.println(GREEN + "Nice! You won 20 tickets!" + RESET);
        } else if (result < 0.21) {
            ticketCount += 8;
            System.out.println(GREEN + "You won 8 tickets!" + RESET);
        } else {
            System.out.println(RED + "No luck this time." + RESET);
        }

        System.out.println("Tickets: " + ticketCount);
        System.out.println(BLUE + "Press 's' to spin again or 'q' to quit." + RESET);

        while (true) {
            String choice = scanner.nextLine().trim();
            if (choice.equals("q")) {
                break;
            } else if (choice.equals("s")) {
                if (ticketCount >= cost) {
                    ticketCount -= cost;
                    play();
                    break;
                } else {
                    System.out.println(RED + "Not enough tickets to spin again." + RESET);
                    break;
                }
            } else {
                System.out.println(RED + "Invalid input. Try again." + RESET);
            }
        }
    }
}
