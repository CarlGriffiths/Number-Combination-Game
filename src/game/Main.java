
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

        String w = createWinningNums();
        System.out.println("The number combination you need to win: " + w);
        System.out.println("Press 1 to play");
        
        for(String i: create()){
            items.add(i);
        }
        System.out.println(items);
        if (compare(items, w) >=0) {
            System.out.println("You win");
            System.out.println(compare(items, w));
        }
        else{
            System.out.println("You did not win, Try again?");
        }
       

        //System.out.println(items.get(0));
        //System.out.println(compare(items, w));

        //System.out.println(create());
    }

    public static List<String> create() {

        List<String> items = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            String numfin = "";
            for (int i = 0; i < 3; i++) {
                int num = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                numfin += num;
            }
            items.add(numfin);
        }

        return items;

    }

    public static String createWinningNums() {
        String numfin = "";

        for (int i = 0; i < 3; i++) {
            int num = ThreadLocalRandom.current().nextInt(1, 4 + 1);
            numfin += num;
        }
        return numfin;

    }

    public static int compare(List list, String winning) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(winning)) {
                return i;
            }
        }

        return -1;
    }
}