package doolhofgamemain;

import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;

/*
 * Project: Doolhofspel Mario Edition
 * Authors: Justin Ulsamer, Leonie Mostard, Quang Hang
 * Group: 3.1.4
 * Version: 2.3
 * Date: 5-4-2018
 */
public class SpeelVeld extends JPanel {

    private Menu Menu;
    private Speler speler;
    private List<List<Integer>> Speelveld;
    private List<List<Integer>> BackupVeld;
    private Sleutel sleutel;
    private Blok blok;
    private Barricade barricade;
    private Eindveld eindveld;
    private Eindveld2 eindveld2;
    private Muur muur;
    private Levels LevelMenu;
    private int level;
    private int Xspeler;
    private int Yspeler;

    public SpeelVeld(Menu Menu) {
        this.Menu = Menu;
        this.muur = new Muur();
        this.blok = new Blok();
        this.sleutel = new Sleutel();
        this.barricade = new Barricade();
        this.eindveld = new Eindveld();
        this.eindveld2 = new Eindveld2();
        this.speler = new Speler(this);
        this.BackupVeld = new ArrayList<List<Integer>>();
    }

    //Neemt level code over van menu
    public void setLevel(int level) {
        this.level = level;
    }

    //activeert het pauzemenu
    public void ESC() {
        Menu.pauze();
    }

    //Neemt de X en Y over van speler
    public void setXY(int x, int y) {
        this.Xspeler = x;
        this.Yspeler = y;
    }

    //Checkt met de veranderde X en Y of de speler naar de gewenste plek kan lopen
    public boolean kanLopen(int x, int y, int speler) {
        setXY(x, y);
        if (Xspeler >= 0 && Xspeler <= 9 && Yspeler >= 0 && Yspeler <= 9) {
            if (getObject(Xspeler, Yspeler) == 0) {
                // blok
                return true;
            } else if (getObject(Xspeler, Yspeler) == 1 || getObject(Xspeler, Yspeler) == 10) {
                //speler
                return false;
            } else if (getObject(Xspeler, Yspeler) == 2) {
                // sleutel1
                return loopSleutel(1, speler);
            } else if (getObject(Xspeler, Yspeler) == 3) {
                // sleutel2
                return loopSleutel(2, speler);
            } else if (getObject(Xspeler, Yspeler) == 4) {
                // sleutel3
                return loopSleutel(3, speler);
            } else if (getObject(Xspeler, Yspeler) == 5) {
                // eindveld
                return loopEindveld1(speler);
            } else if (getObject(Xspeler, Yspeler) == 6) {
                // muur
                return false;
            } else if (getObject(Xspeler, Yspeler) == 7) {
                // barricade 1
                return loopBarricade(1, speler);
            } else if (getObject(Xspeler, Yspeler) == 8) {
                // barricade 2
                return loopBarricade(2, speler);
            } else if (getObject(Xspeler, Yspeler) == 9) {
                // barricade 3
                return loopBarricade(3, speler);
            } else if (getObject(Xspeler, Yspeler) == 10) {
                return false;
            } else {
                // eindveld
                return loopEindveld2(speler);
            }
        } else {
            return false;
        }
    }

