package doolhofgamemain;

/*
 * Project: Doolhofspel Mario Edition
 * Authors: Justin Ulsamer, Leonie Mostard, Quang Hang
 * Group: 3.1.4
 * Version: 2.3
 * Date: 5-4-2018
 */
public class speler2 {

    private GUIspeler2 GUIspeler;
    private int oldx = 0;
    private int oldy = 0;
    private int x = 0;
    private int y = 9;
    private boolean staatOpSleutel = false;
    private Speler speler;
    private int vorigePlek = 0;
    private Spelerszak2 spelerszak;
    private boolean eindveld = false;
    private int sleutelcode;

    public speler2(Speler speler) {
        this.spelerszak = new Spelerszak2();
        this.speler = speler;
    }
    
    //geeft GUIspeler2 van speler 2 door aan speelveld
    public GUIspeler2 GUIspeler() {
        this.GUIspeler = new GUIspeler2();
        GUIspeler.paintComponent();
        return this.GUIspeler;
    }

    //geeft heeftsleutel uit spelerzak
    public boolean heeftSleutel() {
        return spelerszak.getHeeftSleutel();
    }

    //zet staatOpSleutel op true of false
    public void setStaatOpSleutel(boolean staatOpSleutel, int i) {
        this.staatOpSleutel = staatOpSleutel;
        if (staatOpSleutel == true) {
            this.sleutelcode = i;
        }
    }
    
    //zet de vorigePlek
    public void setVorigePlek(int i){
        this.vorigePlek = i;
    }

    //reset de X en Y naar de oude X en Y
    public void resetXY() {
        this.x = this.oldx;
        this.y = this.oldy;
    }

    //verwerkt de invoer van de keylisteners
    public void invoerSpeler(int i) {
        this.oldx = this.x;
        this.oldy = this.y;
        if (i == 7) {
            //W2
            this.y--;
            speler.lopen(x, y, oldx, oldy, vorigePlek, eindveld, 2);
        } else if (i == 8) {
            //S2
            this.y++;
            speler.lopen(x, y, oldx, oldy, vorigePlek, eindveld, 2);
        } else if (i == 9) {
            //A2
            this.x++;
            speler.lopen(x, y, oldx, oldy, vorigePlek, eindveld, 2);
        } else if (i == 10) {
            //D2
            this.x--;
            speler.lopen(x, y, oldx, oldy, vorigePlek, eindveld, 2);
        } else if (i == 11) {
            //K
            if (this.staatOpSleutel) {
                this.vorigePlek = 0;
                setSleutel();
            }
        }
    }

    //kijk welke sleutel pincode in spelers zak zit
    public int getSleutel() {
        return spelerszak.getSleutel();
    }

    //zet de sleutelpin in spelerzak
    public void setSleutel() {
        spelerszak.setSleutel(speler.setSleutelInventory(this.sleutelcode));
    }

    //reset alle variabelen in deze class
    public void resetSpeler() {
        this.oldx = 0;
        this.oldy = 0;
        this.x = 0;
        this.y = 9;
        this.staatOpSleutel = false;
        this.vorigePlek = 0;
        this.spelerszak.resetSpelerszak();
        this.eindveld = false;
        this.sleutelcode = 0;
    }

    //zet eindveld
    public void setEindveld(boolean i) {
        this.eindveld = i;
    }
    
    //geeft eindveld
    public boolean getEindveld(){
        return this.eindveld;
    }
}
