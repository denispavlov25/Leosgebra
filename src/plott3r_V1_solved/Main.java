package plott3r_V1_solved;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Roboter roboter = new Roboter();
        Koordinatensystem koordinatensystem = new Koordinatensystem(5);
        Printer printer = new Printer(roboter, koordinatensystem);
        printer.zeichneFunktion(x -> 2 * x + 5);
        //von rechts nach links den Ursprung wechseln
        //dann resetTachoCounts
        //dann currentPosition aktualisieren(also den Ursprung updaten)

    }
}
