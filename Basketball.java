import java.util.Random;

public class Basketball extends Game {

    private Random random = new Random();
    private int score = 0;
    private int shots = 0;

    public void play() {
        System.out.println(BLUE + "Ready to get your inner LEBRON JAMES on?" + RESET);

        while (score < 21) {
            takeShot();
        }

        System.out.println("You scored 21 points in " + shots + " shots!");
        int reward;
        if (shots > 15) {
            reward = 3;
        } else if (shots > 9) {
            reward = 8;
        } else {
            reward = 15;
        }
        ticketCount += reward;
        System.out.println("You earned " + reward + " tickets. Total tickets: " + ticketCount);
    }

    private void takeShot() {
        System.out.println("Choose your shot:");
        System.out.println("1: 3-pointer");
        System.out.println("2: Layup");

        int move = -1;
        try {
            move = Integer.parseInt(scanner.nextLine().trim());
            if (move >2) {
                System.out.println(RED + "Invalid input. Try again." + RESET);
            }
        } catch (NumberFormatException e) {
            System.out.println(RED + "Invalid input. Try again." + RESET);
            return;
        }

        int chance = random.nextInt(10) + 1;

        if (move == 1 && chance >= 6) {
            System.out.println(GREEN + "Swish! +3 points." + RESET);
            score += 3;
        } else if (move == 2 && chance >= 4) {
            System.out.println(GREEN + "Layup made! +2 points." + RESET);
            score += 2;
        } else {
            System.out.println(RED + "Missed!" + RESET);
        }

        shots++;
        System.out.println("Score: " + score);
    }
}
