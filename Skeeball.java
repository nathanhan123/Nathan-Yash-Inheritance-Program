import java.util.Random;

public class Skeeball extends Game {

    private int totalPoints = 0;
    private int tosses = 5;
    private Random random = new Random();

    public void play() {
        System.out.println(BLUE + "Hey there Skee - buddy! In this game, you will be given 5 shots to shoot a ball into a selected hole of" + "\n" + "your choice: the 10 point hole, the 15 point hole, and the 25 point hole." + "\n" +  "For each shot, you will be asked to input the number for the corresponding hole you wish to throw at." + "\n" + "At the end of the game, your total points will be calculated by adding up the scores of all of the" + "\n" + "holes you made your ball into. The amount of tickets you get will be determined by your total amount of" + "\n" + "points at the end of the game." + RESET);

        while (tosses > 0) {
            System.out.println("Toss #" + (6 - tosses));
            System.out.println("Choose a hole: [1]: 10 points, [2]: 15 points, [3]: 25 points: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
                if(choice > 3) {
                    System.out.println(RED + "Invalid input. Try again." + RESET);
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + "Invalid input. Try again." + RESET);
                continue;
            }
           
            int chance = random.nextInt(100) + 1;
            int points = 0;

            if (choice == 1 && chance <= 60) 
                points = 10;
            else if (choice == 2 && chance <= 35) 
                points = 15;
            else if (choice == 3 && chance <= 20) 
                points = 25;

            if (points > 0) {
                totalPoints += points;
                System.out.println(GREEN + "Nice! You scored " + points + " points." + RESET);
            } else {
                System.out.println(RED + "Missed!" + RESET);
            }

            tosses--;
        }

        int ticketsEarned = totalPoints / 3;
        ticketCount += ticketsEarned;
        System.out.println("Game over! You scored " + totalPoints + " points and earned " + ticketsEarned + " tickets.");
        System.out.println("Total tickets: " + ticketCount);
    }
}
