package unit_0_java_basics;
/**
 * Cash register program with 3 products plus tax.
 * @author Bianca
 * @version Sept. 11, 2023
 */
public class A2E3 {

	public static void main(String[] args) {
		// Variables
		double glove = 12.89;
		double toque = 18.99;
		double scarf = 20.00;
		final double HST = 0.13;

		// Calculate HST and total
		double tax = (glove + toque + scarf) * HST;
		double total = glove + toque + scarf + tax;
		double percent = HST * 100;
		
		// Print
		System.out.println("WOSS Gift Shop Receipt");
		System.out.println("----------------------\n");
		System.out.format("%-10s", "glove");
		System.out.format("%5s%5.2f\n", "$", glove);
		System.out.format("%-10s", "toque");
		System.out.format("%5s%5.2f\n", "$", toque);
		System.out.format("%5s", "scarf");
		System.out.format("%10s%5.2f\n", "$", scarf);
		System.out.format("%22s", "-------\n");
		System.out.format("%s%.0f%s", "HST (", percent, "%)");
		System.out.format("%6s%5.2f\n", "$", tax);
		System.out.format("%22s", "-------\n");
		System.out.format("%-10s", "TOTAL");
		System.out.format("%5s%5.2f\n", "$", total);

	}

}
