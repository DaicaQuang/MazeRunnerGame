package doolhofgamemain;

/*
 * Project: Doolhofspel Mario Edition
 * Authors: Justin Ulsamer, Leonie Mostard, Quang Hang
 * Group: 3.1.4
 * Version: 2.3
 * Date: 5-4-2018
 */
public class speler1 {

    private GUIspeler GUIspeler;
    private int oldx = 0;
    private int oldy = 0;
    private int x = 0;
    private int y = 0;
    private boolean staatOpSleutel = false;
    private Speler speler;
    private int vorigePlek = 0;
    private Spelerszak spelerszak;
    private boolean eindveld = false;
    private int sleutelcode;

    public speler1(Speler speler) {
        this.spelerszak = new Spelerszak();
        this.speler = speler;
    }
    
    //krijgt en geeft GUIspeler door aan speelveld
    public GUIspeler GUIspeler() {
        this.GUIspeler = new GUIspeler();
        GUIspeler.paintComponent();
        return this.GUIspeler;
    }
    
    //krijgt en geeft heeftSleutel door aan kanLopen
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
        if (i == 1) {
            //W
            this.y--;
            speler.lopen(x, y, oldx, oldy, vorigePlek, eindveld, 1);
        } else if (i == 2) {
            //S
            this.y++;
            speler.lopen(x, y, oldx, oldy, vorigePlek, eindveld, 1);
        } else if (i == 3) {
            //A
            this.x--;
            speler.lopen(x, y, oldx, oldy, vorigePlek, eindveld, 1);
        } else if (i == 4) {
            //D
            this.x++;
            speler.lopen(x, y, oldx, oldy, vorigePlek, eindveld, 1);
        } else if (i == 5) {
            //E
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
        this.y = 0;
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
