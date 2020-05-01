package doolhofgamemain;

import java.util.*;

/*
 * Project: Doolhofspel Mario Edition
 * Authors: Justin Ulsamer, Leonie Mostard, Quang Hang
 * Group: 3.1.4
 * Version: 2.3
 * Date: 5-4-2018
 */
public class Level_1 {

    private List<List<Integer>> veld = new ArrayList<List<Integer>>();

    public Level_1() {
        veld.add(Arrays.asList(1, 6, 0, 0, 0, 6, 0, 0, 0, 6));
        veld.add(Arrays.asList(0, 0, 0, 7, 0, 2, 0, 8, 6, 0));
        veld.add(Arrays.asList(0, 0, 0, 7, 0, 0, 0, 7, 8, 0));
        veld.add(Arrays.asList(0, 0, 0, 0, 6, 6, 6, 6, 6, 4));
        veld.add(Arrays.asList(6, 6, 6, 7, 0, 0, 0, 7, 0, 0));
        veld.add(Arrays.asList(0, 0, 0, 0, 0, 0, 6, 8, 8, 6));
        veld.add(Arrays.asList(0, 3, 0, 9, 8, 8, 9, 0, 0, 0));
        veld.add(Arrays.asList(0, 0, 0, 9, 8, 9, 0, 0, 0, 0));
        veld.add(Arrays.asList(0, 0, 0, 0, 0, 0, 6, 0, 0, 0));
        veld.add(Arrays.asList(0, 0, 0, 0, 0, 0, 6, 0, 0, 5));
    }
    
    //returned de level 1 array preset
    public List<List<Integer>> getArray() {
        return this.veld;
    }

}
