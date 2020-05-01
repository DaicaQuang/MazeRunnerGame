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
public class Legenda extends JFrame {

    private Menu Menu;
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();

    private JLabel controls1 = new JLabel();
    private JLabel controls2 = new JLabel();
    private JLabel controls3 = new JLabel();

    private JLabel spelerLabel = new JLabel();
    private JLabel spelerIconLabel = new JLabel();
    private JLabel speler1Icon = new JLabel();
    private JLabel speler2Icon = new JLabel();

    private JLabel muurLabel = new JLabel();
    private JLabel muurIcon = new JLabel();

    private JLabel blokLabel = new JLabel();
    private JLabel blokIcon = new JLabel();

    private JLabel barricade1Label = new JLabel();
    private JLabel barricade1Icon = new JLabel();
    private JLabel barricade2Label = new JLabel();
    private JLabel barricade2Icon = new JLabel();
    private JLabel barricade3Label = new JLabel();
    private JLabel barricade3Icon = new JLabel();

    private JLabel eindveldLabel = new JLabel();
    private JLabel eindveldIconLabel = new JLabel();
    private JLabel eindveld1Icon = new JLabel();
    private JLabel eindveld2Icon = new JLabel();

    private JLabel sleutel1Label = new JLabel();
    private JLabel sleutel1Icon = new JLabel();
    private JLabel sleutel2Label = new JLabel();
    private JLabel sleutel2Icon = new JLabel();
    private JLabel sleutel3Label = new JLabel();
    private JLabel sleutel3Icon = new JLabel();

    public Legenda(Menu menu) {
        this.Menu = menu;
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocation(Menu.getX() + Menu.getWidth(), Menu.getY());
        setLayout(new GridLayout(1, 2));
        panel1();
        panel2();
        add(panel1);
        add(panel2);
        setTitle("Info box");
        ImageIcon img = new ImageIcon(getClass().getResource("/doolhofgamemain/speler.png"));
        setIconImage(img.getImage());
    }
    
    //voeg alle onderdelen toe aan de panel1
    public void panel1() {
        panel1.setLayout(new GridLayout(10, 2));

        spelerLabel.setText("player 1 & 2= ");
        speler1Icon.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/speler.png")));
        speler2Icon.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/speler2.png")));
        spelerIconLabel.setLayout(new GridLayout(1, 2));
        spelerIconLabel.add(speler1Icon);
        spelerIconLabel.add(speler2Icon);
        panel1.add(spelerLabel);
        panel1.add(spelerIconLabel);

        muurLabel.setText("Wall = ");
        muurIcon.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/muur.png")));
        panel1.add(muurLabel);
        panel1.add(muurIcon);

        blokLabel.setText("Field = ");
        blokIcon.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/blok.png")));
        panel1.add(blokLabel);
        panel1.add(blokIcon);

        barricade1Label.setText("barricade 1 = ");
        barricade1Icon.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/barricade1.png")));
        panel1.add(barricade1Label);
        panel1.add(barricade1Icon);

        barricade2Label.setText("barricade 2 = ");
        barricade2Icon.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/barricade2.png")));
        panel1.add(barricade2Label);
        panel1.add(barricade2Icon);

        barricade3Label.setText("barricade 3 = ");
        barricade3Icon.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/barricade3.png")));
        panel1.add(barricade3Label);
        panel1.add(barricade3Icon);

        sleutel1Label.setText("Key 1 = ");
        sleutel1Icon.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/sleutel1.png")));
        panel1.add(sleutel1Label);
        panel1.add(sleutel1Icon);

        sleutel2Label.setText("Key 2 = ");
        sleutel2Icon.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/sleutel2.png")));
        panel1.add(sleutel2Label);
        panel1.add(sleutel2Icon);

        sleutel3Label.setText("Key 3 = ");
        sleutel3Icon.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/sleutel3.png")));
        panel1.add(sleutel3Label);
        panel1.add(sleutel3Icon);

        eindveldLabel.setText("Endpoint 1 & 2= ");
        eindveld1Icon.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/eindveld.png")));
        eindveld2Icon.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/eindveld2.png")));
        eindveldIconLabel.setLayout(new GridLayout(1, 2));
        eindveldIconLabel.add(eindveld1Icon);
        eindveldIconLabel.add(eindveld2Icon);
        panel1.add(eindveldLabel);
        panel1.add(eindveldIconLabel);
    }
    
    //voegt alle onderdelen toe aan panel2
    public void panel2() {
        panel2.setLayout(new GridLayout(3, 1));

        controls1.setText("W/↑ = up,   S/↓ = down");
        controls2.setText("D/→ = right,   A/← = left");
        controls3.setText("E = pick up,   ESC = pause");
        panel2.add(controls1);
        panel2.add(controls2);
        panel2.add(controls3);

    }
}
