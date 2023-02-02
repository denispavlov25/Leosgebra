package plott3r_V1_solved;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Roboter roboter = new Roboter();
        Koordinatensystem koordinatensystem = new Koordinatensystem(30);
        roboter.bereitePapierVor();
        roboter.moveToHomePosition();
        Printer printer = new Printer(roboter, koordinatensystem);
        printer.zeichneFunktion(new Function<Double, Double>() {

			@Override
			public Double apply(Double value) {
				return -(value*value);
			} });

    }
}
