package plott3r_V1_solved;
 
import positions.Position2D;


public class Printer {
    final int deltaX = 5; //5 Schritte beim Zeichnen bzw. Verbinden der Linie
    int offsetX = 85; //eine Art Konstante (die ungef�hre Mitte des A4-Blattes) in mm
    int offsetY = 125;

    Koordinatensystem koordinatensystem;
    Roboter roboter;

    public Printer(Roboter roboter, Koordinatensystem koordinatensystem) throws InterruptedException {
        this.roboter = roboter;
        this.koordinatensystem = koordinatensystem;
        this.zeicheKoordinatenSystem(koordinatensystem);
    }

    private void zeicheKoordinatenSystem(Koordinatensystem koordinatensystem) throws InterruptedException {
        roboter.getZAchse().deaktiviere();//Stift absetzen
        roboter.moveToPosition(new Position2D(- koordinatensystem.getWert() + offsetX, 0 + offsetY),3000);
        roboter.getZAchse().aktiviere();//stift runter, um zu zeichnen
        roboter.moveToPosition(new Position2D(koordinatensystem.getWert() + offsetX, 0 + offsetY),3000);
        roboter.getZAchse().deaktiviere();
        roboter.moveToPosition(new Position2D(0 + offsetX, koordinatensystem.getWert() + offsetY),3000);
        roboter.getZAchse().aktiviere();
        roboter.moveToPosition(new Position2D(0 + offsetX, - koordinatensystem.getWert() + offsetY),3000);
        roboter.getZAchse().deaktiviere();
        /*hier wird Schritt f�r Schritt vom Ursprung, wo der Stift ist, das KS gezeichnet;
        * man muss aber beachten, dass wir nachdem wir das Papier vorbereitet haben, den Stift auf die andere Seite bringen m�ssen, damit die Werde des Rechners stimmen k�nnen*/

    }

    public void zeichneFunktion(Function <Double, Double> f) throws InterruptedException {
        int positionX = - koordinatensystem.getWert();
        roboter.getZAchse().deaktiviere();
        roboter.moveToPosition(new Position2D(positionX + offsetX, (int)(f.apply((double)positionX) + offsetY)),10);
        roboter.getZAchse().aktiviere();
        while (positionX <= koordinatensystem.getWert()) {//hier wird von linker Seite bis zur rechten Seite die Linie gezeichnet
            roboter.moveToPosition(new Position2D(positionX + offsetX, (int)(f.apply((double)positionX) + offsetY)),10);
            positionX += deltaX;
        }
        roboter.getZAchse().deaktiviere();
    }
}
