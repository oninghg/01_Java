package calculator;
import java.math.*;

public class RootExtract extends Operations {
	public RootExtract(double numb1, double numb2) {
		super(numb1, numb2);
		double result;
	
	public double calculate() {
		try {
		checkNull();
		checkNegativity();
		return Math.pow(getNumb2(), 1/getNumb1());
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getClass().getSimpleName());
		}
		catch(Exception e) {
			System.err.println("Geben Sie eine Zahl ein!" + e.getClass().getSimpleName());
		}
		return 0;
	}
	
	public void checkNull() {
		if(getNumb1() == 0) {
			throw new IllegalArgumentException("Die erste Zahl darf nicht null sein!");
		}
	}
	
	public void checkNegativity() {
		if(getNumb1() % 2 == 0 && getNumb2() < 0) {
			throw new IllegalArgumentException("Die zweite Zahl darf nicht Negativ sein");
		}
	}
	
}
