package calculator;
import java.math.*;

public class SquareRoot extends Operations {
	public SquareRoot(double numb1, double numb2) {
		super(numb1, numb2);
	}
	
	public void calculate() {
		try {
		checkInrange();
		double result = Math.pow(getNumb1(), getNumb2());
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getClass().getSimpleName());
		}
		catch(Exception e) {
			System.err.println("Geben Sie eine Zahl ein!" + e.getClass().getSimpleName());
		}
	}
	
	public void checkInrange() {
		if(getNumb2() < -20 || getNumb2() > 20) {
			throw new IllegalArgumentException("Die Hochzahl muss im Bereich (-20 bis 20) liegen");
		}
	}
}
