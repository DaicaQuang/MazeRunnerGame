///* WERKT NIET!
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package doolhofgamemain;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Justin Ulsamer
// */
//public class SpelerTest {
//    private Menu Menu = new Menu();
//    private SpeelVeld speelveld = new SpeelVeld(Menu);
//    private Speler speler = new Speler(speelveld);
//    private speler1 speler1 = new speler1(speler);
//    private speler2 speler2 = new speler2(speler);
//    
//
//    public SpelerTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    /**
//     * Test of lopen method, of class Speler.
//     */
//    @Test
//    public void testLopen() throws InterruptedException {
//        System.out.println("lopen");
//        Menu.startScreen();
//        Menu.LevelSelect();
//        Menu.start(1);
//        speler.lopen(0, 1, 0, 0, 0, false, 1);
//        int verwacht = 1;
//        assertEquals(verwacht, speelveld.getObject(0, 1));
//        verwacht = 0;
//        assertEquals(verwacht, speelveld.getObject(1, 0));
//    }
//
//}
