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
public class GUIstart extends JPanel {
    private Menu Menu;
    private JButton Start = new JButton("Start");
    private JButton Exit = new JButton("Exit");

    private ActionListener startListener = new StartListener(this);
    private ActionListener ExitListener = new ExitListener();

    public GUIstart(Menu Menu) {
        this.Menu = Menu;
        this.Start.addActionListener(startListener);
        this.Exit.addActionListener(ExitListener);

        setLayout(new GridLayout(2, 1));
        add(Start);
        add(Exit);
    }
    
    //zorgt ervoor dat Levelselect in menu wordt aangezet
    public void MenuLevelSelect(){
        Menu.LevelSelect();
    }

    //Listener van start die de Levelselect in this zal aanroepen
    class StartListener implements ActionListener {

        private GUIstart GUIstart;

        public StartListener(GUIstart GUIstart) {
            this.GUIstart = GUIstart;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            GUIstart.MenuLevelSelect();
        }
    }
    
    //listener van exit die het programma sluit als je op exit klikt
    class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
