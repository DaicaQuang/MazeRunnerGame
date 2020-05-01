package doolhofgamemain;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

/*
 * Project: Doolhofspel Mario Edition
 * Authors: Justin Ulsamer, Leonie Mostard, Quang Hang
 * Group: 3.1.4
 * Version: 2.3
 * Date: 5-4-2018
 */
public class Menu extends JFrame {

    private int level;
    private SpeelVeld SpeelVeld;
    private GUIstart GUIstart;
    private GUIpauze GUIpauze;
    private LevelSelect LevelSelect;
    private int teller = 0;
    private JLabel startScreen1 = new JLabel();
    private JLabel startScreen2 = new JLabel();
    private JLabel startScreen3 = new JLabel();
    private JLabel startScreen4 = new JLabel();
    private JLabel startScreen5 = new JLabel();
    private KeyListener listener;
    private Legenda legenda;
    private JPanel message = new JPanel();
    private JLabel messageLabel = new JLabel();
    private JLabel messageText = new JLabel("Congratulations, you won!");

    public Menu() {
        legenda = new Legenda(this);
        GUIstart = new GUIstart(this);
        GUIpauze = new GUIpauze(this);
        LevelSelect = new LevelSelect(this);
        SpeelVeld = new SpeelVeld(this);

        messageLabel.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/win.gif")));
        message.setLayout(new GridLayout(2, 1));
        message.add(messageLabel);
        message.add(messageText);
    }

    //start het startscreen van het programma door verschillende afbeelding toe te voegen
    public void startScreen() throws InterruptedException {
        startScreen1.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/StartSreen1.png")));
        startScreen2.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/StartSreen2.png")));
        startScreen3.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/StartSreen3.png")));
        startScreen4.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/StartSreen4.png")));
        startScreen5.setIcon(new ImageIcon(getClass().getResource("/doolhofgamemain/StartSreen5.png")));
        setSize(750, 500);
        setTitle("Maze Walker: Mario Edition");
        ImageIcon img = new ImageIcon(getClass().getResource("/doolhofgamemain/speler.png"));
        setIconImage(img.getImage());
        add(startScreen1);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        TimeUnit.SECONDS.sleep(1);
        remove(startScreen1);
        add(startScreen2);
        repaintMenu();
        TimeUnit.SECONDS.sleep(1);
        remove(startScreen2);
        add(startScreen3);
        repaintMenu();
        TimeUnit.SECONDS.sleep(1);
        remove(startScreen3);
        add(startScreen4);
        repaintMenu();
        TimeUnit.SECONDS.sleep(1);
        remove(startScreen4);
        add(startScreen5);
        repaintMenu();
        TimeUnit.SECONDS.sleep(1);
        startMenu();
    }

    //na het startscherm wordt het startmenu gestart
    public void startMenu() {
        getContentPane().remove(startScreen5);
        setSize(250, 300);
        add(GUIstart);
        repaintMenu();
    }

    //startmenu wordt weggehaalt en het level menu komt omhoog
    public void LevelSelect() {
        getContentPane().remove(GUIstart);
        add(LevelSelect);
        repaintMenu();
    }

    //level menu wordt weggehaalt en het start menu komt terug
    public void Back() {
        getContentPane().remove(LevelSelect);
        add(GUIstart);
        repaintMenu();
    }

    //het spel wordt pauze gezet en het pauze menu wordt opgestart
    public void pauze() {
        legenda.setVisible(false);
        getContentPane().remove(SpeelVeld);
        setSize(250, 300);
        GUIpauze.paintcomponent();
        add(GUIpauze);
        removeKeyListener(listener);
        repaintMenu();
    }

    //vanuit het pauzemenu terug naar het startmenu
    public void ExitToMenu() {
        getContentPane().remove(GUIpauze);
        add(GUIstart);
        repaintMenu();
    }

