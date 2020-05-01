package doolhofgamemain;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * Project: Doolhofspel Mario Edition
 * Authors: Justin Ulsamer, Leonie Mostard, Quang Hang
 * Group: 3.1.4
 * Version: 2.3
 * Date: 5-4-2018
 */
public class GUIpauze extends JPanel {

    private Menu Menu;
    private int level;
    private JButton Hervatten = new JButton("Resume");
    private JButton Retry = new JButton("Retry");
    private JButton Restart = new JButton("Restart");
    private JButton ExitToMenu = new JButton("Exit to Menu");

    private ActionListener HervattenListener = new GUIpauze.HervattenListener(this);
    private ActionListener RetryListener = new GUIpauze.RetryListener(this);
    private ActionListener RestartListener = new GUIpauze.RestartListener(this);
    private ActionListener ExitToMenuListener = new GUIpauze.ExitToMenuListener(this);

    public GUIpauze(Menu Menu) {
        this.Menu = Menu;
        Hervatten.addActionListener(HervattenListener);
        Retry.addActionListener(RetryListener);
        Restart.addActionListener(RestartListener);
        ExitToMenu.addActionListener(ExitToMenuListener);
    }
    
    //Bepaald wat er in de JPanel komt.
    public void paintcomponent() {
        removeAll();
        if (level == 4) {
            setLayout(new GridLayout(4, 1));
            add(Hervatten);
            add(Retry);
            add(Restart);
            add(ExitToMenu);
        } else {
            setLayout(new GridLayout(3, 1));
            add(Hervatten);
            add(Retry);
            add(ExitToMenu);
        }
    }
    
    //zet het level in GUIpauze
    public void setLevel(int level) {
        this.level = level;
    }

    //gaat verder met het spel in menu
    public void Hervatten() {
        Menu.Hervatten();
    }

    //start het spel opnieuw op in menu
    public void Retry() {
        Menu.Retry();
    }

    //gaat terug naar het startmenu van uit pauze in menu
    public void ExitToMenu() {
        Menu.ExitToMenu();
    }

    public void Restart() {
        Menu.restart();
    }

    //de listener van Hervatten
    class HervattenListener implements ActionListener {

        private GUIpauze GUIpauze;

        public HervattenListener(GUIpauze GUIpauze) {
            this.GUIpauze = GUIpauze;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            GUIpauze.Hervatten();
        }

    }

    //de listener van retry
    class RetryListener implements ActionListener {

        private GUIpauze GUIpauze;

        public RetryListener(GUIpauze GUIpauze) {
            this.GUIpauze = GUIpauze;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            GUIpauze.Retry();
        }

    }

    //de listener van restart
    class RestartListener implements ActionListener {

        private GUIpauze GUIpauze;

        public RestartListener(GUIpauze GUIpauze) {
            this.GUIpauze = GUIpauze;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            GUIpauze.Restart();
        }

    }

    //de listener van exit to menu
    class ExitToMenuListener implements ActionListener {

        private GUIpauze GUIpauze;

        public ExitToMenuListener(GUIpauze GUIpauze) {
            this.GUIpauze = GUIpauze;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            GUIpauze.ExitToMenu();
        }

    }
}
