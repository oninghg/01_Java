package calculator;
import java.util.Scanner;

public class Calculation {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int decision = mainMenu(scan);
		double[] numbs = Numbers(scan);
		Division(scan, decision, numbs);
		SquareRoot(scan, decision, numbs);
		RootExtract(scan, decision, numbs);
		Log(scan, decision, numbs);
		Percent(scan, decision, numbs);
		PMN(scan, decision, numbs);
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
			System.out.println(numbs[0] + " / " + numbs[1] + " = " + divison.calculate());
	}}
	
	public static void SquareRoot(Scanner scan, int decision, double[] numbs) {
		if(decision == 3) {
			SquareRoot sRoot = new SquareRoot(numbs[0], numbs[1]);
			System.out.println(numbs[0] + " hoch " + numbs[1] + " = " + sRoot.calculate());
		}}
	
	public static void RootExtract(Scanner scan, int decision, double[] numbs) {
		if(decision == 2) {
			RootExtract rExtract = new RootExtract(numbs[0], numbs[1]);
			System.out.println(numbs[0] + "te Wurzel von "+ numbs[1] + " = " + rExtract.calculate());
		}}
	
	public static void Log(Scanner scan, int decision, double[] numbs) {
		if(decision == 4) {
			Logarithm log = new Logarithm(numbs[0], numbs[1]);
			System.out.println(numbs[0] + " log " + numbs[1] + " = " + log.calculate());
		}}
	
	public static void Percent(Scanner scan, int decision, double[] numbs) {
		if(decision == 5) {
			Percent perc = new Percent(numbs[0], numbs[1]);
			System.out.println(numbs[0] + "% von " + numbs[1] + " = " + perc.calculate());
		}}
	
	public static void PMN(Scanner scan, int decision, double[] numbs) {
		if(decision == 6) {
			ProductMultiNumb pnm = new ProductMultiNumb(numbs[0], numbs[1]);
			System.out.println(pnm.calculate());
		}
	}
	}

