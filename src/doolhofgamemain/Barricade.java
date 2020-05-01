package doolhofgamemain;

import javax.swing.*;

/*
 * Project: Doolhofspel Mario Edition
 * Authors: Justin Ulsamer, Leonie Mostard, Quang Hang
 * Group: 3.1.4
 * Version: 2.3
 * Date: 5-4-2018
 */
public class Barricade extends JPanel {

    private int pincode1 = 1;
    private int pincode2 = 2;
    private int pincode3 = 3;
    private JLabel label = new JLabel();

    //geeft de pincode terug van de barricade
    public int getPincode(int i) {
        if (i == 1) {
            return this.pincode1;
        } else if (i == 2) {
            return this.pincode2;
        } else {
            return this.pincode3;
        }
    }

    //voegt een afbeelding toe aan de JLabel
    public void setPin(int pin) {
        if (pin == 1) {
            label.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/barricade1.png")));
        } else if (pin == 2) {
            label.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/barricade2.png")));
        } else {
            label.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/barricade3.png")));
        }
    }

    //voegt de JLabel toe aan de JPanel
    public void paintComponent() {
        add(label);
    }
}
