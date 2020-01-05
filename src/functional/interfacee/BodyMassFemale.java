package functional.interfacee;

public class BodyMassFemale implements BodyMassIndex {
	public double calculate(double weight, double height) {
		return (weight*0.95) / (height * height);
	}
}
