package calculator;

public class Division extends Operations {
	public Division(double numb1, double numb2) {
		super(numb1, numb2);
	}
	
	public void calculate() {
		try {
		checkNumb();
		double result = getNumb1() / getNumb2();
		}
		catch(IllegalArgumentException e) {
			System.err.println(e.getMessage());
			System.out.println(e.getClass().getSimpleName());
		}
		catch(Exception e) {
			System.err.println("Geben Sie eine Zahl ein!" + e.getClass().getSimpleName());
		}
	}
	
	public void checkNumb() {
		if(getNumb2() == 0) {
			throw new IllegalArgumentException("Nicht durch null dividieren!!!!!!!!!!");
		}
	}
}
