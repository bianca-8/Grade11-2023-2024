package unit_0_java_basics;

public class PaperPractice1 {

	public static void main(String[] args) {
		double flour = 1;
		double milk = 0.5;
		int egg = 1;
		
		System.out.println("Ingredients:");
		System.out.format("%9s %.0f %s\n", "-", flour, "cup flour");
		System.out.format("%9s %.1f %s\n", "-", milk, "cup milk");
		System.out.format("%9s %d %s", "-", egg, "large egg");

	}

}
