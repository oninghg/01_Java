package calculator;

public abstract class Operations {
	private double numb1;
	private double numb2;
	
	public Operations(double numb1, double numb2) {
		this.numb1 = numb1;
		this.numb2 = numb2;
	}
	
	public abstract double calculate();
	
	public double getNumb1() {
		return numb1;
	}
	
	public double getNumb2() {
		return numb2;
	}
}

