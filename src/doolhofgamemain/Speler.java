package doolhofgamemain;

import java.awt.event.*;
import javax.swing.*;

/*
 * Project: Doolhofspel Mario Edition
 * Authors: Justin Ulsamer, Leonie Mostard, Quang Hang
 * Group: 3.1.4
 * Version: 2.3
 * Date: 5-4-2018
 */
public class Speler {

    private SpeelVeld speelveld;
    private speler1 speler1;
    private speler2 speler2;

    public Speler(SpeelVeld speelveld) {
        this.speelveld = speelveld;
        this.speler1 = new speler1(this);
        this.speler2 = new speler2(this);
    }

    //stuurt GUIspeler door Speelveld
    public GUIspeler GUIspeler1() {
        return speler1.GUIspeler();
    }

    //stuurt GUIspeler door Speelveld
    public GUIspeler2 GUIspeler2() {
        return speler2.GUIspeler();
    }

    //wordt gecheckt of de speler uberhaupt een sleutel heeft voor kanlopen/ loopbarricade
    public boolean heeftSleutel(int speler) {
        if (speler == 1) {
            return speler1.heeftSleutel();
        } else {
            return speler2.heeftSleutel();
        }
    }

    //verandert de X en Y en verandert de benodigde objecten in speelveld array, het tekent daarna panel opnieuw
    public void lopen(int x, int y, int oldx, int oldy, int vorigeplek, boolean eindveld, int speler) {
        setStaatOpSleutel(false, 0, speler);
        if (speler == 1) {
            if (speler1.getEindveld()) {
                speler1.setEindveld(false);
            }
        } else {
            if (speler2.getEindveld()) {
                speler2.setEindveld(false);
            }
        }
        if (speelveld.kanLopen(x, y, speler) == true) {
            speelveld.setObject(oldx, oldy, vorigeplek);
            if (speler == 1) {
                speler1.setVorigePlek(speelveld.getObject(x, y));
                speelveld.setObject(x, y, 1);
            } else {
                speler2.setVorigePlek(speelveld.getObject(x, y));
                speelveld.setObject(x, y, 10);
            }
            speelveld.repaintpanel();
            speelveld.paintcomponent();
            if (speelveld.getLevel() == 5) {
                if (speler1.getEindveld() && speler2.getEindveld()) {
                    speelveld.einde();
                }
            } else {
                if (speler1.getEindveld()) {
                    speelveld.einde();
                }
            }
        } else {
            System.out.println("You can not go that way");
            if (speler == 1) {
                speler1.resetXY();
            } else {
                speler2.resetXY();
            }
        }
    }

    //stuurt aan wat er moet gebeuren bij welke invoer
    public void invoerSpeler(int i) {
        if (i >= 1 && i <= 6) {
            speler1.invoerSpeler(i);
        } else {
            speler2.invoerSpeler(i);
        }
    }

    //als de speler op een sleutel staat moet de boolean op true worden gezet zodat e ingedrukt kan worden
    public void setStaatOpSleutel(boolean staatOpSleutel, int i, int speler) {
        if (speler == 1) {
            speler1.setStaatOpSleutel(staatOpSleutel, i);
        } else {
            speler2.setStaatOpSleutel(staatOpSleutel, i);
        }
    }

    //kijk welke sleutel pincode in spelers zak zit
    public int getSleutel(int speler) {
        if (speler == 1) {
            return speler1.getSleutel();
        } else {
            return speler2.getSleutel();
        }
    }

    public int setSleutelInventory(int sleutelcode) {
        return speelveld.setSleutelInventory(sleutelcode);
    }

    //reset alle variabelen in speler
    public void resetSpeler() {
        speler1.resetSpeler();
        speler2.resetSpeler();
    }

    //zet eindveld in speler1
    public void setEindveld1(int speler, boolean i) {
        if (speler == 1) {
            speler1.setEindveld(i);
        }
    }

    //zet eindveld in speler2
    public void setEindveld2(int speler, boolean i) {
        if (speler == 2) {
            speler2.setEindveld(i);
        }
    }

    //krijgt en geeft eindveld in speler1
    public boolean getEindveld1() {
        return speler1.getEindveld();
    }

    //krijgt en geeft eindveld in speler2
    public boolean getEindveld2() {
        return speler2.getEindveld();
    }
}
