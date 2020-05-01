package doolhofgamemain;

import javax.swing.*;

/*
 * Project: Doolhofspel Mario Edition
 * Authors: Justin Ulsamer, Leonie Mostard, Quang Hang
 * Group: 3.1.4
 * Version: 2.3
 * Date: 5-4-2018
 */
public class Sleutel extends JPanel{

    private int sleutel1 = 1;
    private int sleutel2 = 2;
    private int sleutel3 = 3;
    private JLabel label = new JLabel();

    //geeft de pincode terug van de sleutel
    public int getPincode(int i) {
        if (i == 1) {
            return this.sleutel1;
        } else if (i == 2) {
            return this.sleutel2;
        } else {
            return this.sleutel3;
        }
    }

    //voegt een afbeelding toe aan de JLabel
    public void setSleutelPin(int pin) {
        if (pin == 1) {
            label.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/sleutel1.png")));
        }else if(pin == 2){
            label.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/sleutel2.png")));
        }else{
            label.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/sleutel3.png")));
        }
    }

    //voegt de JLabel toe aan de JPanel
    public void paintComponent() {
        add(label);
    }
}
