package calculator;

public class Percent extends Operations{
	public Percent(double numb1, double numb2) {
		super(numb1, numb2);
		double result;
	}
	
	public double calculate() {
		try {
		checkNegativity();
		return getNumb2() * (getNumb1()/100);
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getClass().getSimpleName());
		}
		catch(Exception e) {
			System.err.println("Geben Sie eine Zahl ein!" + e.getClass().getSimpleName());
		}
		return 0;
	}
	
	public void checkNegativity() {
		if(getNumb1() < 0 || getNumb2() < 0) {
			throw new IllegalArgumentException("Die Zahlen sollen positiv sein!");
		}
	}
}
