package doolhofgamemain;

import java.awt.*;
import javax.swing.*;

/*
 * Project: Doolhofspel Mario Edition
 * Authors: Justin Ulsamer, Leonie Mostard, Quang Hang
 * Group: 3.1.4
 * Version: 2.3
 * Date: 5-4-2018
 */
public class Muur extends JPanel {

    private JLabel label = new JLabel();

    //voegt een afbeelding toe aan de JPanel
    public void paintComponent() {
        label.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/muur.png")));
        add(label);
    }
}
