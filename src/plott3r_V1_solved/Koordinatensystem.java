package plott3r_V1_solved;

public class Koordinatensystem {
    final int wert; //Wert fürs Koordinatensystem, z.B. 5: -5 und 5 in X Richtung, 5 und -5 in Y Richtung

    public Koordinatensystem(int wert) {
        this.wert = wert;
    }

    public int getWert() {
        return wert;
    }
}