    //vanuit het pauzemenu terug naar het spel
    public void Hervatten() {
        legenda.setVisible(true);
        getContentPane().remove(GUIpauze);
        setSize(570, 570);
        add(SpeelVeld);

        repaintMenu();
        addKeyListener(listener);
        this.requestFocus();
    }

    //het zelfde level opnieuw starten.
    public void Retry() {
        legenda.setVisible(true);
        getContentPane().remove(GUIpauze);
        setSize(570, 570);
        SpeelVeld.reset();
        SpeelVeld.vulVanafBackup();
        SpeelVeld.paintcomponent();
        add(SpeelVeld);

        repaintMenu();
        addKeyListener(listener);
        this.requestFocus();
    }

    //revalidate en repaint het frame
    public void repaintMenu() {
        getContentPane().invalidate();
        getContentPane().validate();
        repaint();
    }

    //start het level
    public void start(int level) {
        legenda.setVisible(true);
        this.level = level;
        GUIpauze.setLevel(level);
        SpeelVeld.reset();
        SpeelVeld.setLevel(level);
        SpeelVeld.vulArray();
        SpeelVeld.paintcomponent();
        getContentPane().remove(LevelSelect);
        setSize(570, 570);
        add(SpeelVeld);
        repaintMenu();
        this.listener = new KeyListenerImpl(this, level);
        addKeyListener(listener);
        this.requestFocus();
    }

    //restart het level, maakt een nieuw random aan
    public void restart() {
        legenda.setVisible(true);
        SpeelVeld.reset();
        SpeelVeld.setLevel(4);
        SpeelVeld.vulArray();
        SpeelVeld.paintcomponent();
        getContentPane().remove(GUIpauze);
        setSize(570, 570);
        add(SpeelVeld);
        repaintMenu();
        this.listener = new KeyListenerImpl(this, level);
        addKeyListener(listener);
        this.requestFocus();

    }

    //beeindig het spel
    public void End() {
        legenda.setVisible(false);
        JOptionPane.showMessageDialog(null, message);
        getContentPane().remove(SpeelVeld);
        setSize(250, 300);
        add(GUIstart);
        removeKeyListener(listener);
        repaintMenu();
    }

    //geef invoer door aan speelveld
    public void Invoer(int i) {
        SpeelVeld.invoer(i);
    }

    //keyListeners die de invoer doorgeven aan Invoer()
    class KeyListenerImpl implements KeyListener {

        private Menu Menu;
        private int level;

        public KeyListenerImpl(Menu Menu, int level) {
            this.Menu = Menu;
            this.level = level;
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (level == 5) {
                if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W') {
                    Menu.Invoer(1);
                }
                if (e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
                    Menu.Invoer(2);
                }
                if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
                    Menu.Invoer(3);
                }
                if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
                    Menu.Invoer(4);
                }
                if (e.getKeyCode() == 38) {
                    Menu.Invoer(7);
                }
                if (e.getKeyCode() == 40) {
                    Menu.Invoer(8);
                }
                if (e.getKeyCode() == 39) {
                    Menu.Invoer(9);
                }
                if (e.getKeyCode() == 37) {
                    Menu.Invoer(10);
                }
                if (e.getKeyChar() == 'k' || e.getKeyChar() == 'K') {
                    Menu.Invoer(11);
                }
            } else {
                if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W' || e.getKeyCode() == 38) {
                    Menu.Invoer(1);
                }
                if (e.getKeyChar() == 's' || e.getKeyChar() == 'S' || e.getKeyCode() == 40) {
                    Menu.Invoer(2);
                }
                if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A' || e.getKeyCode() == 37) {
                    Menu.Invoer(3);
                }
                if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D' || e.getKeyCode() == 39) {
                    Menu.Invoer(4);
                }
            }
            if (e.getKeyChar() == 'e' || e.getKeyChar() == 'E' || e.getKeyCode() == 69) {
                Menu.Invoer(5);
            }

            if (e.getKeyCode() == 27) {
                Menu.Invoer(6);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
