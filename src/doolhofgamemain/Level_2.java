package doolhofgamemain;

import java.util.*;

/*
 * Project: Doolhofspel Mario Edition
 * Authors: Justin Ulsamer, Leonie Mostard, Quang Hang
 * Group: 3.1.4
 * Version: 2.3
 * Date: 5-4-2018
 */
public class Level_2 {

    private List<List<Integer>> veld = new ArrayList<List<Integer>>();

    public Level_2() {
        veld.add(Arrays.asList(1, 0, 6, 0, 0, 7, 7, 0, 0, 0));
        veld.add(Arrays.asList(6, 0, 0, 0, 0, 0, 7, 9, 3, 0));
        veld.add(Arrays.asList(0, 0, 0, 6, 0, 7, 9, 0, 0, 0));
        veld.add(Arrays.asList(7, 7, 9, 9, 0, 0, 9, 0, 0, 0));
        veld.add(Arrays.asList(8, 8, 9, 7, 0, 0, 6, 6, 6, 6));
        veld.add(Arrays.asList(6, 6, 6, 0, 0, 7, 0, 6, 0, 0));
        veld.add(Arrays.asList(0, 0, 0, 0, 0, 9, 0, 6, 0, 0));
        veld.add(Arrays.asList(0, 0, 8, 8, 8, 9, 7, 9, 0, 0));
        veld.add(Arrays.asList(2, 0, 8, 4, 0, 9, 6, 6, 0, 0));
        veld.add(Arrays.asList(0, 0, 8, 0, 0, 9, 9, 9, 6, 5));
    }

    //returned de level 2 array preset
    public List<List<Integer>> getArray() {
        return this.veld;
    }

}
