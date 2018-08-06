package game;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author carl
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int score = 0;
        String w = createWinningNums();

        System.out.println("Press 1 to play, you will be given 5 number combinations");

        int choice = in.nextInt();
        while (choice == 1) {
            switch (choice) {
                case 1:
                    items.clear();
                    w = createWinningNums();
                    System.out.println("------------------------------");
                    System.out.println("The number combination you needed to win: " + w);
                    for (String i : create()) {
                        items.add(i);
                    }

                    if (compare(items, w) == false) {
                        
                        System.out.println("You did not win, Try again?");
                        System.out.println("Your combinations = " + items);
                        System.out.println("Press 1 to play again");
                        choice = in.nextInt();
                    } else {
                        
                        System.out.println("Your combinations = " + items);

                        System.out.println("You win");
                        System.out.println("current score: " + getScore());
                        System.out.println("Press 1 to play again");
                        choice = in.nextInt();
                    }
                case 2:
                    break;

            }
        }

    }
    static int score = 0;

    public static List<String> create() {

        int numberOfTries = 5;
        int combinationLength = 3;

        List<String> items = new ArrayList<>();
        for (int j = 0; j < numberOfTries; j++) {
            String numfin = "";
            for (int i = 0; i < combinationLength; i++) {
                int num = ThreadLocalRandom.current().nextInt(1, 2 + 1);
                numfin += num;
            }
            items.add(numfin);
        }

        return items;

    }

    public static String createWinningNums() {
        String numfin = "";
        int combinationLength = 3;

        for (int i = 0; i < combinationLength; i++) {
            int num = ThreadLocalRandom.current().nextInt(1, 2 + 1);
            numfin += num;
        }
        return numfin;

    }

    public static Boolean compare(List list, String winning) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(winning)) {
                score++;
                return true;
            }
        }
        return false;

    }

    public static int getScore() {
        return score;
    }

}