    //Neemt de speelveld Array over vanaf Levels en vult de backup
    public void vulArray() {
        for (int i = 0; i < 10; i++) {
            BackupVeld.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        }
        this.LevelMenu = new Levels(this.level);
        this.Speelveld = LevelMenu.getLevel();
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                BackupVeld.get(y).set(x, getObject(x, y));
            }
        }
    }

    //reset de speelveld Array naar die van backup
    public void vulVanafBackup() {
        for (int i = 0; i < 10; i++) {
            Speelveld.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        }
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                setObject(x, y, BackupVeld.get(y).get(x));
            }
        }
    }

    //vanaf Kanlopen wordt dit aangeroepen als de speler tegen een sleutel aan loopt
    public boolean loopSleutel(int i, int speler) {
        this.speler.setStaatOpSleutel(true, i, speler);
        return true;
    }

    //vanaf Kanlopen wordt dit aangeroepen als de speler tegen een barricade aan loopt
    public boolean loopBarricade(int i, int speler) {
        if (this.speler.heeftSleutel(speler) == true) {
            if (this.speler.getSleutel(speler) == barricade.getPincode(i)) {
                //open barricade 
                setObject(Xspeler, Yspeler, 0);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    //vanaf Kanlopen wordt dit aangeroepen als de speler tegen het eindveld aan loopt
    public boolean loopEindveld1(int speler) {
        this.speler.setEindveld1(speler, true);
        return true;
    }

    public boolean loopEindveld2(int speler) {
        this.speler.setEindveld2(speler, true);
        return true;
    }

    //wordt gebruikt om te kijken wat voor object in de array op plek x en y staat
    public int getObject(int x, int y) {
        return Speelveld.get(y).get(x);
    }

    //wordt gebruikt om in de array objecten te veranderen
    public void setObject(int x, int y, int object) {
        Speelveld.get(y).set(x, object);
    }

    //reset het speelveld en speler
    public void reset() {
        Speelveld = new ArrayList<List<Integer>>();
        speler.resetSpeler();
        this.removeAll();
    }

    //maakt de panel klaar voor een nieuw paint
    public void repaintpanel() {
        removeAll();
        invalidate();
        validate();
    }

    //maakt de sleutel pincode aan met de pin die hij krijgt
    public void setSleutelLabel(int pin) {
        this.sleutel = new Sleutel();
        sleutel.setSleutelPin(pin);
    }

    //maakt de barricade pincode aan met de pin die hij krijgt.
    public void setBarricadeLabel(int pin) {
        this.barricade = new Barricade();
        barricade.setPin(pin);
    }

    //geeft de sleutel pin vanuit sleutel door aan speler
    public int setSleutelInventory(int i) {
        return sleutel.getPincode(i);
    }

    //tekent het speelveld vanuit de array
    public void paintcomponent() {
        //draw from array
        setLayout(new GridLayout(0, 10));
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (Speelveld.get(y).get(x) == 0) {
                    this.blok = new Blok();
                    blok.paintComponent();
                    add(blok);
                } else if (Speelveld.get(y).get(x) == 1) {
                    add(speler.GUIspeler1());
                } else if (Speelveld.get(y).get(x) == 2) {
                    setSleutelLabel(1);
                    sleutel.paintComponent();
                    add(sleutel);
                } else if (Speelveld.get(y).get(x) == 3) {
                    setSleutelLabel(2);
                    sleutel.paintComponent();
                    add(sleutel);
                } else if (Speelveld.get(y).get(x) == 4) {
                    setSleutelLabel(3);
                    sleutel.paintComponent();
                    add(sleutel);
                } else if (Speelveld.get(y).get(x) == 5) {
                    this.eindveld = new Eindveld();
                    eindveld.paintComponent();
                    add(eindveld);
                } else if (Speelveld.get(y).get(x) == 6) {
                    this.muur = new Muur();
                    muur.paintComponent();
                    add(muur);
                } else if (Speelveld.get(y).get(x) == 7) {
                    setBarricadeLabel(1);
                    barricade.paintComponent();
                    add(barricade);
                } else if (Speelveld.get(y).get(x) == 8) {
                    setBarricadeLabel(2);
                    barricade.paintComponent();
                    add(barricade);
                } else if (Speelveld.get(y).get(x) == 9) {
                    setBarricadeLabel(3);
                    barricade.paintComponent();
                    add(barricade);
                } else if (Speelveld.get(y).get(x) == 10){
                    add(speler.GUIspeler2());
                }else{
                    this.eindveld2 = new Eindveld2();
                    eindveld2.paintComponent();
                    add(eindveld2);
                }
            }
        }
        invalidate();
        validate();
    }

    //geeft de invoer door aan speler
    public void invoer(int i) {
        if (i == 6) {
            ESC();
        } else {
            speler.invoerSpeler(i);
        }
    }

    //roept het einde aan van menu
    public void einde() {
        Menu.End();
    }
    
    //geeft de level pin door
    public int getLevel() {
        return this.level;
    }
}
