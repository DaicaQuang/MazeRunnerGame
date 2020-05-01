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
public class LevelSelect extends JPanel {

    private Menu Menu;

    private JButton RandomLevel = new JButton("Random Level");
    private JButton Level1 = new JButton("Level 1");
    private JButton Level2 = new JButton("Level 2");
    private JButton Level3 = new JButton("Level 3");
    private JButton coop = new JButton("co-op");
    private JButton Back = new JButton("Back");

    private ActionListener RandomLevelListener = new RandomLevelListener(this);
    private ActionListener Level1Listener = new Level1Listener(this);
    private ActionListener Level2Listener = new Level2Listener(this);
    private ActionListener Level3Listener = new Level3Listener(this);
    private ActionListener coopListener = new coopListener(this);
    private ActionListener BackListener = new BackListener(this);

    public LevelSelect(Menu Menu) {
        this.Menu = Menu;
        this.RandomLevel.addActionListener(RandomLevelListener);
        this.Level1.addActionListener(Level1Listener);
        this.Level2.addActionListener(Level2Listener);
        this.Level3.addActionListener(Level3Listener);
        this.coop.addActionListener(coopListener);
        this.Back.addActionListener(BackListener);

        setLayout(new GridLayout(6, 1));
        add(Level1);
        add(Level2);
        add(Level3);
        add(RandomLevel);
        add(coop);
        add(Back);
    }

    //start het spel in menu met het gekozen level
    public void menuStart(int level) {
        Menu.start(level);
    }

    //keert terug naar startmenu in menu
    public void menuBack() {
        Menu.Back();
    }

    //listener naar de randomlevel button
    class RandomLevelListener implements ActionListener {

        private LevelSelect LevelSelect;

        public RandomLevelListener(LevelSelect levels) {
            this.LevelSelect = levels;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            LevelSelect.menuStart(4);
        }
    }

    //listener naar de level 1 button
    class Level1Listener implements ActionListener {

        private LevelSelect LevelSelect;

        public Level1Listener(LevelSelect levels) {
            this.LevelSelect = levels;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            LevelSelect.menuStart(1);
        }
    }

    //listener naar de level 2 button
    class Level2Listener implements ActionListener {

        private LevelSelect LevelSelect;

        public Level2Listener(LevelSelect levels) {
            this.LevelSelect = levels;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            LevelSelect.menuStart(2);
        }
    }

    //listener naar de level 3 button
    class Level3Listener implements ActionListener {

        private LevelSelect LevelSelect;

        public Level3Listener(LevelSelect levels) {
            this.LevelSelect = levels;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            LevelSelect.menuStart(3);
        }
    }
    //listener naar de cooplevel button
    class coopListener implements ActionListener {

        private LevelSelect LevelSelect;

        public coopListener(LevelSelect levels) {
            this.LevelSelect = levels;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            LevelSelect.menuStart(5);
        }
    }

    //listener naar de back button
    class BackListener implements ActionListener {

        private LevelSelect LevelSelect;

        public BackListener(LevelSelect levels) {
            this.LevelSelect = levels;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            LevelSelect.menuBack();
        }
    }

}
