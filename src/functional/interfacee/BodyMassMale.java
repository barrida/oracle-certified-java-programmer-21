package functional.interfacee;

class BodyMassMale implements BodyMassIndex{ 
	public double calculate(double weight, double height){
		return weight / (height * height);
	}
}
