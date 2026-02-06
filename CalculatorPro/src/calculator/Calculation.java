package calculator;
import java.util.Scanner;

public class Calculation {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int decision = mainMenu(scan);
		double[] numbs = Numbers(scan);
		Division(scan, decision, numbs);
	}
	
	
	
	public static int mainMenu(Scanner scan) {
		System.out.println("===================== [Menü] =====================\n"
				+ " Was möchten Sie rechnen\n"
				+ "[1] Division\n"
				+ "[2] Wurzel ziehen\n"
				+ "[3] Potenzieren\n"
				+ "[4] Logarithmus\n"
				+ "[5] Prozentrechnung\n"
				+ "[6] Produkt aller Zahlen\n"
				+ "==================================================");
		return scan.nextInt(); }
	
	public static double[] Numbers(Scanner scan) {
		double[] numbs = new double[2];
		System.out.println("Geben Sie die erste Zahl an: "); numbs[0] = scan.nextInt();
		System.out.println("Geben Sie die zweite Zahl an: "); numbs[1] = scan.nextInt();
		return numbs;
		}
	
	public static void Division(Scanner scan, int decision, double[] numbs) {
		if(decision == 1) {
		Division divison = new Division(numbs[0], numbs[1]);
		divison.calculate();
	}}
	
	public static void SquareRoot(Scanner scan, int decision, double[] numbs) {
		if(decision == 2) {
			
		}
	}
	
	}
