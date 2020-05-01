package doolhofgamemain;

import java.util.*;

/*
 * Project: Doolhofspel Mario Edition
 * Authors: Justin Ulsamer, Leonie Mostard, Quang Hang
 * Group: 3.1.4
 * Version: 2.3
 * Date: 5-4-2018
 */
public class Level_3 {

    private List<List<Integer>> veld = new ArrayList<List<Integer>>();

    public Level_3() {
        veld.add(Arrays.asList(1, 6, 0, 0, 0, 6, 0, 0, 0, 6));
        veld.add(Arrays.asList(0, 0, 0, 6, 0, 6, 0, 6, 0, 0));
        veld.add(Arrays.asList(6, 0, 6, 6, 2, 6, 0, 6, 0, 6));
        veld.add(Arrays.asList(0, 0, 0, 0, 0, 7, 0, 6, 0, 3));
        veld.add(Arrays.asList(7, 6, 7, 7, 6, 0, 0, 8, 0, 6));
        veld.add(Arrays.asList(0, 0, 0, 0, 6, 2, 6, 6, 6, 6));
        veld.add(Arrays.asList(0, 0, 3, 0, 0, 6, 0, 6, 0, 0));
        veld.add(Arrays.asList(0, 8, 4, 0, 9, 0, 0, 9, 0, 6));
        veld.add(Arrays.asList(0, 0, 0, 0, 0, 8, 0, 9, 0, 6));
        veld.add(Arrays.asList(6, 3, 0, 6, 6, 6, 0, 9, 0, 5));
    }

    //returned de level 3 array preset
    public List<List<Integer>> getArray() {
        return this.veld;
    }

}
