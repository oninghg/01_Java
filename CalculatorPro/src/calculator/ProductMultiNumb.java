package calculator;

public class ProductMultiNumb extends Operations {
	public ProductMultiNumb(double numb1, double numb2) {
		super(numb1, numb2);
	}
	
	public void calculate() {
		try {
			checkNumb();
			double result = getNumb1();
		for(double i = getNumb1(); i <= getNumb2(); i++) {
			result = result * i;
		}
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getClass().getSimpleName());
		}
		catch(Exception e) {
			System.err.println("Geben Sie eine Zahl ein!" + e.getClass().getSimpleName());
		}
	}
	
	public void checkNumb() {
		if(getNumb1() > getNumb2()) {
			throw new IllegalArgumentException("Die erste Zahl soll nicht größer sein als die Zweite!");
		}
	}
	
	}

