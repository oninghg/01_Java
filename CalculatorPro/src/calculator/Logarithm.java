package calculator;
import java.math.*;

public class Logarithm extends Operations {
	public Logarithm(double numb1, double numb2) {
		super(numb1, numb2);
		double result;
	}
	
	public double calculate() {
		try {
		checkNumb1();
		checkNumb2();
		return Math.log(getNumb1()) / Math.log(getNumb2());
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getClass().getSimpleName());
		}
		catch(Exception e) {
			System.err.println("Geben Sie eine Zahl ein!" + e.getClass().getSimpleName());
		}
		return 0;
	}
	
	public void checkNumb1() {
		if(getNumb1() <= 1) {
			throw new IllegalArgumentException("Die erste Zahl darf nicht 1 oder negativ sein");
		}
	}
	
	public void checkNumb2() {
		if(getNumb2() < 0) {
			throw new IllegalArgumentException("Die zweite Zahl darf nicht negativ sein");
		}
	}
}
