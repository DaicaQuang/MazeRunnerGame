package doolhofgamemain;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * Project: Doolhofspel Mario Edition
 * Authors: Justin Ulsamer, Leonie Mostard, Quang Hang
 * Group: 3.1.4
 * Version: 2.3
 * Date: 5-4-2018
 */
public class SpeelVeldTest {

    public SpeelVeldTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of kanLopen method, of class SpeelVeld.
     */
    @Test
    public void testKanLopen() {
        System.out.println("kanLopen");
        Menu menu = new Menu();
        SpeelVeld speelveld = new SpeelVeld(menu);
        speelveld.setLevel(1);
        speelveld.vulArray();
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (speelveld.getObject(x, y) == 0) {
                    //blok (leeg veld), verwacht true 
                    boolean verwachtResultaat = true;
                    boolean resultaat = speelveld.kanLopen(x, y, 1);
                    assertEquals(verwachtResultaat, resultaat);
                } else if (speelveld.getObject(x, y) >= 2 && speelveld.getObject(x, y) <= 4) {
                    //Sleutel 1 t/m 3, verwacht true
                    boolean verwachtResultaat = true;
                    boolean resultaat = speelveld.kanLopen(x, y, 1);
                    assertEquals(verwachtResultaat, resultaat);
                } else if (speelveld.getObject(x, y) == 5) {
                    // eindveld, verwacht true
                    boolean verwachtResultaat = true;
                    boolean resultaat = speelveld.kanLopen(x, y, 1);
                    assertEquals(verwachtResultaat, resultaat);
                } else if (speelveld.getObject(x, y) == 6) {
                    // muur, verwacht false
                    boolean verwachtResultaat = false;
                    boolean resultaat = speelveld.kanLopen(x, y, 1);
                    assertEquals(verwachtResultaat, resultaat);
                } else if (speelveld.getObject(x, y) >= 7 && speelveld.getObject(x, y) <= 9) {
                    // barricade 1 t/m 3, verwacht false
                    boolean verwachtResultaat = false;
                    boolean resultaat = speelveld.kanLopen(x, y, 1);
                    assertEquals(verwachtResultaat, resultaat);
                }
            }
        }
    }

}
