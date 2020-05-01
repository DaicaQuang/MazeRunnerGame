package doolhofgamemain;

import java.util.*;

/*
 * Project: Doolhofspel Mario Edition
 * Authors: Justin Ulsamer, Leonie Mostard, Quang Hang
 * Group: 3.1.4
 * Version: 2.3
 * Date: 5-4-2018
 */
public class coopLevel {

    private List<List<Integer>> veld = new ArrayList<List<Integer>>();

    public coopLevel() {
        veld.add(Arrays.asList(1, 6, 2, 6, 6, 6, 0, 0, 6, 4));
        veld.add(Arrays.asList(0, 6, 0, 8, 7, 8, 0, 0, 6, 7));
        veld.add(Arrays.asList(0, 0, 0, 6, 6, 6, 0, 0, 0, 0));
        veld.add(Arrays.asList(0, 0, 0, 3, 6, 0, 0, 6, 0, 0));
        veld.add(Arrays.asList(6, 6, 6, 6, 6, 0, 6, 6, 6, 6));
        veld.add(Arrays.asList(3, 0, 0, 0, 6, 0, 0, 6, 11, 6));
        veld.add(Arrays.asList(6, 6, 6, 0, 6, 0, 0, 0, 0, 6));
        veld.add(Arrays.asList(0, 0, 6, 0, 8, 0, 0, 6, 9, 6));
        veld.add(Arrays.asList(6, 0, 6, 0, 6, 0, 0, 6, 5, 6));
        veld.add(Arrays.asList(10, 0, 0, 0, 6, 6, 6, 6, 6, 6));
    }

    //returned de level 1 array preset
    public List<List<Integer>> getArray() {
        return this.veld;
    }

}
