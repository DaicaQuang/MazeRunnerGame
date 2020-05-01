package doolhofgamemain;

import java.util.*;
import java.util.Random;

/*
 * Project: Doolhofspel Mario Edition
 * Authors: Justin Ulsamer, Leonie Mostard, Quang Hang
 * Group: 3.1.4
 * Version: 2.3
 * Date: 5-4-2018
 */
public class RandomLevel {

    private List<List<Integer>> veld = new ArrayList<List<Integer>>();

    public RandomLevel() {
        veld.add(Arrays.asList(1, random(), random(), random(), random(), random(), random(), random(), random(), random()));
        veld.add(Arrays.asList(random(), random(), random(), random(), random(), random(), random(), random(), random(), random()));
        veld.add(Arrays.asList(random(), random(), random(), random(), random(), random(), random(), random(), random(), random()));
        veld.add(Arrays.asList(random(), random(), random(), random(), random(), random(), random(), random(), random(), random()));
        veld.add(Arrays.asList(random(), random(), random(), random(), random(), random(), random(), random(), random(), random()));
        veld.add(Arrays.asList(random(), random(), random(), random(), random(), random(), random(), random(), random(), random()));
        veld.add(Arrays.asList(random(), random(), random(), random(), random(), random(), random(), random(), random(), random()));
        veld.add(Arrays.asList(random(), random(), random(), random(), random(), random(), random(), random(), random(), random()));
        veld.add(Arrays.asList(random(), random(), random(), random(), random(), random(), random(), random(), random(), random()));
        veld.add(Arrays.asList(random(), random(), random(), random(), random(), random(), random(), random(), random(), 5));
    }

    //maakt een random getal aan dat niet een speler of een eindveld kan zijn
    public int random() {
        Random rand = new Random();
        int random = rand.nextInt(100) + 0;
        while (random == 5 || random == 1){
            random = rand.nextInt(100) + 0;
        }
        if(random >= 0 && random <35){
            random = 0;
        }else if (random >= 35  && random < 40){
            random = 2;
        }else if (random >= 40  && random < 45){
            random = 3;
        }else if (random >= 45  && random < 50){
            random = 4;
        }else if (random >= 50  && random < 70){
            random = 6;
        }else if (random >= 70  && random < 80){
            random = 7;
        }else if (random >= 80  && random < 90){
            random = 8;
        }else if (random >= 90  && random <= 100){
            random = 9;
        }
        return random;
    }

    //geeft de array mee
    public List<List<Integer>> getArray() {
        return this.veld;
    }

}
