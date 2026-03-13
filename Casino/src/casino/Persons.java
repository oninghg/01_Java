package casino;

public abstract class Persons {
	private String name;
	public Persons(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract boolean performRole(int credits, int allcredits);
}
