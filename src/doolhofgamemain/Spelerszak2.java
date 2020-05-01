package doolhofgamemain;

/*
 * Project: Doolhofspel Mario Edition
 * Authors: Justin Ulsamer, Leonie Mostard, Quang Hang
 * Group: 3.1.4
 * Version: 2.3
 * Date: 5-4-2018
 */
public class Spelerszak2 {

    private boolean heeftSleutel;
    private int sleutel;
    
    //stuurt de sleutelcode terug
    public int getSleutel() {
        return this.sleutel;
    }

    //zet de sleutel code 
    public void setSleutel(int sleutel) {
        this.sleutel = sleutel;
        this.heeftSleutel = true;
    }

    //kijkt of er uberhaupt wel een sleutel is
    public boolean getHeeftSleutel() {
        return this.heeftSleutel;
    }

    //reset de spelerzak
    public void resetSpelerszak() {
        this.heeftSleutel = false;
    }
}
