package chapter1.enums;

public enum Planets {

	EARTH(12756), MARS(6792), JUPITER(142984); //Semicolon is required if there is anything in the enum besides the values.
	private int diameter;
	
	Planets(int diameter) { // for the enum constructor; only private is permitted
		this.diameter = diameter;
	}
	
	public void printDiameters(){
		System.out.println(diameter);
	}
	public static void main(String[] args){
		Planets.EARTH.printDiameters();
		System.out.println(Planets.EARTH);
		
		System.out.println(Planets.EARTH.name());
		System.out.println(Planets.EARTH.ordinal());
		
		for (Planets planet : Planets.values()) {
			System.out.println(planet);
		}
	}

}
