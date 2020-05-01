package doolhofgamemain;

import java.util.ArrayList;
import java.util.List;

/*
 * Project: Doolhofspel Mario Edition
 * Authors: Justin Ulsamer, Leonie Mostard, Quang Hang
 * Group: 3.1.4
 * Version: 2.3
 * Date: 5-4-2018
 */
public class Levels {

    private int levelcode;
    private Level_1 level1;
    private Level_2 level2;
    private Level_3 level3;
    private RandomLevel randomLevel;
    private coopLevel coopLevel;
    private List<List<Integer>> Speelveld; 

    public Levels(int level) {
        this.levelcode = level;
    }
    
    //stuurt de juiste array mee aan de gegeven level code
    public List<List<Integer>> getLevel() {
        if (this.levelcode == 1) {
            this.level1 = new Level_1();
            this.Speelveld = level1.getArray();
        }
        if (this.levelcode == 2) {
            this.level2 = new Level_2();
            this.Speelveld = level2.getArray();
        }
        if (this.levelcode == 3) {
            this.level3 = new Level_3();
            this.Speelveld = level3.getArray();
        }
        if (this.levelcode == 4) {
            this.randomLevel = new RandomLevel();
            this.Speelveld = randomLevel.getArray();
        }
        if (this.levelcode == 5) {
            this.coopLevel = new coopLevel();
            this.Speelveld = coopLevel.getArray();
        }
        return Speelveld;
    }
    

}
