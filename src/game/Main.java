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
        String score = "";

        String w = createWinningNums();
        System.out.println("The number combination you need to win: " + w);
        System.out.println("Press 1 to play, you will be given 5 number combinations");

        for (String i : create()) {
            items.add(i);
        }
        System.out.println("Your combinations = " + items);
        /*if (compare(items, w) >= 0) {
         System.out.println("You win");
         System.out.println(compare(items, w));
         } else {
         System.out.println("You did not win, Try again?");
         }*/

        if (compare(items, w).isEmpty()) {
            System.out.println("You did not win, Try again?");
        }
        else {
             score += compare(items, w).toString();
             System.out.println("You win");
             System.out.println("score: " + score);
        }

        //System.out.println(items.get(0));
        //System.out.println(compare(items, w));
        //System.out.println(create());
    }

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

    public static Collection compare(List list, String winning) {
        Map<String, Integer> hmap = new HashMap<>();
        int score = 1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(winning) && hmap.containsKey(winning)) {
                hmap.put(winning, score = score + 1);
            } else if (list.get(i).equals(winning) && hmap.containsKey(winning) == false) {
                hmap.put(winning, score);
            }
        }

        return hmap.values();
    }
}
